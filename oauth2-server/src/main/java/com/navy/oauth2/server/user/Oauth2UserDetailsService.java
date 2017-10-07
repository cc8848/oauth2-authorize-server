/**
 * 
 */
package com.navy.oauth2.server.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 10:02:22 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@Component("oauth2UserDetailsService")
public class Oauth2UserDetailsService implements UserDetailsService {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /* 查询用户信息 */
        Oauth2User user = new Oauth2User();
        user.setPassword("Charlie");
        user.setUsername("navy");
        return user;
    }

}
