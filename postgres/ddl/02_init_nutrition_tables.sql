CREATE SCHEMA IF NOT EXISTS fitness;

CREATE TABLE IF NOT EXISTS fitness.product
(
    uuid UUID NOT NULL,
    dt_create TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    dt_update TIMESTAMP(6) WITH TIME ZONE NOT NULL,
    title TEXT NOT NULL,
    weight INT NOT NULL,
    calories INT NOT NULL,
    proteins NUMERIC(10,2) NOT NULL,
    fats NUMERIC(10,2) NOT NULL,
    carbohydrates NUMERIC(10,2) NOT NULL,
    CONSTRAINT uuid_product PRIMARY KEY (uuid),
    CONSTRAINT repeat UNIQUE(title, weight,calories, proteins,fats,carbohydrates)
);