package servilets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserDto;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/login")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		UserDto Dto= new UserDto(email,pwd);
		UserDao u= new UserDao();
		try {
			boolean check=u.signUp(Dto);
			System.out.println(check);
			if(check) {
				System.out.println(check);
				//request.setAttribute("krishna", check);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
				//PrintWriter pw=response.getWriter();
				//pw.println("you are sussesfully signin ");
				//pw.println("thank you");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
