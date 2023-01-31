package schoolmanagemengt;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validation")
public class LoginPage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query q = em.createQuery("select j from Principal j where j.email=?1 and j.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		List<Principal> principals = q.getResultList();
		if (principals.size()>0) 
		{
			RequestDispatcher rd = req.getRequestDispatcher("validate.html");
			rd.include(req, resp);
			
			
		}
		else
		{
			PrintWriter pw =resp.getWriter();
		       pw.write("Invalid Credentials!...");
		}
			
		
		

}
}
