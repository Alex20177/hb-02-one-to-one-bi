package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {			
			//Start a transaction.
			session.beginTransaction();
			
			//get instructor by primary key.
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			System.out.println("Object to delet"+tempInstructor);
			
			//delete instructor.
			if (tempInstructor != null) {
				System.out.println("Deleting");
				//Also it will delete instructorDelete because cascade.all.
				session.delete(tempInstructor);
			}//Close if.
			
			//Commit transaction.
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}//Close try. 
		
		finally {
			factory.close();
		}//Close finally. 
		
	}//Close main method.

}//Close CreateStudenDemo class.
