<%-- 
    Document   : addProduct
    Created on : 11.06.2018, 17:48:57
    Author     : ch.grossmann
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ch.teko.grossmac.db4.a3.beans.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Artikel hinzufügen</title>
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
                    <h1>Artikel hinzufügen</h1>

                    <pre>                
<form action="NewProduct">

<label for="name">Artikelnummer</label>
<input type="text" name="artikelnummer" />

<label for="name">Bezeichnung</label>
<input type="text" name="bezeichnung" />

<label for="name">Menge</label>
<input type="text" name="menge" />

<label for="name">Einheit</label>
<input type="text" name="einheit" />

<label for="name">Preis</label>
<input type="text" name="preis" />

<input type="submit" value="Hinzufügen" />
  </form>
             </pre>      
                    
                    <a href="index.jsp">Zurück</a>
                </th>
                    </tr>

                <tr>
                    <th align="left" valign="top" hight="1000" width="300"></th>
                    <th align="center" valign="top" width="800">
            <% if (request.getAttribute("Products") != null) {%>
            <h1>Resultat</h1>
            <div>

                <table border="1">

                    <%  ArrayList<Product> newProduct = (ArrayList) request.getAttribute("Products");
                        for (Product p : newProduct) {
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
