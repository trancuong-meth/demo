package Controller.Admin;

import Entity.ChucVu;
import Repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/chuc-vu/index",
        "/chuc-vu/create",
        "/chuc-vu/store",
        "/chuc-vu/edit",
        "/chuc-vu/update",
        "/chuc-vu/delete"
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;

    public ChucVuServlet() {
        this.cvRepo = new ChucVuRepository();
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
        req.setAttribute("views", "/Views/ChucVu/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        ChucVu vm = this.cvRepo.findByMa(ma);
        req.setAttribute("cv", vm);
        req.setAttribute("views", "/Views/ChucVu/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        ChucVu vm = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/chuc-vu/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listCV", this.cvRepo.findAll());
        req.setAttribute("views", "/Views/ChucVu/index.jsp");
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
            resp.sendRedirect("/demo_war_exploded/chuc-vu/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ChucVu cv = new ChucVu();
        try {
            BeanUtils.populate(cv, request.getParameterMap());
            this.cvRepo.insert(cv);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/demo_war_exploded/chuc-vu/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        ChucVu domainKH = this.cvRepo.findByMa(ma);
        try {
            BeanUtils.populate(domainKH, request.getParameterMap());
            this.cvRepo.update(domainKH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/chuc-vu/index");
    }
}
