package com.mithilesh.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mithilesh.spring.orm.dao.StudentDao;
import com.mithilesh.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        StudentDao dao = context.getBean("studentDao",StudentDao.class);
        Student student=new Student(100,"mithilesh","singrauli");
        
        int result = dao.insert(student);
        
        System.out.println("inserted data "+result);
        
    }
}
