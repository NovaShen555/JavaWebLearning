import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String active = (String) request.getSession().getAttribute("active");
        String name = request.getParameter("name");
        System.out.println(name);
        if ("able".equals(active)){
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        } else if ("admin".equals(name)) {
            request.getSession().setAttribute("active","able");
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/err.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
