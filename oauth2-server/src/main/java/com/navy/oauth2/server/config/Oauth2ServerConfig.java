/**
 * 
 */
package com.navy.oauth2.server.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.navy.oauth2.server.properties.Oauth2ClientProperties;
import com.navy.oauth2.server.properties.Oauth2ServerProperties;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 9:28:51 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private Oauth2ServerProperties oauth2ServerProperties;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService oauth2UserDetailsService;

    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenStore tokenStore;

    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;

    /**
     * 认证及token配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).userDetailsService(oauth2UserDetailsService)
                .tokenStore(tokenStore);
        if (null != jwtAccessTokenConverter) {
            TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancers = new ArrayList<>();
            enhancers.add(jwtAccessTokenConverter);
            if (null != jwtTokenEnhancer) {
                enhancers.add(jwtTokenEnhancer);
            }
            enhancerChain.setTokenEnhancers(enhancers);
            endpoints.tokenEnhancer(enhancerChain).accessTokenConverter(jwtAccessTokenConverter);
        }
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * 配置客户端信息
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        Oauth2ClientProperties[] clientConfig = oauth2ServerProperties.getOauth2().getClients();
        if (ArrayUtils.isNotEmpty(clientConfig)) {
            for (Oauth2ClientProperties client : clientConfig) {
                String[] grantTypes = client.getAuthorizedGrantTypes().split(",");
                builder.withClient(client.getClientId()).secret(client.getClientSecret())
                        .authorizedGrantTypes(grantTypes)
                        .accessTokenValiditySeconds(client.getAccessTokenValidateSeconds())
                        .refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
                        .scopes(client.getScopes());
            }
        }
    }

}
