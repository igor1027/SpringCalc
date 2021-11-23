package org.example.storage;

import org.example.console.ConsoleWriter;
import org.example.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class OperationStorage {

    private final LinkedList<Operation> operationList;
    private final ConsoleWriter writer;

    public OperationStorage(LinkedList<Operation> operationList, ConsoleWriter writer) {
        this.operationList = operationList;
        this.writer = writer;
    }

    public void saveOperation(Operation operation){
        operationList.addFirst(operation);
    }

    public ArrayList<Operation> userOperationlist(int userId){
        ArrayList<Operation> userList = new ArrayList<>();
        for (Operation list : operationList){
            if(list.getUserId() == userId){
                userList.add(list);
            }
        }
        return userList;
    }

    public void showOperationUser(int userId){
        ArrayList<Operation> operationList = userOperationlist(userId);
        for (int i = 0; i < operationList.size(); i++){
            writer.messageInConsole(operationList.get(i).getNum1()+ " " + operationList.get(i).getOperation()+ " " +
                    operationList.get(i).getNum2()+ " = " + operationList.get(i).getResult());
        }
    }
}
