package org.example.console;

import org.example.entity.Operation;
import org.example.entity.User;
import org.example.service.AuthorizationService;
import org.example.service.CalculatorService;
import org.example.service.RegistrationService;
import org.example.storage.OperationStorage;
import org.example.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.nio.file.Watchable;

@Component
public class Application {

    private final ConsoleWriter writer;
    private final ConsoleRider rider;
    private final UserStorage userStorage;
    private final OperationStorage operationStorage;
    private final CalculatorService calculatorService;
    private final AuthorizationService authService;
    private final RegistrationService regService;
    private  User user;
    private int id = 0;

    public Application(ConsoleWriter writer, ConsoleRider rider, UserStorage userStorage, OperationStorage operationStorage, CalculatorService calculatorService, AuthorizationService authService, RegistrationService regService) {
        this.writer = writer;
        this.rider = rider;
        this.userStorage = userStorage;
        this.operationStorage = operationStorage;
        this.calculatorService = calculatorService;
        this.authService = authService;
        this.regService = regService;
    }

    public void run(){
        int value;
        writer.messageInConsole("1.Регистрация");
        writer.messageInConsole("2.Авторизация");
        value = rider.checkValue();
        if (value == 1){
            registrationMenu();
        }else if (value == 2){
            authorizationMenu();
        }else if(value != 1 || value != 2){
            run();
        }
    }

    private void registrationMenu(){
        writer.messageInConsole("Введите имя");
        String username = rider.checkStringValue();
        if (!authService.checkUsername(username)){
            writer.messageInConsole("Введите пароль");
            String password = rider.checkStringValue();
            User newUser = new User(id,username, password);
            id++;
            regService.saveUser(newUser);
            writer.messageInConsole("Пользователь создан");
            run();
        }
        writer.messageInConsole("Ошибка ввода");
        run();
    }

    private void authorizationMenu(){
        writer.messageInConsole("Введите имя");
        String username = rider.checkStringValue();
        if (authService.checkUsername(username)) {
            writer.messageInConsole("Введите пароль");
            String password = rider.checkStringValue();
            if (authService.checkPassword(username,password)){
                user = authService.singInUser(username, password);
                writer.messageInConsole("Вход выполнен");
                personalMenu();
            }
        }
    }

    private void personalMenu(){
        int value;
        writer.messageInConsole("1.Калькулятор");
        writer.messageInConsole("2.История");
        writer.messageInConsole("3.Выход");
        value = rider.checkValue();
        profileMenu(value);
    }

    private void profileMenu(int value){
        switch (value){
            case 1 : {
                calculator();
            }
            case 2 : {
                historyOperation();
            }
            case 3 : {
                writer.messageInConsole("Bye");
                run();
            }
            default:{
                writer.messageInConsole("Вы ввели не верное значение");
                profileMenu(value);
            }
        }
    }

    private void calculator(){
        int exit = 1;
        while (exit == 1){
            writer.messageInConsole("Введите первое число");
            double num1 = rider.number();
            writer.messageInConsole("Введите второе число");
            double num2 = rider.number();
            writer.messageInConsole("Выберете одну из операций: '+','-','*','/' ");
            String operation = rider.choiceOfOperation();
            double result =  calculatorService.calculator(num1,num2,operation);

            Operation newOperation = new Operation(user.getId(),String.valueOf(num1),String.valueOf(num2),String.valueOf(result),
                    operation);
            operationStorage.saveOperation(newOperation);
            writer.messageInConsole(num1 + " " + operation + " " + num2 + " = " + result);
            writer.messageInConsole("Если хотите продолжить, введите '1', если нет, введите '0' ");
            exit = rider.checkValue();
            if(exit !=1){
                personalMenu();
            }
        }

    }

    private void historyOperation(){
        operationStorage.showOperationUser(user.getId());
        personalMenu();
    }
}
