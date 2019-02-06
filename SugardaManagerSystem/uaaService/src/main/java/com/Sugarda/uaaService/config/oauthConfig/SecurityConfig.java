package com.Sugarda.uaaService.config.oauthConfig;

import com.Sugarda.uaaService.config.oauthConfig.accessTokenConfig.JwtTokenConfig;
import com.Sugarda.uaaService.config.oauthConfig.jedisConfig.MyRedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends AuthorizationServerConfigurerAdapter {

    @Resource // 这里的@Resource很关键,代码会自动去找RedisTemplate
    private RedisTemplate<String, Object> redisTemplate;

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
        //使用redis-cluster时使用以下内容(单节点时也可以使用)——自定义redisTokenStore，解决Pipeline is currently not supported for JedisClusterConnection.
        MyRedisTokenStore redisTokenStore = new MyRedisTokenStore();
        redisTokenStore.setRedisTemplate(redisTemplate);
        //使用单点redis时使用以下内容
        //RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
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

    /**
     * 使用非对称加密算法来对Token进行签名
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {

        final JwtAccessTokenConverter jwtAccessTokenConverter = new JwtTokenConfig();
        // 导入证书
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "crazyNing980214".toCharArray());
        jwtAccessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair("crazyNing"));
        return jwtAccessTokenConverter;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) {
        authorizationServerSecurityConfigurer
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Override // 配置框架应用上述实现
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //配置spring secuirity为验证方式
        endpoints.authenticationManager(authenticationManager);
        //配置token存储信息
        endpoints.tokenStore(tokenStore());
        //使用jwt作为accessToken
        endpoints.accessTokenConverter(jwtAccessTokenConverter());
        // refresh_token需要userDetailsService
        endpoints.reuseRefreshTokens(false).userDetailsService(userDetailsService);
        // 配置TokenServices参数,打开会导致jwt token失效，原因未知
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        //配置token存储位置(在上文配置)
//        tokenServices.setTokenStore(endpoints.getTokenStore());
//        //配置是否需要刷新token（refresh token）
//        tokenServices.setSupportRefreshToken(true);
//        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//        //tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//        //设置token超时时间，此处设置从配置文件读取
//        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(tokenStayTime));
//        endpoints.tokenServices(tokenServices);
    }
}
