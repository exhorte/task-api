-- Création de la table tasks si elle n'existe pas
CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50) DEFAULT 'TODO',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Suppression des anciennes données de test (optionnel)
DELETE FROM tasks WHERE title = 'workout';

-- Insertion d'une donnée initiale
INSERT INTO tasks (title, description, status)
VALUES ('workout', 'workout then 4 hours', 'TODO');

-- Exemple d'update sur une tâche (ici une tâche imaginaire ou celle qu'on vient de créer)
UPDATE tasks SET status = 'IN_PROGRESS' WHERE title = 'workout';