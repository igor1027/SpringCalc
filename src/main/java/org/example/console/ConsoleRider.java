package org.example.console;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRider {
    private final Scanner scanner;
    private final ConsoleWriter writer;

    public ConsoleRider(Scanner scanner, ConsoleWriter writer) {
        this.scanner = scanner;
        this.writer = writer;
    }

    public double number(){
        while (!scanner.hasNextDouble()){
            writer.messageInConsole("Вы ввели значение не того типа");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String choiceOfOperation(){
        String operation;
        while (true){
            while (!scanner.hasNext()){
                writer.messageInConsole("Вы ввели значение не того типа");
                scanner.next();
            }
            operation = scanner.next();
            if(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")){
                return  operation;
            }else {
                writer.messageInConsole("Неверный выбор операции");
                scanner.next();
                choiceOfOperation();
            }
        }
    }

    public int checkValue(){
        while (!scanner.hasNextInt()){
            writer.messageInConsole("Вы ввели значение не того типа");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String checkStringValue(){
        while (!scanner.hasNext()){
            writer.messageInConsole("Вы ввели значение не того типа");
            scanner.next();
        }
        return scanner.next();
    }

    public void existUser(){

    }
}

