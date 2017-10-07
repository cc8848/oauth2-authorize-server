/**
 * 
 */
package com.navy.oauth2.server;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.navy.oauth2.server.properties.Oauth2ServerProperties;

/**
 * 类描述：Oauth2 config
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 9:37:04 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@Configuration
@EnableConfigurationProperties(Oauth2ServerProperties.class)
public class Oauth2Config {

}
