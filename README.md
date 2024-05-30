# Documentation de l'Application de Gestion de Contacts
# Introduction
L'application de gestion de contacts est une application web simple conçue pour permettre aux utilisateurs de gérer une liste de contacts. Les utilisateurs peuvent ajouter, afficher, modifier et supprimer des contacts à partir de l'interface utilisateur conviviale de l'application.

# Fonctionnalités
Ajouter un nouveau contact en saisissant les détails requis.
Afficher la liste complète des contacts avec leurs détails.
Supprimer un contact de la liste.
Configuration Requise
Avant de déployer et d'utiliser l'application, assurez-vous d'avoir les éléments suivants :

JDK installé sur le serveur.
Maven installé pour la gestion du projet.
Un serveur d'application compatible, tel que Apache Tomcat.
Un IDE (Integrated Development Environment) pour le développement.
Installation et Configuration
Clonez le dépôt GitHub de l'application de gestion de contacts.
Importez le projet dans votre IDE.
Configurez votre base de données MySQL avec une base de données nommée gestContactDB et une table nommée contacts.
Assurez-vous d'avoir les dépendances JDBC et JSTL ajoutées dans le fichier pom.xml.
Configurez la connexion à la base de données dans la classe DatabaseUtil.java.
Compilez le projet en utilisant Maven.
Déployez l'application sur votre serveur d'application.
# Utilisation
Une fois l'application déployée, vous pouvez l'accéder à l'aide de l'URL correspondante sur votre navigateur web préféré. Voici les principales étapes pour utiliser l'application :

# Accédez à la page d'accueil de l'application.
Pour ajouter un nouveau contact, cliquez sur le lien "Ajouter un contact" et saisissez les détails requis dans le formulaire.
Pour supprimer un contact de la liste, cliquez sur le lien "Supprimer" à côté du contact souhaité.
Contributions
Les contributions à l'amélioration de cette application sont les bienvenues ! Si vous souhaitez contribuer, veuillez créer une demande de tirage (pull request) avec vos modifications.

#Licence
Cette application est sous licence MIT. Consultez le fichier LICENSE pour plus d'informations.
