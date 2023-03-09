import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    String[] products = cookie.getValue().split(",");
                    out.println("<html>");
                    out.println("<head><title>Shopping Cart</title></head>");
                    out.println("<body>");
                    out.println("<h1>Shopping Cart</h1>");
                    out.println("<ul>");
                    for (String product : products) {
                        out.println("<li>" + product + "</li>");
                    }
                    out.println("</ul>");
                    out.println("</body></html>");
                    return;
                }
            }
        }

        out.println("<html>");
        out.println("<head><title>Shopping Cart</title></head>");
        out.println("<body>");
        out.println("<h1>Your shopping cart is empty</h1>");
        out.println("</body></html>");
    }

}
