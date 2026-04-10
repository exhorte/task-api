FROM mysql:8.0

# Copie du script SQL d'initialisation dans le répertoire d'entrée de MySQL
# Tous les scripts dans ce dossier sont exécutés au démarrage du conteneur
COPY taskdb.sql /docker-entrypoint-initdb.d/

ENV MYSQL_DATABASE=taskdb
ENV MYSQL_ROOT_PASSWORD=root
