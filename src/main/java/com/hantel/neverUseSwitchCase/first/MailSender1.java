package com.hantel.neverUseSwitchCase.first;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.first.mailGenerator.MailGenerator1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MailSender1 {

    /**
     * As far as we add @Autowired, Spring defines the map
     * and fills it with beans IDs (see CallbackMailGenerator1 and WelcomeMailGenerator1)
     * as keys and implementations of MailGenerator interface as values.
     */
    @Autowired
    private Map<String, MailGenerator1> map;

    public void sendMail(MailInfo mailInfo) {
        String templateCode = mailInfo.getMailCode();
        MailGenerator1 mailGenerator = map.get(templateCode);

        if (mailGenerator == null) {
            throw new UnsupportedOperationException(templateCode + " not supported yet");
        }

        String mailContent = mailGenerator.generate(mailInfo);

        System.out.println("Was sent: " + mailContent);
    }
}
