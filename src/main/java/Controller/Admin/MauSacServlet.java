package Controller.Admin;

import Entity.ChucVu;
import Entity.MauSac;
import Repository.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/index",
        "/mau-sac/update",
        "/mau-sac/edit",
        "/mau-sac/delete",
        "/mau-sac/store",

})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;

    public MauSacServlet() {
        this.msRepo = new MauSacRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        MauSac vm = this.msRepo.findByMa(ma);
        req.setAttribute("ms", vm);
        req.setAttribute("views", "/Views/MauSac/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        MauSac vm = this.msRepo.findByMa(ma);
        this.msRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/mau-sac/index");
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("views", "/Views/MauSac/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listMS", this.msRepo.findAll());
        req.setAttribute("views", "/Views/MauSac/index.jsp");
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
            resp.sendRedirect("/demo_war_exploded/mau-sac/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        MauSac cv = new MauSac();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.msRepo.insert(cv);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/demo_war_exploded/mau-sac/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        MauSac domainKH = this.msRepo.findByMa(ma);
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.msRepo.update(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/mau-sac/index");
    }
}
