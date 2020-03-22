package com.hibernate.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestJdbc {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		/*
		 * String jdbcUrl =
		 * "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		 * String user = "hbstudent", pass = "hbstudent";
		 * 
		 * // Connection to DataBase try { Connection myConn =
		 * DriverManager.getConnection(jdbcUrl, user, pass);
		 * System.out.println("Connection Successfull....."); } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * SessionFactory factory = new
		 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.
		 * class) .buildSessionFactory(); Session session = factory.getCurrentSession();
		 */

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			// use session object to save and retrieve data

			// create a student object
			/*
			 * Student tempStudent=new Student("John","Cena","john@gmail.com"); Student
			 * tempStudent1 = new Student("Jack", "Parket", "jack@gmail.com");
			 */

			Employee tempEmployee1 = new Employee("John", "Cena", "ABC");
			Employee tempEmployee2 = new Employee("Randy", "Orton", "DEF");
			Employee tempEmployee3 = new Employee("Big", "Show", "ABC");
			Employee tempEmployee4 = new Employee("Under", "Tiger", "ABC");
			// start transaction
			session.beginTransaction();

			// save the student
			/*
			 * session.save(tempStudent); session.save(tempStudent1);
			 */

			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			// retrieve the object from mysql using primary key
			/*
			 * System.out.println("Student Id:" + tempStudent.getId()); Student myStudent =
			 * session.get(Student.class, tempStudent.getId());
			 * System.out.println("FirstName:" + myStudent);
			 */

			// retrieve the data based on query
			/*
			 * List<Student> theStudent; theStudent =
			 * session.createQuery("from Student  s where s.email LIKE '%@gmail.com'").
			 * getResultList();
			 * 
			 * displayStudent(theStudent);
			 */

			List<Employee> theEmployee;
			theEmployee = session.createQuery("from Employee").getResultList();

			displayEmployee(theEmployee);

			theEmployee = session.createQuery("from Employee e where e.company='ABC'").getResultList();
			displayEmployee(theEmployee);

			int employeeId = 4;
			Employee deleteEmployee = session.get(Employee.class, employeeId);

			session.delete(deleteEmployee);

			theEmployee = session.createQuery("from Employee").getResultList();

			displayEmployee(theEmployee);
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	private static void displayEmployee(List<Employee> theEmployee) {
		for (Employee employeeData : theEmployee) {
			System.out.println(employeeData);
		}

	}

	/*private static void displayStudent(List<Student> theStudent) {
		for (Student studentData : theStudent) {
			System.out.println(studentData);
		}

	}*/

}
