package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
			//Use  the session object to sava java object
			
			//Create a student object
			Student tempStudent = new Student("Hernandez", "Ulises", "uli@hotmail.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the student object
			session.save(tempStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			//Read the student from database
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class,tempStudent.getId());
			System.out.println("Get complete "+student);
			session.getTransaction();
			
		}//Close try. 
		
		finally {
			factory.close();
		}//Close finally. 
		
	}//Close main method.

}//Close CreateStudenDemo class.
