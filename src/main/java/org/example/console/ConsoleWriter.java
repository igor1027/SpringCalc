package org.example.console;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter {

    public void messageInConsole(String message){
        System.out.println(message);
    }
}
