package Controller.Admin;

import Entity.HoaDon;
import Repository.HoaDonRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/hoa-don/index",
        "/hoa-don/create",
        "/hoa-don/store",
        "/hoa-don/edit",
        "/hoa-don/update",
        "/hoa-don/delete"
})
public class HoaDonServlet extends HttpServlet {
    private HoaDonRepository hdRepo;

    public HoaDonServlet() {
        this.hdRepo = new HoaDonRepository();
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
        req.setAttribute("views", "/Views/HoaDon/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        HoaDon vm = this.hdRepo.findByMa(ma);
        req.setAttribute("hd", vm);
        req.setAttribute("views", "/Views/HoaDon/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        HoaDon vm = this.hdRepo.findByMa(ma);
        this.hdRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/hoa-don/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listHD", this.hdRepo.findAll());
        req.setAttribute("views", "/Views/HoaDon/index.jsp");
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
            resp.sendRedirect("/demo_war_exploded/hoa-don/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HoaDon cv = new HoaDon();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.hdRepo.insert(cv);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/demo_war_exploded/hoa-don/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        HoaDon domainKH = this.hdRepo.findByMa(ma);
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.hdRepo.update(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/hoa-don/index");
    }
}
