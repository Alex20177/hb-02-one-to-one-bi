package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.entity.Instructor;
import com.example.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
			//Use  the session object to save java object
			
			//Create objects
			Instructor instructorTemp = new Instructor("Teddy", "Rush", "Teddy@hotmail.com");
			InstructorDetail instructorDetailTemp = new InstructorDetail("https://youtube.com/teddy", "Singing");
			
			//Associating objects
			instructorTemp.setInstructorDetail(instructorDetailTemp);
			
			//Start a transaction
			session.beginTransaction();
			
			/*
			 * This also save instructoDetailTemp object due cascade.all
			 * */
			//Saving instructorTemp
			session.save(instructorTemp);
			
			//Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}//Close try. 
		
		finally {
			factory.close();
		}//Close finally. 
		
	}//Close main method.

}//Close CreateStudenDemo class.
