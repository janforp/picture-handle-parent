package com.huizhi.picture.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Janita on 2017/9/8 0008-上午 10:51
 * 该类是：
 */
@RestController
@RequestMapping("/pic")
public class PictureHandleController {

    @PostMapping("/upload")
    public String uploadPicture(HttpServletRequest request) {
        return "常规";
    }
}