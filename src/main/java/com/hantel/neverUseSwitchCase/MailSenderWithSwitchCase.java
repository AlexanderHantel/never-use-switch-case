package com.hantel.neverUseSwitchCase;

import org.springframework.stereotype.Service;

@Service
public class MailSenderWithSwitchCase {
    private static final String WELCOME_MAIL = "Welcome mail";
    private static final String CALLBACK_MAIL = "Don't call us, we call you";

    public void sendMail(MailInfo mailInfo) {
        String maiContent;
        switch (mailInfo.getMailCode()) {
            case "welcomeMailCode":
                System.out.println("Was sent: " + WELCOME_MAIL);
                break;
            case "callbackMailCode":
                System.out.println("Was sent: " + CALLBACK_MAIL);
                break;
        }
    }
}
