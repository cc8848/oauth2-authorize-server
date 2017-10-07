/**
 * 
 */
package com.navy.oauth2.server.properties;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 9:39:57 AM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
public class Oauth2Properties {

    private String signingKey;

    private String tokenStore;

    private Oauth2ClientProperties[] clients = {};

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }

    public String getTokenStore() {
        return tokenStore;
    }

    public void setTokenStore(String tokenStore) {
        this.tokenStore = tokenStore;
    }

    public Oauth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(Oauth2ClientProperties[] clients) {
        this.clients = clients;
    }

}
