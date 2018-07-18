package ch.teko.grossmac.db4.a3;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch.teko.grossmac.db4.a3.beans.Product;
import ch.teko.grossmac.db4.a3.dao.ProductDao;

/**
 *
 * @author ch.grossmann
 */
public class SearchArtikelNrProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Formdaten übernehmen
        String searchString = req.getParameter("searchArtikelNr");

        // DAO Layer aufrufen
        ProductDao dao = new ProductDao();
        List<Product> searchProducts = dao.searchArtikelNrProducts(searchString);

        // Daten an JSP Datei übergeben
        req.setAttribute("SearchProducts", searchProducts);
        req.getRequestDispatcher("showProduct.jsp").forward(req, resp);

    }
}
