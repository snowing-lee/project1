import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/8/30
 * Time: 10:48
 */
@WebFilter(filterName = "GlobalFilter",urlPatterns = "/*")
public class GlobalFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");

        if (!"OPTIONS".equals(request.getMethod())){
            HttpSession session =request.getSession();
            System.out.println("拦截器中的session的id是====" + session.getId());
        }

        System.out.println(1);

        chain.doFilter(request, response);
        //这三个头与跨域访问有关，如果不设置，则访问不成功
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");//是否支持cookie跨域

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
