<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contacts</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Liste des contacts</h1>
    <ul>
        <!-- comment -->
        <c:forEach var="contact" items="${contacts}">
            <li>
                ${contact.nomContact} ${contact.prenomContact} - ${contact.numero} - ${contact.email} - ${contact.adresse} - ${contact.competence}
                <a href="contact?action=delete&id=${contact.id}">Supprimer</a>
            </li>
        </c:forEach>
    </ul>
    <h2>Ajouter un contact</h2>
    <div class="form" >
    <form action="contact" method="post">
        <label for="nomContact">Nom :</label>
        <input type="text" id="nomContact" name="nomContact" required>
        <label for="prenomContact">Prénom :</label>
        <input type="text" id="prenomContact" name="prenomContact" required>
        <label for="numero">Numéro :</label>
        <input type="text" id="numero" name="numero" required>
        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required>
        <label for="adresse">Adresse :</label>
        <input type="text" id="adresse" name="adresse" required>
        <label for="competence">Compétence :</label>
        <input type="text" id="competence" name="competence" required>
        <button type="submit">Valider</button>
    </form>
    </div>
</body>
</html>
