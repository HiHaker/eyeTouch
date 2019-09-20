package com.yonyou.video.service;
import com.yonyou.iuap.ucf.oe.open.isv.model.Suite;
import com.yonyou.iuap.ucf.oe.open.isv.model.SuiteAuth;
import com.yonyou.iuap.ucf.oe.open.isv.model.SuiteConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟套件存储，请根据具体情况进行实现
 */
@Service
public class SuiteService {

        /**
         * 套件的key，也可以通过注解从配置文件中注入
         */
        @Value("${ucf.oe.suiteKey}")
        private String suiteKey ;
        
        /**
         * 套件的secret，也可以通过注解从配置文件中注入
         */
        @Value("${ucf.oe.suiteSecret}")
        private String suiteSecret ;
        
        /**
         * aes秘钥，也可以通过注解从配置文件中注入
         */
        @Value("${ucf.oe.encodingAESKey}")
        private String encodingAESKey;

        private SuiteConfig suiteConfig ;

        private Map<String, Suite> suiteStore = new ConcurrentHashMap<>();

        private Map<String, SuiteAuth> suiteAuthStore = new ConcurrentHashMap<>();

        public SuiteConfig getSuiteConfig() {
        if (suiteConfig == null) {
            suiteConfig = new SuiteConfig(
                    String.valueOf(suiteKey).trim()
                    , String.valueOf(suiteSecret).trim()
                    , String.valueOf(encodingAESKey).trim()
            );
        }
        return suiteConfig;
    }

        public void setSuiteConfig(SuiteConfig suiteConfig) {
                this.suiteConfig = suiteConfig;
        }

        public Suite getSuite(String suiteKey) {
                return suiteStore.get(suiteKey);
        }

        public void saveSuite(Suite suite) {
                suiteStore.put(suite.getSuiteKey(), suite);
        }

        public SuiteAuth getSuiteAuth(String suiteKey, String tenantId) {
                return suiteAuthStore.get(generateSuiteAuthKey(suiteKey, tenantId));
        }

        public void saveSuiteAuth(SuiteAuth suiteAuth) {
                suiteAuthStore.put(generateSuiteAuthKey(suiteAuth.getSuiteKey(), suiteAuth.getTenantId()), suiteAuth);
        }

        private String generateSuiteAuthKey(String suiteKey, String tenantId) {
                return suiteKey + tenantId;
        }
}
