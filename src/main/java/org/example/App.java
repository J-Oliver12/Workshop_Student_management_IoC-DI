package org.example;

import org.example.config.AppConfig;
import org.example.config.ComponentScanConfig;
import org.example.data_access.StudentDao;
import org.example.service.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {


        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);*/


        AnnotationConfigApplicationContext context =
                //new AnnotationConfigApplicationContext(AppConfig.class);  // by using new AppConfig class
                new AnnotationConfigApplicationContext(ComponentScanConfig.class); // by adding method to already existing configuration class
        UserInputService userInputService =context.getBean(UserInputService.class);






    }
}
