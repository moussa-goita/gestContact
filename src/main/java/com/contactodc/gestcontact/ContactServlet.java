package com.contactodc.gestcontact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    @Override
    //methode doGet pour recuperer et afficher la lise des contacts
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contact> contacts = new ArrayList<>();
        // Récupère l'action à partir des paramètres de la requête
        String action = req.getParameter("action");

        try (Connection connection = DatabaseUtil.getConnection()) {// db connexion
            //pour supprimer un contact si action == delete
            if (action != null && action.equals("delete")) {// recupere id à supprimer
                int id = Integer.parseInt(req.getParameter("id"));
                //requette pour supprimer de la db
                try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM contacts WHERE id = ?")) {
                    stmt.setInt(1, id); //requette parametre avec id a supprimer
                    // Exection du requette
                    stmt.executeUpdate();
                }
            }
//S
            try (Statement stmt = connection.createStatement();// db connexion
                 ResultSet rst = stmt.executeQuery("SELECT * FROM contacts")) {// get tout les contact depuis la db
           // Crée un objet Contact pour chaque ligne de résultat et l'ajoute à la liste de contacts
                while (rst.next()) {
                    Contact contact
                     = new Contact(
                            rst.getInt("id"),
                            rst.getString("nomContact"),
                            rst.getString("prenomContact"),
                            rst.getString("numero"),
                            rst.getString("email"),
                            rst.getString("adresse"),
                            rst.getString("competence")
                    );
                    contacts.add(contact);
                }
            }
        } catch (SQLException e) {//gestion des exception sql en cas de erreur de connection
            // En cas d'erreur SQL 500 error,
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors  de la recuperation des contact : " + e.getMessage());
        }

        req.setAttribute("contacts", contacts); // Ajout a la liste des contacts comme attribut de la requête
        req.getRequestDispatcher("/contact.jsp").forward(req, resp); // envoi a la vue sur la page contact.jsp
    }

    @Override
    // methode post pour ajout 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // recupère les paramètres du contact à ajouter avec la requette 
        String nomContact = req.getParameter("nomContact");
        String prenomContact = req.getParameter("prenomContact");
        String numero = req.getParameter("numero");
        String email = req.getParameter("email");
        String adresse = req.getParameter("adresse");
        String competence = req.getParameter("competence");

        try (Connection connection = DatabaseUtil.getConnection()) { 
    // établir une connexion à la db
            try (PreparedStatement stmt = connection.prepareStatement( 
                    // paramètre de la requette SQL avec les valeurs du nouveau contact
                    "INSERT INTO contacts (nomContact, prenomContact, numero, email, adresse, competence) VALUES (?, ?, ?, ?, ?, ?)")) {
                stmt.setString(1, nomContact);
                stmt.setString(2, prenomContact);
                stmt.setString(3, numero);
                stmt.setString(4, email);
                stmt.setString(5, adresse);
                stmt.setString(6, competence);
                stmt.executeUpdate(); // exécute la requette d'insertion et ajout à la db
            }
        } catch (SQLException e) {
             // En cas d'erreur SQL, envoie une erreur 500 avec un message d'erreur
        resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de l'ajout de contacts : " + e.getMessage());
        }

        resp.sendRedirect("contact"); // envoi à la view sur la page de la liste des contact
    }
}
