package filters;

import Entity.KhachHang;
import Entity.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
    "/khach-hang/*",
    "/nhan-vien/*"
})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws ServletException, IOException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpSession session = httpReq.getSession();
        KhachHang kh = (KhachHang) session.getAttribute("kh");
        NhanVien nv = (NhanVien) session.getAttribute("nv");

        if (kh == null) {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.sendRedirect("/demo_war_exploded/login");
        } else if (nv == null) {
            HttpServletResponse httpRes = (HttpServletResponse) response;
            httpRes.sendRedirect("/demo_war_exploded/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
