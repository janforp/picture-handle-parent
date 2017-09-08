package com.huizhi.picture.context;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Janita on 2017/6/23 0023-上午 11:48
 * 该类是：
 */
@ConfigurationProperties
public class CustomProperties implements InitializingBean {

    public static String BACKGROUND_PIC;

    @Value("${backgroundPic}")
    private String backgroundPic;

    @Override
    public void afterPropertiesSet() throws Exception {
        BACKGROUND_PIC = backgroundPic;
    }
}
