package com.luv2code.hibernate.d_emo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration().configure("resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        //create session
        Session session= factory.getCurrentSession();

        try{
           //create a student object
            System.out.println("Creating a new student object...");
              Student tempStudent =new Student("saurabh","bisht","saurabh@gmail.com");

              //Start the transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
          factory.close();
        }
    }
}
