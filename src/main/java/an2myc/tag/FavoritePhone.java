package an2myc.tag;

import an2myc.service.PhoneService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class FavoritePhone extends SimpleTagSupport {

    private static final PhoneService phoneService = new PhoneService();

    @Override
    public void doTag() throws IOException {
        var context = (PageContext) this.getJspContext();
        var request = (HttpServletRequest) context.getRequest();
        JspWriter out = this.getJspContext().getOut();

        String phoneId = request.getParameter("id");
        if (phoneId == null) {
            phoneId = getCookieValue(request.getCookies(), "id");
        }

        if (phoneId != null) {
            var phone = phoneService.findById(Long.parseLong(phoneId));
            out.println(phone != null ? "Favorite phone: " + phone.getManufacturer() + " " + phone.getType() + " " + phone.getImei() : "You don't have a favorite phone");
        }
    }

    private String getCookieValue(Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
