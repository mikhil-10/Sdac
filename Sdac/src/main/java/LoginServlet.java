import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    User user = new User(username, password);
    LoginDAO loginDao = new LoginDAO();
    String isValidUser = loginDao.validate(user);
    
    if (isValidUser.equals("user")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("UserMain.jsp");
      dispatcher.forward(request, response);
    } else if(isValidUser.equals("analyst")){
      RequestDispatcher dispatcher = request.getRequestDispatcher("Analyst.jsp");
      dispatcher.forward(request, response);
    }
    else {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("LoginError.jsp");
        dispatcher.forward(request, response);	
    }
  }
}
