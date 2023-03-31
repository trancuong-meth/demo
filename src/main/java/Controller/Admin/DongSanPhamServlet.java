package Controller.Admin;

import Entity.DongSP;
import Repository.DongSanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/dong-san-pham/index",
        "/dong-san-pham/create",
        "/dong-san-pham/delete",
        "/dong-san-pham/edit",
        "/dong-san-pham/update",
        "/dong-san-pham/store"
})
public class DongSanPhamServlet extends HttpServlet {

    private DongSanPhamRepository dspRepo;

    public DongSanPhamServlet() {
        this.dspRepo = new DongSanPhamRepository();
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/update")) {
            this.update(req, resp);
        } else if (uri.contains("/store")) {
            this.store(req, resp);
        } else {
            resp.sendRedirect("/demo_war_exploded/dong-san-pham/index");
        }
    }

    public void create(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("views", "/Views/DongSP/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
        resp.sendRedirect("/demo_war_exploded/dong-san-pham/index");
    }

    public void edit(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        DongSP vm = this.dspRepo.findByMa(ma);
        req.setAttribute("dsp", vm);
        req.setAttribute("views", "/Views/DongSP/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        DongSP vm = this.dspRepo.findByMa(ma);
        this.dspRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/dong-san-pham/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listDSP", this.dspRepo.findAll());
        req.setAttribute("views", "/Views/DongSP/index.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DongSP kh = new DongSP();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.dspRepo.insert(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/dong-san-pham/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        DongSP kh = this.dspRepo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.dspRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/dong-san-pham/index");
    }
}
