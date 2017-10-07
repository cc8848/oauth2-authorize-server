/**
 * 
 */
package com.navy.oauth2.client.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 * 
 * @创建人：navy.chi@chinablackhawk.com
 * @创建时间：Oct 7, 2017 5:00:13 PM @修改人： @修改时间： @修改备注：
 * 
 * @版权：Copyright 2015 - 2017 神州黑鹰（上海）信息科技有限公司版权所有。
 */
@RestController
@RequestMapping("/client/oauth2")
public class Oauth2ClientController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
