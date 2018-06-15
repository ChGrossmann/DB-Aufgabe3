
package ch.teko.grossmac.db4.a3;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.teko.grossmac.db4.a3.beans.Product;
import ch.teko.grossmac.db4.a3.dao.SearchProductDao;

/**
 *
 * @author rainer
 */
public class SearchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Formdaten übernehmen
        String searchString = req.getParameter("search");

        // DAO Layer aufrufen
        SearchProductDao dao = new SearchProductDao();
        List<Product> products = dao.searchProducts(searchString);

        // Daten an JSP Datei übergeben
        req.setAttribute("Products", products);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
