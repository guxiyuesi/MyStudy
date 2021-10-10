import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/info")
public class UsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        httpRequest.setCharacterEncoding("UTF-8");
        String name = httpRequest.getParameter("name");
        if(name != null) {
            name = name.replace("敏感词", "***");
            httpRequest.setAttribute("name", name);
        }

        filterChain.doFilter(httpRequest, servletResponse);
    }
}
