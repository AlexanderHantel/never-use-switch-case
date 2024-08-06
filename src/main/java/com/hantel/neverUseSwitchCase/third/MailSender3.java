package com.hantel.neverUseSwitchCase.third;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.third.mailGenerator.MailGenerator3;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailSender3 {

    /**
     * We need to define the map
     */
    private Map<String, MailGenerator3> map = new HashMap<>();

    /**
     * Here we fill the map with mailCode as keys and mailGenerator as values.
     * But we need to say, that every implementation of MailGenerator must call this method
     * on the program run (see MailGenerator3)
     */
    public void register(String mailCode, MailGenerator3 mailGenerator) {
        map.put(mailCode, mailGenerator);
    }

    public void sendMail(MailInfo mailInfo) {
        String templateCode = mailInfo.getMailCode();
        MailGenerator3 mailGenerator = map.get(templateCode);

        if (mailGenerator == null) {
            throw new UnsupportedOperationException(templateCode + " not supported yet");
        }

        String mailContent = mailGenerator.generate(mailInfo);

        System.out.println("Was sent: " + mailContent);
    }
}
