CREATE SCHEMA IF NOT EXISTS fitness;

CREATE TABLE IF NOT EXISTS fitnessStudio.user_status
(
    id SMALLSERIAL NOT NULL,
    status text NOT NULL,
    CONSTRAINT user_status_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fitnessStudio.user_role
(
    id SMALLSERIAL NOT NULL,
    role text NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (id)
);

CREATE TABLE fitnessStudio.user
(
    uuid uuid NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    dt_update timestamp without time zone NOT NULL,
    mail text NOT NULL,
    fio text NOT NULL,
    role smallint NOT NULL,
    status smallint NOT NULL,
    password text NOT NULL,
    CONSTRAINT uuid PRIMARY KEY (uuid),
    FOREIGN KEY (role)
        REFERENCES fitnessStudio.user_role (id),
    FOREIGN KEY (status)
        REFERENCES fitnessStudio.user_status (id)
);
