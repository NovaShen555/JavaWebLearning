package top.novashen.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilterTest implements Filter {
    public void init(FilterConfig config) {
        System.out.println("An filter is creating!");
    }

    public void destroy() {
        System.out.println("An filter is destroying!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-16");
        response.setCharacterEncoding("UTF-16");

        System.out.println("Before filter chain...");

        //使请求转接到chain中，不然就会停止，消失
        //使请求加入过滤器链中继续走，交接
        chain.doFilter(request,response);

        System.out.println("After filter chain...");
    }
}
