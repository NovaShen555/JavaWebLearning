import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineNumListener implements HttpSessionListener {
    Integer newOnlineNum = null;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");
        if (onlineNum == null) {
            newOnlineNum = 1;
        } else {
            newOnlineNum = onlineNum + 1;
        }

        System.out.println("An session created!");

        servletContext.setAttribute("onlineNum",newOnlineNum);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        //但是session销毁要么在页面上写入关闭即销毁
        //或者手动销毁，超时销毁

        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();

        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");

        newOnlineNum = onlineNum - 1;

        System.out.println("An session destroyed!");

        servletContext.setAttribute("onlineNum",newOnlineNum);

    }
}
