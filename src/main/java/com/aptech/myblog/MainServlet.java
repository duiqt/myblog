package com.aptech.myblog;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = {"/home","*.do"}, name = "Main")
//        initParams = {@WebInitParam(name="productName",value="My blog")})
public class MainServlet extends HttpServlet {

    String productName = "";
    String conncectionStr = "";
    @Override
    public void init() throws ServletException {
        productName = getInitParameter("productName");
        conncectionStr = getServletContext().getInitParameter("connectStr");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xml");
        String name = req.getParameter("name");
        resp.getWriter().write(String.format("<application>" +
                "<msg>%s Stellar stellar~</msg>" +
                "<product>%s</product>" +
                "<connectstr>%s</connectstr>" +
                "</application>", name, productName, conncectionStr));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name!= null && name != ""){
            resp.getWriter().write("Hello " + name + " ~");
        }else {
            resp.sendRedirect("index.html");
        }
    }
}
