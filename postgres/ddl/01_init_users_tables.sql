CREATE SCHEMA IF NOT EXISTS fitness;

CREATE TABLE IF NOT EXISTS fitness.user_status
(
    id SMALLSERIAL NOT NULL,
    status TEXT NOT NULL,
    CONSTRAINT user_status_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fitness.user_role
(
    id SMALLSERIAL NOT NULL,
    role TEXT NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (id)
);

CREATE TABLE fitness.user
(
    uuid UUID NOT NULL,
    dt_create TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    dt_update TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    mail TEXT NOT NULL,
    fio TEXT NOT NULL,
    role SMALLINT NOT NULL,
    status SMALLINT NOT NULL,
    password TEXT NOT NULL,
    CONSTRAINT uuid PRIMARY KEY (uuid),
    FOREIGN KEY (role)
        REFERENCES fitness.user_role (id),
    FOREIGN KEY (status)
        REFERENCES fitness.user_status (id)
);
