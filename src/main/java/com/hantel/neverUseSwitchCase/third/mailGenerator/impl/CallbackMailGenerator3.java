package com.hantel.neverUseSwitchCase.third.mailGenerator.impl;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.third.mailGenerator.MailGenerator3;
import org.springframework.stereotype.Component;

@Component
public class CallbackMailGenerator3 implements MailGenerator3 {

    @Override
    public String generate(MailInfo mailInfo) {
        return "Don't call us, we call you - 3";
    }

    @Override
    public String getMailCode() {
        return "callbackMailCode";
    }
}
