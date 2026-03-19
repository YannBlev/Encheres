-- INSERTION D'UTILISATEURS

-- ADMIN
INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES('admin' , 'ADMIN', 'admin', 'admin@admin.test', '00000000', 'Rue Admninistratif', '44500', 'Adminville', '{bcrypt}$2a$10$B5U29ajHsIKd8aY3c/JNn.xTJpOCAeoXvT9XvfzbbHGP4iIFV9Lkm', 100, 1); -- MDP : stephane

-- UTILISATEUR
INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES('user1' , 'USER1', 'user1', 'user1@user.test', '00000000', 'Rue Utilisateur', '55401', 'UserOneville', '{bcrypt}$2a$10$VwQ7gMUPLeQnFC6vCsOoTevzdPe.JPu0L/7cwPGdJ6TjSpipGwY.y', 50, 0); -- MDP : julien

INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES('user2' , 'USER2', 'user2', 'user2@user.test', '00000000', 'Rue Utilisateur', '55402', 'UserTwoville', '{bcrypt}$2a$10$VwQ7gMUPLeQnFC6vCsOoTevzdPe.JPu0L/7cwPGdJ6TjSpipGwY.y', 50, 0); -- MDP : julien

INSERT INTO UTILISATEUR (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES('user3' , 'USER3', 'user3', 'user3@user.test', '00000000', 'Rue Utilisateur', '55403', 'UserThreeville', '{bcrypt}$2a$10$VwQ7gMUPLeQnFC6vCsOoTevzdPe.JPu0L/7cwPGdJ6TjSpipGwY.y', 50, 0); -- MDP : julien

-- INSERTION CATEGORIE
INSERT INTO CATEGORIE (libelle) VALUES('Sport&Loisirs');
INSERT INTO CATEGORIE (libelle) VALUES('Vêtement');
INSERT INTO CATEGORIE (libelle) VALUES('Informatique');
INSERT INTO CATEGORIE (libelle) VALUES('Ameublement');