package com.Sugarda.uaaService.config.oauthConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;


@Configuration
public class SecurityConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${Token.StayTime}") // 从配置文件读取token超时时长
    private long tokenStayTime;

    @Autowired // 配置自动装配
    private AuthenticationManager authenticationManager;

    @Autowired // 配置自动装配数据库数据源
    private DataSource dataSource;

    @Autowired // 自动装配RedisConnectionFactory
    private RedisConnectionFactory redisConnectionFactory;

    @Bean // 声明TokenStore实现
    public TokenStore tokenStore() {
        //使用redis存储token
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        return redisTokenStore;
        //使用数据库存储token
        //return new JdbcTokenStore(dataSource);
    }

    @Bean // 声明 ClientDetails实现
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override // 配置存储用户数据方式
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory() // 使用内存存储
//                .withClient("client") // client_id
//                .secret("secret") // client_secret
//                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
//                .scopes("app"); // 允许的授权范围
        clients.jdbc(dataSource);// 使用数据库存储
    }

    @Override // 配置框架应用上述实现
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //配置spring secuirity为验证方式
        endpoints.authenticationManager(authenticationManager);
        //配置token存储信息
        endpoints.tokenStore(tokenStore());
        // 配置TokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        //配置token存储位置(在上文配置)
        tokenServices.setTokenStore(endpoints.getTokenStore());
        //配置是否需要刷新token（refresh token）
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        //设置token超时时间，此处设置从配置文件读取
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(tokenStayTime));
        endpoints.tokenServices(tokenServices);
    }
}
