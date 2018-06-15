<%-- 
    Document   : showProduct
    Created on : 13.06.2018, 19:19:35
    Author     : ch.grossmann
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ch.teko.grossmac.db4.a3.beans.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikel suchen</title>
    </head>

    <body>
        <table>
            <tr>
                <th align="left" valign="top" hight="1000" width="300">
            <h3>Menü</h3>
            <ol>
                <ol>
                    <li><a href="index.jsp">Artikel auflisten</a></li>
                    <li><a href="showProduct.jsp">Artikel suchen</a></li>
                    <li><a href="addProduct.jsp">Artikel erfassen</a></li>
                    
                </ol>
            </ol>
            </th>
            
            
            <th align="center" valign="top" width="800">
                
            <h1>Artikel suchen</h1>
            
            <pre>
            <form action="SearchArtikelNrProduct">
                <label for="name">ArtikelNr</label>
                <input type="text" name="searchArtikelNr">
                <input type="submit" value="Suchen">
            </form>
            
            <form action="SearchBezeichnungProduct">
                <label for="name">Bezeichnung</label>
                <input type="text" name="searchBezeichnung">
                <input type="submit" value="Suchen">
            </form>
            </pre>

            <% if (request.getAttribute("SearchProducts") != null) {%>
            <h1>Resultat</h1>
            <div>

                <table>

                    <%  ArrayList<Product> searchProducts = (ArrayList) request.getAttribute("SearchProducts");
                        for (Product s : searchProducts) {
                    %>
                    <tr>
                        <th>ArtikelNr: </th>
                        <th><%= s.getProductNumber()%></th>
                    </tr>
                    <tr>
                        <th>Bezeichnung: </th>
                        <th><%= s.getProductName()%></th>
                        </tr>
                        
                        <tr>
                        <th>Menge: </th>
                        <th><%= s.getProductValue()%></th>
                        </tr>
                        <tr>
                        <th>Einheit: </th>
                        <th><%= s.getProductUnit()%></th>
                        </tr>
                        <tr>
                        <th>Preis: </th>
                        <th><%= s.getProductPrice()%></th>
                        </tr>
                        <br>
                        <br>
                        

                    </tr>
                    <%
                        }
                    %>

                </table>
                <%
                    }
                %>

            </div>
            </th>
        </tr>
    </table>



</body>
</html>