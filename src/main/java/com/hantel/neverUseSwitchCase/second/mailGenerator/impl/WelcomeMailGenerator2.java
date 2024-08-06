package com.hantel.neverUseSwitchCase.second.mailGenerator.impl;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.second.mailGenerator.MailGenerator2;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMailGenerator2 implements MailGenerator2 {

    @Override
    public String generate(MailInfo mailInfo) {
        return "Welcome mail - 2";
    }

    @Override
    public String getMailCode() {
        return "welcomeMailCode";
    }
}
