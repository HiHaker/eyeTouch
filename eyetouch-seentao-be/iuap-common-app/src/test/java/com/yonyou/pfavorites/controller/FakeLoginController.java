package com.yonyou.pfavorites.controller;

import com.yonyou.iuap.auth.token.ITokenProcessor;
import com.yonyou.iuap.auth.token.TokenParameter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 * 免登示例
 */
@RestController
public class FakeLoginController {

    @Autowired()
    protected ITokenProcessor webTokenProcessor;

    @Value("${defaultUrl}")
    String defaultUrl;

    @GetMapping(path = "/mock/login")
    public void loginHtml(HttpServletRequest request, HttpServletResponse response)
            throws NoSuchAlgorithmException, InvalidKeyException, IOException {

        Properties prop = new Properties();
        String usercode = "1";
        String userid = "1";
        String tenantid = "1";
        String userType = "userType";
        String typeAlias = "typeAlias";
        TokenParameter tp = new TokenParameter();
        tp.setUserid(usercode);
        // 设置登录时间
        tp.setLogints(String.valueOf(System.currentTimeMillis()));
        // 租户信息
        tp.getExt().put("tenantid", tenantid);
        tp.getExt().put("userId", userid);
        tp.getExt().put("userType", userType);
        tp.getExt().put("typeAlias", typeAlias);
        Cookie[] cookies = webTokenProcessor.getCookieFromTokenParameter(tp);
        for (Cookie cookie : cookies) {
            response.addCookie(cookie);
        }
         String r = request.getParameter("r");
        String rURL = defaultUrl;
        if(r != null) {
            rURL = new String(Base64.decodeBase64(r), "utf-8");
        }
        response.sendRedirect(rURL);
    }

}
