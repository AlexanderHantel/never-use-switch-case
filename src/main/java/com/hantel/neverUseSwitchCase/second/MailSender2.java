package com.hantel.neverUseSwitchCase.second;

import com.hantel.neverUseSwitchCase.MailInfo;
import com.hantel.neverUseSwitchCase.second.mailGenerator.MailGenerator2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class MailSender2 {

    private Map<String, MailGenerator2> map;

    /**
     * Actually we don't need to add @Autowired, we're done that just to make code more readable.
     *
     * Spring automatically fills the List<MailGenerator2> mailGenerators with implementations
     * of MailGenerator2 interface.
     * In the constructor we transform the List to a Map. To define keys we call method
     * getMailCode(). In that solution that method is the central point.
     * To define values we put objects of MailGenerator2 implementations (Function.identity()).
     */
    @Autowired
    public MailSender2(List<MailGenerator2> mailGenerators) {
        map = mailGenerators.stream()
                .collect(Collectors.toMap(MailGenerator2 :: getMailCode, Function.identity()));
    }

    public void sendMail(MailInfo mailInfo) {
        String templateCode = mailInfo.getMailCode();
        MailGenerator2 mailGenerator = map.get(templateCode);

        if (mailGenerator == null) {
            throw new UnsupportedOperationException(templateCode + " not supported yet");
        }

        String mailContent = mailGenerator.generate(mailInfo);

        System.out.println("Was sent: " + mailContent);
    }
}
