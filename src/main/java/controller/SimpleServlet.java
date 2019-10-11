package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.printf(
            "log info about request %s\n%s\n%s\n%s",
            req.getMethod(),
            req.getMethod(),
            req.getRemoteUser(),
            req.getCharacterEncoding()
        );
        writer.println("<html>\n"
            + "<body>\n"
            + "<h2>Hello from servlet</h2>\n"
            + "</body>\n"
            + "</html>\n");
    }
}