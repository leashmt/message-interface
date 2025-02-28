# README pour messageInterface (Front-end, port 8080)

## Installation et exécution
1.	Configuration de la base de données :
	  - Exécute le script SQL situé dans :
       ```
      src/main/java/com/example/messageInterface/Ressources/schema.sql
      ```
    - Ce script crée la base de données et la table message.

2.	Lancer l’application :
  	- Assure-toi d’avoir Java 17+ et Spring Boot installés.
    - Compile et exécute avec :
      ```
      src/main/java/com/example/messageInterface/Ressources/schema.sql
      ```
## Fonctionnement
- Un formulaire permet d’envoyer un message, qui est stocké en base, sur la page ```localhost:8080```
- Une citation aléatoire est ensuite récupérée depuis quoteManager et affichée en réponse.
- Il est possible de voir tous les messages envoyés sur la page ```localhost:8080/messages/view```
