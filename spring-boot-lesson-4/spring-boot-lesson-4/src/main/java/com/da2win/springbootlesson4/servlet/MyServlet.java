package com.da2win.springbootlesson4.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "myServlet",
        urlPatterns = "/myservlet",
        initParams = @WebInitParam(name = "myname", value = "myvalue"))
public class MyServlet extends HttpServlet {

    private String value;

    public void init(ServletConfig servletConfig) throws ServletException {
        value = servletConfig.getInitParameter("myname");
        super.init(servletConfig);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        ServletContext servletContext = getServletContext();
        servletContext.log("myServlet doGet .... ");
        writer.write("<html><body>Hello World, my value = " + value + " </body></html>");
    }
}
