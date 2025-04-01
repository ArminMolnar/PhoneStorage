package an2myc.servlet;

import an2myc.service.PhoneService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

public class ListServlet extends HttpServlet {

    private static final PhoneService phoneService = new PhoneService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("phoneList", phoneService.findAll());
        req.getRequestDispatcher("phoneList.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String selectedRow = req.getParameter("id");

        switch (req.getParameter("action")) {
            case "delete":
                phoneService.delete(Long.valueOf(selectedRow));
                req.setAttribute("phoneList", phoneService.findAll());
                req.getRequestDispatcher("phoneList.jsp").forward(req, resp);
                break;
            case "favorite":
                Cookie favoritePhone = new Cookie("id", URLEncoder.encode(selectedRow, "UTF-8"));
                resp.addCookie(favoritePhone);
                req.setAttribute("id", selectedRow);
                req.setAttribute("phoneList", phoneService.findAll());
                req.getRequestDispatcher("phoneList.jsp").forward(req, resp);
                break;
        }
    }
}
