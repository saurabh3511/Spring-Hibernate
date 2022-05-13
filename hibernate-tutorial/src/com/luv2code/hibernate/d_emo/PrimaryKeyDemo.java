package com.luv2code.hibernate.d_emo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration().configure("resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        //create session
        Session session= factory.getCurrentSession();

        try{
            //create 3 students objects
            System.out.println("Creating 3 new student object...");
            Student tempStudent1 =new Student("sachin","tendulkar","sachin@luv2code.com");
            Student tempStudent2 =new Student("Mary","Public","mary@luv2code.com");
            Student tempStudent3 =new Student("Bonita","Applebum","bonita@luv2code.com");


            //Start the transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            factory.close();
        }
    }
}
