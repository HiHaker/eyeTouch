package com.yonyou.pcomments.controller;
import com.yonyou.pcomments.service.OpenApiRequestService;
import com.yonyou.pcomments.service.SuiteService;
import com.yonyou.iuap.auth.token.ITokenProcessor;
import com.yonyou.iuap.auth.token.TokenParameter;
import com.yonyou.iuap.ucf.oe.open.isv.model.LoginFreeResponse;
import com.yonyou.iuap.ucf.oe.open.isv.model.Suite;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 免登示例
 */
@RestController
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private OpenApiRequestService requestService;

    @Autowired
    private SuiteService suiteService;
        @Autowired()
        protected ITokenProcessor webTokenProcessor;

   
    
    @GetMapping("/login")
    public void loginFree(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeyException, IOException {
                String code = request.getParameter("code");
                if(code == null)
                        code = request.getParameter("serviceCode");
                LOGGER.info("新的免登请求, code: {}", code);
        Suite suite = suiteService.getSuite(suiteService.getSuiteConfig().getSuiteKey());
        if (suite == null || suite.getSuiteTicket() == null) {
            throw new RuntimeException("套件尚未初始化，或尚未推送 ticket！");
        }

        LoginFreeResponse openAPIResponse = requestService.requestForLogin(suite.getSuiteKey(), code, suite.getSuiteTicket(), suite.getSuiteSecret());
        LOGGER.info("成功获得用户信息：{}", openAPIResponse);
        
        String usercode = openAPIResponse.getMemberId();
                String userid = openAPIResponse.getYhtUserId();
                String tenantid = openAPIResponse.getTenantId();
                String userType =   "userType" ;
                String typeAlias =  "typeAlias";
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
                String rURL = request.getParameter("k");
                if(r != null) {
                        rURL = new String(Base64.decodeBase64(r), "utf-8");
                }
                response.sendRedirect(rURL);
        
    }

}
