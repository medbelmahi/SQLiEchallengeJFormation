INSERT INTO SQLI_PROFILS (ID_PROFIL, DESCRIPTION, ELEMENTAIRE, NOM_PROFIL, ROLE_BASE) VALUES
(1, 'Administrateur', 1, 'Administrateur', 'Administrateur'),
(2, 'Formateur', 1, 'Formateur', 'Formateur'),
(3, 'Responsable de formation', 1, 'Responsable de formation', 'Responsable de formation');


INSERT INTO SQLI_ACTIONS (ID_PROFIL, ACTION_KEY) VALUES
(1, 'delete_utilisateur'),
(1, 'add_utilisateur'),
(1, 'update_utilisateur'),
(1, 'email_utilisateur'),
(1, 'delete_profil'),
(1, 'add_profil'),
(1, 'update_profil_actions'),
(1, 'delete_habilitation'),
(1, 'add_habilitation'),
(1, 'add_collaborateur'),
(1, 'update_collaborateur'),
(1, 'delete_collaborateur'),
(1, 'email_collaborateur'),
(1, 'update_collaborateur_habilitation'),
(3, 'add_formation'),
(3, 'update_formation'),
(3, 'delete_formation'),
(3, 'add_formation_sessions'),
(3, 'delete_formation_sessions'),
(3, 'update_formation_sessions'),
(3, 'add_formation_session_inscription'),
(3, 'delete_formation_evaluation_question'),
(3, 'add_formation_evaluation_question'),
(2, 'update_session_seances'),
(2, 'add_session_documents'),
(2, 'delete_session_documents'),
(2, 'add_session_absences');

INSERT INTO SQLI_UTILISATEURS (ID_UTILISATEUR, ADRESSE_UTILISATEUR, DATE_NAISSANCE_UTILISATEUR, EMAIL_UTILISATEUR, NOM_UTILSATEUR, PASSWORD_UTILISATEUR, PRENOM_UTILISATEUR, SEXE_UTILISATEUR, TELEPHONE_UTILISATEUR, URL_PHOTO_UTILISATEUR, ID_PROFIL) VALUES
(NULL, '08, Quartier Essabah, Rue Mokhtar Soussi', '1991-05-03', 'mouad.elfakir@gmail.com', 'EL Fakir', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'Mouad', 'Homme', '0611447674', 'avatar.png', 1);