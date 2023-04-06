package servilets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;



/**
 * Servlet implementation class serv1
 */
@javax.servlet.annotation.WebServlet("/user")
public class serv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv1() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//fname lname email pwd

		String name=request.getParameter("fname")+" "+request.getParameter("lname");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
	UserDto Dto= new UserDto();
	Dto.setName(name);
	Dto.setEmail(email);
	Dto.setPwd(pwd);
	try {
		UserDao.adduser(Dto);
		PrintWriter pw=response.getWriter();
		pw.println("you are sussesfully registered ");
		pw.println("thank you");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}
