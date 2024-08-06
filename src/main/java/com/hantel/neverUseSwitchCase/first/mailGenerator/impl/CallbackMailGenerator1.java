package com.hantel.neverUseSwitchCase.first.mailGenerator.impl;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.first.mailGenerator.MailGenerator1;
import org.springframework.stereotype.Component;

/**
 * In this case, we can add a custom ID for bean,
 * by which we will call necessary implementation class
 */
@Component("callbackMailCode")
public class CallbackMailGenerator1 implements MailGenerator1 {

    @Override
    public String generate(MailInfo mailInfo) {
        return "Don't call us, we call you - 1";
    }
}
