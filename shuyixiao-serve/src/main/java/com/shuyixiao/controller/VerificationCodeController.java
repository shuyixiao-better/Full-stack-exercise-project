package shuyixiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shuyixiao.config.ResponseResult;
import shuyixiao.data.VerificationCodeDTO;
import shuyixiao.service.VerificationCodeService;

/**
 * Copyright © 2025年 integration-projects-maven. All rights reserved.
 * ClassName VerificationCodeController.java
 * author 舒一笑 yixiaoshu88@163.com
 * version 1.0.0
 * Description TODO
 * createTime 2025年04月06日 20:34:00
 */
@RestController
@Slf4j
public class VerificationCodeController {

    @Autowired
    VerificationCodeService verificationCodeService;



    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){

        String userName = verificationCodeDTO.getUserName();
        String passWord = verificationCodeDTO.getPassWord();

        log.info("用户名"+userName+",密码："+passWord);

        return verificationCodeService.checkCode(userName,passWord);
    }
}
