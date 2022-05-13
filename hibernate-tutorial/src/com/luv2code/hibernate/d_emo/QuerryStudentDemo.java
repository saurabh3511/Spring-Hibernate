package com.luv2code.hibernate.d_emo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QuerryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration().configure("resources/hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        //create session
        Session session= factory.getCurrentSession();

        try{

              //Start the transaction
            session.beginTransaction();

            //querry a student

            List theStudents= session.createQuery("from Student").list();

            //display the students
            displayStudents(theStudents);

            // query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='bisht'").list();

            // display the students
            System.out.println("\n\nStudents who have last name of Doe");
            displayStudents(theStudents);

            // query students: lastName='Doe' OR firstName='Daffy'
            theStudents =
                    session.createQuery("from Student s where"
                            + " s.lastName='Doe' OR s.firstName='Daffy'").list();

            System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
            displayStudents(theStudents);

            // query students where email LIKE '%gmail.com'
            theStudents = session.createQuery("from Student s where"
                    + " s.email LIKE '%gmail.com'").list();

            System.out.println("\n\nStudents whose email ends with gmail.com");
            displayStudents(theStudents);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
          factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
