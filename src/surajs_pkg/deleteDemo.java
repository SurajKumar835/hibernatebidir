package surajs_pkg;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class deleteDemo {

	public static void main(String[] args) throws ParseException {
		//create a Session Factory
		SessionFactory factory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				
		//create a session
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			int id =2;
			Instructor in=session.get(Instructor.class, id);
			
			session.delete(in);			
						
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

}
