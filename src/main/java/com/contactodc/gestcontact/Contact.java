package com.contactodc.gestcontact;

public class Contact {
    private int id;
    private String nomContact;
    private String prenomContact;
    private String numero;
    private String email;
    private String adresse;
    private String competence;

    public Contact(int id, String nomContact, String prenomContact, String numero, String email, String adresse, String competence) {
        this.id = id;
        this.nomContact = nomContact;
        this.prenomContact = prenomContact;
        this.numero = numero;
        this.email = email;
        this.adresse = adresse;
        this.competence = competence;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNomContact() {
        return nomContact;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }
    public String getCompetence() {
        return competence;
    }
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setCompetence(String competence) {
        this.competence = competence;
    }
}
