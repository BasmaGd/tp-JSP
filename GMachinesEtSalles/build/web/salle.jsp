<%-- 
    Docusent   : salle
    Created on : Oct 24, 2023, 9:37:55 PM
    Author     : DELL
--%>



<%@page import="entities.Salle"%>
<%@page import="services.SalleService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
        <style>
    table {
        border-collapse: collapse; /* Fusionne les bordures des cellules */
        width: 100%;
    }

    th, td {
        border: 1px solid black; /* Ajoute une bordure de 1 pixel autour des cellules */
        padding: 8px; /* Ajoute un peu d'espacement autour du contenu des cellules */
    }
</style>

    </head>
    <body>
        <form action="SalleController" method="GET">
            <fieldset>
                <legend>Informations salle</legend>
                <table border="0">
                   
                        <tr>
                            <td>Code :</td>
                            <td><input type="text" name="code" value="" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Ajouter" /><input type="reset" value="Annuler" /></td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>  
        <fieldset>
            <legend>Liste des salles</legend>
            <table border="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Code</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                
                <tbody>
                    <% 
                    SalleService ss = new SalleService();
                    for(Salle s: ss.findAll() ){
                    %>
                    <tr>
                        <td><%= s.getId()%></td>
                        <td><%= s.getCode()%></td>
                        
                        <td><a href="SalleController??op=update&id=<%=s.getId()%>"> Modifier</a></td>
                        
                        <td><a href="SalleController?op=delete&id=<%=s.getId()%>"> Supprimer</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

        </fieldset>
    </body>
   
</html>
