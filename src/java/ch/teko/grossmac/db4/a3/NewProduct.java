
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

public class NewProduct extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Formdaten übernehmen
        String newArtikelnummer = req.getParameter("artikelnummer");
        String newBezeichnung = req.getParameter("bezeichnung");
        String newMenge = req.getParameter("menge");
        String newEinheit = req.getParameter("einheit");
        String newPreis = req.getParameter("preis");
        
        

        // DAO Layer aufrufen
        ProductDao dao = new ProductDao();
        List<Product> newProduct = dao.newProductDao( newArtikelnummer, newBezeichnung, newMenge, newEinheit, newPreis);

        // Daten an JSP Datei übergeben
        req.setAttribute("Products", newProduct);
        req.getRequestDispatcher("addProduct.jsp").forward(req, resp);

    }

}
