package com.hantel.neverUseSwitchCase.second.mailGenerator.impl;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.second.mailGenerator.MailGenerator2;
import org.springframework.stereotype.Component;

@Component
public class CallbackMailGenerator2 implements MailGenerator2 {

    @Override
    public String generate(MailInfo mailInfo) {
        return "Don't call us, we call you - 2";
    }

    @Override
    public String getMailCode() {
        return "callbackMailCode";
    }
}
