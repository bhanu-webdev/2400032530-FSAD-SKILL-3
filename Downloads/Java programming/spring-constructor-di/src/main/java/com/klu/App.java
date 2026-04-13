package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.Student;

public class App {

    public static void main(String[ ] args) {

        ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean("student", Student.class);
        student.display();
    }
}
