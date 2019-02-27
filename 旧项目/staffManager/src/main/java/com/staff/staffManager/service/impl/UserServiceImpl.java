package com.staff.staffManager.service.impl;

import com.staff.staffManager.dao.UserDao;
import com.staff.staffManager.dao.entity.User;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.service.UserService;
import com.staff.staffManager.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private ResponseDto responseDto;

    private CommonUtil commonUtil = new CommonUtil();//实例化CommonUtil类;

    private User user;

    /**
     * @param userName
     * @param password
     * @return 返回一个ResponseDto
     * @Author 汪宁
     * 实现userService层的login方法
     */
    @Override
    public ResponseDto login(String userName, String password) {
        user = userDao.findUserByUserName(userName);//实现userDao中的通过UserName查找User
        if (user == null) {
            responseDto = commonUtil.error("error", "登陆失败！用户不存在！", "登陆失败！用户不存在！");
        } else {
            if (commonUtil.checkSpecialSymbol(password)) {//判断传入密码字符串是否有特殊字符
                if (user.getPassword().equals(commonUtil.encryption(password))) {//与数据库中的密码进行对比
                    responseDto = commonUtil.success("登陆成功！");
                } else {
                    responseDto = commonUtil.error("error", "登陆失败！密码错误！", "登陆失败！密码错误！");
                }
            } else {
                responseDto = commonUtil.error("error", "登陆失败！密码包含特殊字符！", "登陆失败！");
            }
        }
        return responseDto;
    }
}
