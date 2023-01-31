package schoolmanagemengt;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/abc")
public class PrincipalDriver extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
		
		
	 {
		
		String id = req.getParameter("id");
		String name= req.getParameter("name");
	String age = req.getParameter("age");
		String mob = req.getParameter("mob");
		String email = req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		 
		int id2 = Integer.parseInt(id);
		int id1 = Integer.parseInt(age);
		int mob1= Integer.parseInt(mob);
		Principal p =new Principal();
		p.setId(id2);
		p.setName(name);
		p.setAge(id1);
		p.setMob(mob1);
		p.setEmail(email);
		p.setPassword(password);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("Login1.html");
		rd.forward(req, res);
		
		
	}
	
		
		
		
	           
		
		
		
	

}
