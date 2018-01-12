package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {			
			//Start a transaction.
			session.beginTransaction();
			
			//Get instructor detail object
			int id = 2;
			InstructorDetail instructorDetailTemp = session.get(InstructorDetail.class, id);
			//print the instructor detail 
			System.out.println("InstructorDetailTemp = "+instructorDetailTemp);
			//print the associated instructor
			System.out.println("The associated instrucor = "+instructorDetailTemp.getInstructor());
			//Commit transaction.
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}//Close try. 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}//Close finally. 
		
	}//Close main method.

}//Close CreateStudenDemo class.
