package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JarCodeReturnServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        handleRequest(req, resp);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        InputStream inputStream = getServletContext()
            .getResourceAsStream("/resources/taglibs-standard-spec-1.2.5.jar");
        OutputStream out = null;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
        response.setContentType("application/jar");
        try {
            out = response.getOutputStream();
            int read = 0;
            byte[] buffer = new byte[1024];

            while ((read = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
