import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //得到session对象
        HttpSession session = request.getSession();

        //往session里放东西
        session.setAttribute("key","value");
        boolean isNew = session.isNew();
        String id = session.getId();

        if (isNew) {
            response.getWriter().print("Created session successful,id "+id);
        }else {
            response.getWriter().print("Session exist,id "+id);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
