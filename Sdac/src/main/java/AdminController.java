import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    AdminPojo admin = new AdminPojo(username, password);
    AdminDAO adminDao = new AdminDAO();
    boolean isValidUser = adminDao.validate(admin);
    
    if (isValidUser) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("UserDetails.jsp");
      dispatcher.forward(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("AdminError.jsp");
      dispatcher.forward(request, response);
    }
  }
}
