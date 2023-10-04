package filter;

import dto.UserDto;
import entity.Role;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;
import java.util.List;
@WebFilter("/users/*")
public class RoleFilter implements jakarta.servlet.Filter {

    private final UserService userService = UserService.getInstance();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserDto user =  (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        var atr = Role.ADMIN.equals(user.getRole()) ? userService.findAll() : List.of(user);
        servletRequest.setAttribute("users", atr);
        filterChain.doFilter(servletRequest,servletResponse);
        ((HttpServletResponse) servletResponse).sendRedirect("/users");



    }
}
