package org.example;

import org.example.config.RootConfiguration;
import org.example.console.Application;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(RootConfiguration.class);
        Application application = (Application) ac.getBean("application");
        application.run();
    }
}
