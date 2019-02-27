package com.staff.staffManager.util;

import com.staff.staffManager.dao.entity.Staff;
import com.staff.staffManager.dao.entity.vo.DPVo;
import com.staff.staffManager.dao.entity.vo.ResponseDto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

public class CommonUtil {

    /**
     * 访问成功时通用JSON返回方法
     *
     * @param object 传入的参数，永远返回
     * @return responseDto 返回使用通用JSON
     * @Author 汪宁
     */
    public ResponseDto success(Object object) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("success");
        responseDto.setMessage("操作成功！");
        responseDto.setData(object);
        return responseDto;
    }

    public ResponseDto error(String code, String message, Object object) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(code);
        responseDto.setMessage(message);
        responseDto.setData(object);
        return responseDto;
    }

    /**
     * 判断是否含有特殊符号
     *
     * @param str 待验证的字符串
     * @return true 不含特殊符号
     * @Author 汪宁
     */
    public boolean checkSpecialSymbol(String str) {
        //定义可能出现的特殊符号
        String pattern = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（） —|{}【】‘；：”“'。，、？\"]";
        for (int i = 0; i < str.length(); i++) {
            String a = str.substring(i, i + 1);
            if (pattern.indexOf(a) > -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 实现MD5加密密码
     *
     * @param string
     * @return 加密后的string
     * @Author 汪宁
     */
    public String encryption(String string) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(string.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通用岗位和部门中的重复逻辑判断
     *
     * @param dpVo
     * @param list
     * @return
     * @Author 汪宁
     */
    public ResponseDto DPHelp(DPVo dpVo, List list) {
        ResponseDto responseDto = new ResponseDto();
        if (dpVo == null) {
            responseDto = this.error("error", "输入值不能为空", "输入有误，请重试！");
        } else if (list.size() == 0) {
            responseDto = this.error("error", "所输入条件没有返回值", "输入有误，请重试！");
        } else {
            responseDto = this.success(list);
        }
        return responseDto;
    }
}

