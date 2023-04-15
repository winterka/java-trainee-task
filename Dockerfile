FROM postgres
COPY init.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_USER trainee
ENV POSTGRES_PASSWORD trainee
ENV POSTGRES_DB trainee-db
