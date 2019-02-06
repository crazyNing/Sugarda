package com.Sugarda.uaaService.config.oauthConfig.accessTokenConfig;

import com.Sugarda.uaaService.dao.entity.SugardaUser;
import com.Sugarda.uaaService.dao.entity.SugardaUserDetail;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class JwtTokenConfig extends JwtAccessTokenConverter {
    /**
     * 生成token
     *
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);

        // 设置额外用户信息
        SugardaUser sugardaUser = ((SugardaUserDetail) authentication.getPrincipal()).getSugardaUser();
        sugardaUser.setUserPassword(null);
        // 将用户信息添加到token额外信息中
        defaultOAuth2AccessToken.getAdditionalInformation().put("user_info", sugardaUser);
        return super.enhance(defaultOAuth2AccessToken, authentication);
    }

    /**
     * 解析token
     *
     * @param value
     * @param map
     * @return
     */
    @Override
    public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
        OAuth2AccessToken oauth2AccessToken = super.extractAccessToken(value, map);
        convertData(oauth2AccessToken, oauth2AccessToken.getAdditionalInformation());
        return oauth2AccessToken;
    }

    private void convertData(OAuth2AccessToken accessToken, Map<String, ?> map) {
        accessToken.getAdditionalInformation().put("user_info", convertUserData(map.get("user_info")));

    }

    private SugardaUser convertUserData(Object map) {
        String json = JsonUtils.deserializer(map);
        SugardaUser sugardaUser = JsonUtils.serializable(json, SugardaUser.class);
        return sugardaUser;
    }
}
