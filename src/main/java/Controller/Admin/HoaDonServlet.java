package Controller.Admin;

import Entity.HoaDon;
import Repository.HoaDonRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
        ({
                "hoa-don/index",
                "hoa-don/delete",
                "hoa-don/update",
                "hoa-don/create",
                "hoa-don/edit",
                "hoa-don/store"
        })
public class HoaDonServlet extends HttpServlet {
    private HoaDonRepository hdRepo;
    private String uri;
    public HoaDonServlet() {
        this.hdRepo = new HoaDonRepository();
        this.uri = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.uri = req.getRequestURI();

        if (this.uri.contains("/create")) {
            this.create(req,resp);
        } else if (this.uri.contains("/edit")) {
            this.edit(req,resp);
        } else if (this.uri.contains("/delete")) {
            this.delete(req,resp);
        } else {
            this.index(req,resp);
        }
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("views", "/Views/CuaHang/create.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listHD", this.hdRepo.findAll());
        request.setAttribute("views", "/Views/HoaDon/index.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        HoaDon ch = this.hdRepo.findByMa(ma);
        this.hdRepo.delete(ch);
        response.sendRedirect("/demo_war_exploded/cua-hang/index");
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        HoaDon kh = this.hdRepo.findByMa(ma);
        request.setAttribute("ch", kh);
        request.setAttribute("views", "/Views/CuaHang/edit.jsp");
        request.getRequestDispatcher("/Views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
