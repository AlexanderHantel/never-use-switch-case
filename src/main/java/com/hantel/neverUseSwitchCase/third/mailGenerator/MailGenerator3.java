package com.hantel.neverUseSwitchCase.third.mailGenerator;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.third.MailSender3;
import org.springframework.beans.factory.annotation.Autowired;

public interface MailGenerator3 {
    String generate(MailInfo mailInfo);

    String getMailCode();

    /**
     * Adding @Autowired we use Spring's setter-injection. In this case, method registerMyself will
     * be automatically run on program start.
     * Here we call MailSender3.register() method to sent mailCode and implementation object (this),
     * to put them to MailSender3.map
     */
    @Autowired
    default void registerMyself(MailSender3 mailSender) {
        mailSender.register(getMailCode(), this);
    }
}
