package com.hibernate.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		//One to One Mapping using Instructor and Course tables 
		
		// creation of objects
		/*
		 * Instructor tempInstructor = new Instructor("John", "Cena", "john@gmail.com");
		 * 
		 * InstructorDetail tempInstructorDetail = new
		 * InstructorDetail("http://www.JohnCena.com/youtube", "WWE warriors..");
		 * Instructor tempInstructor1 = new Instructor("Peter", "Parkar",
		 * "peter@gmail.com");
		 * 
		 * InstructorDetail tempInstructorDetail1 = new
		 * InstructorDetail("http://www.PeterParkar.com/youtube",
		 * "SpiderMan warriors..");
		 * 
		 * // association of objects
		 * tempInstructor.setInstructorDetail(tempInstructorDetail);
		 * tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		 * 
		 * session.beginTransaction();
		 * 
		 * session.save(tempInstructor); session.save(tempInstructor1);
		 */

		// deleting an entity

		/*
		 * session.beginTransaction();
		 * 
		 * int theId=1; Instructor tempInstructor=session.get(Instructor.class, theId);
		 * 
		 * if(tempInstructor!=null) { session.delete(tempInstructor); }
		 */

		//session.beginTransaction();

		// get the instructor detail object
		/*int theId = 3;
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
		if(tempInstructorDetail!=null) {
			session.delete(tempInstructorDetail);
		}
		session.getTransaction().commit();*/
		
		session.beginTransaction();
		
		int theCourseId=5;
		//int theStudentId=3;
		//Instructor tempInstructor=session.get(Instructor.class, theId);
		
		//Querying the instructor 
		/*Query<Instructor> query=session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
		
		query.setParameter("theInstructorId", theId);
		
		Instructor tempInstructor=query.getSingleResult();
		
		System.out.println("tempInstructor:"+tempInstructor);*/
		
		//One to Many Mapping Using Course and Review Tables
		
		/*Course tempCourse1=new Course("Air Guitar-The Unlimited Guide");
		
		tempInstructor.add(tempCourse1);
		
		session.save(tempCourse1);
		System.out.println("tempInstructor:"+tempInstructor);*/
		
		//Retrieve the Courses of the 
		//System.out.println("Courses:"+tempInstructor.getCourses());
		
		//Deleting the Course 
		
		//Course tempCourse=session.get(Course.class, theId);
		
		//session.delete(tempCourse);
		
		//Review tempReview=new Review("Better performance try to improve more...");
		
		//tempCourse.add(tempReview);
		
		//session.save(tempReview);
		
		//System.out.println("Review:"+tempCourse.getReview());
		
		//Many to Many Mapping using Student and Course table Joining
		
		/*Course tempCourse2=new Course("The REALGAME-All of the Narrow");
		Course tempCourse3=new Course("The BORDER-All of the War");
		
		session.save(tempCourse2);
		session.save(tempCourse3);
		
		Student tempStudent1=new Student("Bone", "Marrow","bonemarrow@gmail.com");
		
		tempCourse2.addStudent(tempStudent1);
		tempCourse3.addStudent(tempStudent1);*/
		//session.save(tempStudent1);
		
		/*Student tempStudent=session.get(Student.class, theStudentId);
		System.out.println("Student:"+tempStudent);
		System.out.println("Associated students:"+tempStudent.getCourses());*/
		//session.delete(tempStudent);
		
		Course tempCourse=session.get(Course.class,theCourseId);
		System.out.println("Courese:"+tempCourse);
		System.out.println("Associated Courses:"+tempCourse.getStudents());
		
		session.getTransaction().commit();
		
		System.out.println("DONE...!");
		
		
		
	}

}
