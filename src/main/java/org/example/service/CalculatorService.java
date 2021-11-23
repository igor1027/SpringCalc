package org.example.service;

import org.example.entity.Operation;
import org.example.storage.OperationStorage;
import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    private final OperationStorage storage;

    public CalculatorService(OperationStorage storage) {
        this.storage = storage;
    }

    private double sum(double num1, double num2){
        return num1 + num2;
    }

    private  double sub(double num1, double num2){
        return  num1 - num2;
    }

    private  double mul(double num1, double num2){
        return num1 * num2;
    }

    private double div(double num1, double num2){
        return  num1 / num2;
    }

    public double calculator(double num1, double num2, String operation){
        switch (operation){
            case "+" : {
                return sum(num1, num2);
            }
            case "-" : {
                return sub(num1, num2);
            }
            case "*" : {
                return mul(num1, num2);
            }
            case "/" : {
                return div(num1, num2);
            }
        }
        return 0;
    }

    public void showOperation(int userId){
        storage.showOperationUser(userId);
    }

    public void saveOperation(Operation operation){
        storage.saveOperation(operation);
    }
}
