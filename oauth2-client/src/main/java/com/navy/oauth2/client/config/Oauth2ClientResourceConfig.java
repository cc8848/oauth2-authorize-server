/**
 * 
 */
package com.navy.oauth2.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 5:23:35 PM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@Configuration
@EnableResourceServer
public class Oauth2ClientResourceConfig extends ResourceServerConfigurerAdapter {

    /*
     * (non-Javadoc)
     *
     * @see
     *
     * org.springframework.security.oauth2.config.annotation.web.configuration.
     * ResourceServerConfigurerAdapter#configure(org.springframework.security.
     * config.annotation.web.builders.HttpSecurity)
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
    }

}
