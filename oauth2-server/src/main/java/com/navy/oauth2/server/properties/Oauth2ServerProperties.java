/**
 * 
 */
package com.navy.oauth2.server.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 9:36:21 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@ConfigurationProperties(prefix = "navy.security")
public class Oauth2ServerProperties {

    private Oauth2Properties oauth2 = new Oauth2Properties();

    public Oauth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(Oauth2Properties oauth2) {
        this.oauth2 = oauth2;
    }

}
