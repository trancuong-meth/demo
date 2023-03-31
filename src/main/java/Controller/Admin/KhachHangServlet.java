package Controller.Admin;

import Entity.KhachHang;
import Repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({"/khach-hang/index",
        "/khach-hang/create",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update",
        "/khach-hang/delete"
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uri = request.getRequestURI();

        if (uri.contains("/create")) {
            this.create(request, response);
        } else if (uri.contains("/delete")) {
            this.delete(request, response);
        } else if (uri.contains("/edit")) {
            this.edit(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khRepo.findByMa(ma);
        this.khRepo.delete(kh);
        response.sendRedirect("/demo_war_exploded/khach-hang/index");
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("views", "/Views/KhachHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listKH", this.khRepo.findAll());
        request.setAttribute("views", "/Views/KhachHang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khRepo.findByMa(ma);
        request.setAttribute("qlkh", kh);
        request.setAttribute("views", "/Views/KhachHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();

        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/demo_war_exploded/khach-hang/index");
        }

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        KhachHang kh = new KhachHang();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.insert(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/khach-hang/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        KhachHang kh = this.khRepo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.khRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/khach-hang/index");
    }
}
