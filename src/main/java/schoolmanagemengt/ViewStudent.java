package schoolmanagemengt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String stream = req.getParameter("stream");
		String fees = req.getParameter("fees");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prasad");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Query q = em.createQuery("select j from Student j");
		List<Student> students = q.getResultList();
		PrintWriter pw = resp.getWriter();
		for (Student student : students) {
			pw.write(student.getId()+" ");
			pw.write(" ");
			pw.write(student.getName()+" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(student.getStream()+" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(" ");
			pw.write(student.getFees()+" ");
			pw.println(" ");
			pw.println(" ");
			
		}pw.write("");
	}

}
