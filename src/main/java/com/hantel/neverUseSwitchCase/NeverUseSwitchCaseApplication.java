package com.hantel.neverUseSwitchCase;

import com.hantel.neverUseSwitchCase.first.MailSender1;
import com.hantel.neverUseSwitchCase.second.MailSender2;
import com.hantel.neverUseSwitchCase.third.MailSender3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeverUseSwitchCaseApplication implements CommandLineRunner {
	@Autowired
	private MailSenderWithSwitchCase mailSenderWithSwitchCase;
	@Autowired
	private MailSender1 mailSender1;
	@Autowired
	private MailSender2 mailSender2;
	@Autowired
	private MailSender3 mailSender3;

	public static void main(String[] args) {
		SpringApplication.run(NeverUseSwitchCaseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		MailInfo welcomeMail = new MailInfo("welcomeMailCode");
		MailInfo CallbackMail = new MailInfo("callbackMailCode");
		//With switch-case
		System.out.println("======Switch-case======");
		mailSenderWithSwitchCase.sendMail(welcomeMail);
		mailSenderWithSwitchCase.sendMail(CallbackMail);

		//1st solution - Bean ID
		System.out.println("======Bean ID solution======");
		mailSender1.sendMail(welcomeMail);
		mailSender1.sendMail(CallbackMail);

		//2nd solution - Interface method that returns identifier
		System.out.println("======getId() interface method solution======");
		mailSender2.sendMail(welcomeMail);
		mailSender2.sendMail(CallbackMail);

		//3rd solution - Registry pattern
		System.out.println("======Registry pattern solution======");
		mailSender3.sendMail(welcomeMail);
		mailSender3.sendMail(CallbackMail);
	}
}
