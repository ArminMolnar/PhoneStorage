package an2myc.servlet;

import an2myc.service.PhoneService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddPhone extends HttpServlet {

    private static final PhoneService phoneService = new PhoneService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("addPhone.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");

        var manufacturer = req.getParameter("manufacturer");
        var type = req.getParameter("type");
        var imei = req.getParameter("imei");

        phoneService.save(null, manufacturer, type, imei);
        resp.sendRedirect(req.getContextPath() + "/listServlet");

    }
}
