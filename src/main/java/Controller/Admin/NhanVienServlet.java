package Controller.Admin;

import Entity.NhanVien;
import Repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/delete"
})

public class NhanVienServlet extends HttpServlet {

    private NhanVienRepository nvRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    )
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/create")) {
            this.create(req, resp);
        } else if (uri.contains("/edit")) {
            this.edit(req, resp);
        } else if (uri.contains("/delete")) {
            this.delete(req, resp);
        } else if (uri.contains("/index")) {
            this.index(req, resp);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp
    )
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/update")) {
            this.update(req, resp);
        } else if (uri.contains("/store")) {
            this.store(req, resp);
        } else {
            resp.sendRedirect("/demo_war_exploded/chuc-vu/index");
        }
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NhanVien vm = this.nvRepo.findByMa(ma);
        req.setAttribute("nv", vm);
        req.setAttribute("views", "/Views/NhanVien/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NhanVien vm = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/nhan-vien/index");
    }

    public void create(
            HttpServletRequest req,
            HttpServletResponse resp
    )
            throws ServletException, IOException {
        req.setAttribute("views", "/Views/NhanVien/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
        resp.sendRedirect("/demo_war_exploded/nhan-vien/index");
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    )
            throws ServletException, IOException {
        req.setAttribute("listNV", this.nvRepo.findAll());
        req.setAttribute("views", "/Views/NhanVien/index.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NhanVien kh = new NhanVien();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.nvRepo.insert(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/nhan-vien/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        NhanVien kh = this.nvRepo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.nvRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/nhan-vien/index");
    }
}
