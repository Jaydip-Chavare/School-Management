package schoolmanagemengt;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class RemoveStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		int id1 =Integer.parseInt(id);
		Student s = em.find(Student.class, id1);
		s.setId(id1);
		
		et.begin();
		em.remove(s);
		et.commit();
		
		//PrintWriter pw = resp.getWriter();
		//pw.write("Deleted Successfully!...");
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter() ;
		pw.write("Removed successfully");
		
		RequestDispatcher rd = req.getRequestDispatcher("student.html") ;
		rd.include(req, resp);
		
		
	}

}
