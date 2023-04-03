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

@WebServlet
        ({
                "/cua-hang/index",
                "/cua-hang/delete",
                "/cua-hang/edit",
                "/cua-hang/store",
                "/cua-hang/update",
                "/cua-hang/create"
        })
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepository();
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
        CuaHang ch = this.chRepo.findByMa(ma);
        this.chRepo.delete(ch);
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("views", "/Views/CuaHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("listCH", this.chRepo.findAll());
        request.setAttribute("views", "/Views/CuaHang/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        CuaHang kh = this.chRepo.findByMa(ma);
        request.setAttribute("ch", kh);
        request.setAttribute("views", "/Views/CuaHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/demo_war_exploded/cua-hang/index");
        }

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CuaHang ch = new CuaHang();
        try {
            BeanUtils.populate(ch, request.getParameterMap());
            this.chRepo.insert(ch);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        CuaHang kh = this.chRepo.findByMa(ma);
        try {
            BeanUtils.populate(kh, request.getParameterMap());
            this.chRepo.update(kh);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }
}
