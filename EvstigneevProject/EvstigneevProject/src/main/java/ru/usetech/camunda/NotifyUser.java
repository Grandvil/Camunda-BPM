package ru.usetech.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class NotifyUser implements JavaDelegate {

    @Autowired
    private MailSender mailSender;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String a;
        if ((boolean) delegateExecution.getVariable("decision")) {

            a = "Здравствуйте, " + String.valueOf(delegateExecution.getVariable("firstname")) + " " +
                    String.valueOf(delegateExecution.getVariable("lastname")) + "! Ваша заявка на регистрацию принята. Добро пожаловать на портал Grandvil!\n";
        } else {
            a = "Здравствуйте, " + String.valueOf(delegateExecution.getVariable("firstname")) + " " +
                    String.valueOf(delegateExecution.getVariable("lastname")) + ". К сожалению, Вам отказано в регистрации :(\n";
        }

        SimpleMailMessage msg = new SimpleMailMessage();

        String b = String.valueOf(delegateExecution.getVariable("email"));
        msg.setTo(b);
        msg.setFrom("Grandvil19991999@gmail.com");
        msg.setSubject("Уведомление о регистрации на портал Grandvil");
        msg.setText(a);

        mailSender.send(msg);
    }
}
