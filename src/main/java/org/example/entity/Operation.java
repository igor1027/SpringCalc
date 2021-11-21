package org.example.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class Operation {

    private int userId;
    private String num1;
    private String num2;
    private String result;
    private String operation;

    @Autowired
    public Operation() {
    }

    public Operation(int userId, String num1, String num2, String result, String operation) {
        this.userId = userId;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
