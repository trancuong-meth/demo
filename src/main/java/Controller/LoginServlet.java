package Controller;

import Entity.KhachHang;
import Entity.NhanVien;
import Repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Repository.KhachHangRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private KhachHangRepository khRepo;
    private NhanVienRepository nvRepo;

    public LoginServlet()
    {
        this.khRepo = new KhachHangRepository();
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/Views/login.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");

        HttpSession session = request.getSession();
        KhachHang kh = this.khRepo.login(ma, matKhau);
        NhanVien nv = this.nvRepo.login(ma,matKhau);

        if (kh == null) {
            if (nv == null) {
                session.setAttribute("error_message", "Vui lòng nhập thông tin");
                response.sendRedirect("/demo_war_exploded/login");
            } else {
                session.setAttribute("nv", nv);
                response.sendRedirect("/demo_war_exploded/nhan-vien/index");
            }
        } else {
            session.setAttribute("kh", kh);
            response.sendRedirect("/demo_war_exploded/khach-hang/index");
        }
    }
}
