package com.geekbrains.homework1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        int count;
        try
        {
            count = Integer.parseInt(req.getParameter("count"));
        }
        catch(NumberFormatException e)
        {
            count = 10;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<tr><th>ID</th><th>Title</th><th>Price</th><tr>\n");
        for (int i = 0; i < count; i++) {
            Product product = new Product(i + 1);
            sb.append(String.format("<tr><td>%d</td><td>%s</td><td>%.2f</td><tr>\n",
                    product.getId(), product.getTitle(), product.getCost()));
        }
        String temp = String.format(
                "<html>" +
                        "<head>" +
                        "<style>table, th, td {border: 1px solid black;}</style>" +
                        "</head>" +
                        "<body>" +
                        "<table>" +
                        "%s" +
                        "</table>" +
                        "</body>" +
                        "</html>",
                sb.toString());
        out.println(temp);
        out.close();
    }
}
