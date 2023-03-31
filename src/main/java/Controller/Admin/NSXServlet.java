package Controller.Admin;

import Entity.NSX;
import Repository.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet({
        "/nsx/create",
        "/nsx/index",
        "/nsx/update",
        "/nsx/edit",
        "/nsx/delete",
        "/nsx/store",

})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepo;

    public NSXServlet() {
        this.nsxRepo = new NSXRepository();
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
        NSX vm = this.nsxRepo.findByMa(ma);
        req.setAttribute("nsx", vm);
        req.setAttribute("views", "/Views/NSX/edit.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NSX vm = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(vm);
        resp.sendRedirect("/demo_war_exploded/nsx/index");
    }

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("views", "/Views/NSX/create.jsp");
        req.getRequestDispatcher("/Views/layout.jsp").forward(req, resp);
        resp.sendRedirect("/demo_war_exploded/nsx/index");
    }

    public void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNSX", this.nsxRepo.findAll());
        req.setAttribute("views", "/Views/NSX/index.jsp");
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
            resp.sendRedirect("/demo_war_exploded/nsx/index");
        }
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        NSX kh = new NSX();
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.nsxRepo.insert(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/nsx/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        NSX kh = this.nsxRepo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.nsxRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/nsx/index");
    }
}
