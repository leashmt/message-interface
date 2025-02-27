-- Création de la base de données si elle n'existe pas
CREATE DATABASE IF NOT EXISTS BearSeller;
USE BearSeller;

-- Création de la table message
CREATE TABLE IF NOT EXISTS message (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(500) NOT NULL,
    author VARCHAR(255) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);