package Controller.Admin;

import Entity.SanPham;
import Repository.ChucVuRepository;
import Repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/san-pham/index",
        "/san-pham/delete",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/store",
        "/san-pham/create"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository cvRepo;

    public SanPhamServlet() {
        this.cvRepo = new SanPhamRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/create")) {
            this.create(req, resp);
        } else if (uri.contains("/edit")) {
            this.edit(req, resp);
        } else if (uri.contains("/delete")) {
            this.delete(req, resp);
        } else {
            this.index(req, resp);
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("views", "/Views/SanPham/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        SanPham vm = this.cvRepo.findByMa(ma);
        req.setAttribute("sp", vm);
        req.setAttribute("views", "/Views/SanPham/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        SanPham vm = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/san-pham/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listSP", this.cvRepo.findAll());
        req.setAttribute("views", "/Views/SanPham/index.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/update")) {
            this.update(req, resp);
        } else if (uri.contains("/store")) {
            this.store(req, resp);
        } else {
            resp.sendRedirect("/demo_war_exploded/san-pham/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SanPham cv = new SanPham();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.insert(cv);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/demo_war_exploded/san-pham/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        SanPham domainKH = this.cvRepo.findByMa(ma);
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.cvRepo.update(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/san-pham/index");
    }
}
