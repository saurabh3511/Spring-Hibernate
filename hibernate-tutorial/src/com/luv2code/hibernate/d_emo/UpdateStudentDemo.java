package com.luv2code.hibernate.d_emo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration().configure("resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        //create session
        Session session= factory.getCurrentSession();

        try{
            int studentId=1;


            // now get a new session and start a transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //retreive the student based on the id:primary key
            System.out.println("\nGetting student with id : "+studentId);

            Student myStudent =session.get(Student.class,studentId);

            System.out.println("updating student...");
             myStudent.setFirstName("Scooby");

            //commit the transaction
            session.getTransaction().commit();

            //NEW CODE
            session=factory.getCurrentSession();
            session.beginTransaction();

            //update student email for all the students
            System.out.println("update email for all the students");

            session.createQuery("update student set email='foo@gmail.com'").executeUpdate() ;

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!!!");
        }finally {
          factory.close();
        }
    }
}
