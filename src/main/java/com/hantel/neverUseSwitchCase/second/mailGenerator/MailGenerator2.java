package com.hantel.neverUseSwitchCase.second.mailGenerator;

import com.hantel.neverUseSwitchCase.MailInfo;

public interface MailGenerator2 {
    String generate(MailInfo mailInfo);

    /**
     * By call of this method we get IDs/codes of our implementations.
     */
    String getMailCode();
}
