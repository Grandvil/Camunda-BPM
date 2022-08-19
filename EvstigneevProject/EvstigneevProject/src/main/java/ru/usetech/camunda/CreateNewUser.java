package ru.usetech.camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateNewUser implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.printf("[%s] Пользователь %s %s успешно зарегистрирован\n",
                CreateNewUser.class.getName(),
                delegateExecution.getVariable("firstname"),
                delegateExecution.getVariable("lastname"));
    }
}
