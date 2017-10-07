/**
 * 
 */
package com.navy.oauth2.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.navy.oauth2.server.properties.Oauth2ServerProperties;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 11:19:01 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@Configuration
public class TokenStoreConfig {

    @Configuration
    @ConditionalOnProperty(prefix = "navy.security.oauth2", name = "tokenStore", havingValue = "redis")
    public static class RedisStoreConfig {

        @Autowired
        private RedisConnectionFactory redisConnectionFactory;

        @Bean()
        public TokenStore redisTokenStore() {
            return new RedisTokenStore(redisConnectionFactory);
        }

    }

    @Configuration
    @ConditionalOnProperty(prefix = "navy.security.oauth2", name = "tokenStore", havingValue = "jwt", matchIfMissing = true)
    public static class JwtConfig {

        @Autowired
        private Oauth2ServerProperties oauth2ServerProperties;

        @Bean()
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setSigningKey(oauth2ServerProperties.getOauth2().getSigningKey());
            return converter;
        }

        @Bean
        @ConditionalOnBean(TokenEnhancer.class)
        public TokenEnhancer jwtTokenEnhancer() {
            return new TokenJwtEnhancer();
        }

    }
}
