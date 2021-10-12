package surajs_pkg;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

	public static void main(String[] args) throws ParseException {
		//create a Session Factory
		SessionFactory factory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				
		//create a session
		Session session=factory.getCurrentSession();
		try {
			// one to bi-directional Mapping
			//one to one mapping 
			/*Instructor in=new Instructor("Madhu","kumar","madhu@gmail.com");
			InstructorDetail ind=new InstructorDetail("youtube", "guitar");	
			in.setInstructorDetail(ind);*/
			session.beginTransaction();
			int id=1;
			InstructorDetail ind=session.get(InstructorDetail.class,id);
			System.out.println(ind.getInstructor());			
						
			session.getTransaction().commit();
			System.out.println("Done");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
