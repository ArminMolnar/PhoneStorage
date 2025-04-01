package an2myc.tag;

import an2myc.model.Phone;
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

        if(phoneId == null){
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if("id".equals(cookie.getName())){
                        phoneId = cookie.getValue();
                        break;
                    }
                }
            }
        }

        if(phoneId != null){
            Phone phone = phoneService.findById(Long.parseLong(phoneId));
            if(phone != null){
                out.println("Favorite phone: " + phone.getManufacturer() + " " + phone.getType() + " "  + phone.getImei());
            }else{
                out.println("You don't have a favorite phone.");
            }
        }
    }
}
