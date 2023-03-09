import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] products = request.getParameterValues("product");

        if (products != null && products.length > 0) {
            Cookie cookie = new Cookie("cart", String.join(",", products));
            cookie.setMaxAge(60 * 60 * 24 * 7); 
            response.addCookie(cookie);
        }

        response.sendRedirect("CartServlet");
    }

}
