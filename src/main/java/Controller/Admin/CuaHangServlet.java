package Controller.Admin;

import Entity.CuaHang;
import Repository.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/cua-hang/index",
        "/cua-hang/create",
        "/cua-hang/store",
        "/cua-hang/delete",
        "/cua-hang/edit",
        "/cua-hang/update"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
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
        req.setAttribute("views", "/Views/CuaHang/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
        resp.sendRedirect("/demo_war_exploded/cua-hang/index");
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        CuaHang vm = this.chRepo.findByMa(ma);
        req.setAttribute("ch", vm);
        req.setAttribute("views", "/Views/CuaHang/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        CuaHang vm = this.chRepo.findByMa(ma);
        this.chRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/cua-hang/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listCH", this.chRepo.findAll());
        req.setAttribute("views", "/Views/CuaHang/index.jsp");
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
            resp.sendRedirect("/demo_war_exploded/cua-hang/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CuaHang cv = new CuaHang();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.chRepo.insert(cv);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        CuaHang domainCH = this.chRepo.findByMa(ma);
        try {
            BeanUtils.populate(domainCH, request.getParameterMap());
            this.chRepo.update(domainCH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }
}
