
<%@page import="java.util.ArrayList"%>
<%@page import="ch.teko.grossmac.db4.a3.beans.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikel auflisten</title>
    </head>

    <body>
        <table>
            <tr>
                <th align="left" valign="top" width="300">
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
            <h1>Artikel auflisten</h1>
            
            <form action="SearchProduct">
                <input hidden="text" name="search">
                <input type="submit" value="Suchen">
            </form>
            

            <% if (request.getAttribute("Products") != null) {%>
            <h1>Resultat</h1>
            <div>

                <table border="1">

                    <%  ArrayList<Product> products = (ArrayList) request.getAttribute("Products");
                        for (Product p : products) {
                    %>
                    <tr>
                        
                        <th width="70" ><%= p.getProductNumber()%></th>
                        <th width="200"><%= p.getProductName()%></th>
                        <th width="30"><%= p.getProductValue()%></th>
                        <th width="40"><%= p.getProductUnit()%></th>
                        <th width="30"><%= p.getProductPrice()%></th>

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



