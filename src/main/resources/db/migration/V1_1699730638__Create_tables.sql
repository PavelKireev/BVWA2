CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users
(
    id           BIGSERIAL PRIMARY KEY,
    uuid         TEXT        NOT NULL DEFAULT uuid_generate_v4(),
    first_name   TEXT        NOT NULL,
    last_name    TEXT        NOT NULL,
    phone_number TEXT,
    email        TEXT UNIQUE NOT NULL,
    password     TEXT        NOT NULL,
    role         TEXT        NOT NULL,
    created_at   TIMESTAMP            DEFAULT NOW(),
    updated_at   TIMESTAMP            DEFAULT NOW()
);

CREATE TABLE admin
(
    id BIGINT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE doctor
(
    id            BIGINT PRIMARY KEY,
    office_number INT,
    phone_number  TEXT,
    FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE patient
(
    id           BIGINT PRIMARY KEY,
    birthday     DATE,
    FOREIGN KEY (id) REFERENCES users (id)
);

CREATE TABLE appointment
(
    id           BIGSERIAL PRIMARY KEY,
    uuid         TEXT NOT NULL DEFAULT uuid_generate_v4(),
    doctor_uuid  TEXT NOT NULL,
    patient_uuid TEXT NOT NULL,
    time         TIMESTAMP WITH TIME ZONE
);

CREATE TABLE working_hours
(
    id          BIGSERIAL PRIMARY KEY,
    uuid        TEXT NOT NULL DEFAULT uuid_generate_v4(),
    doctor_uuid TEXT NOT NULL,
    day_of_week TEXT NOT NULL,
    hour_from   INT  NOT NULL,
    hours_count INT  NOT NULL
);

WITH new_user AS (
    INSERT INTO users (first_name, last_name, email, password, role)
        VALUES ('admin', 'admin', 'admin@admin.com',
                '$2a$10$1heAywaRY7r/ACJlSSK84eiFy59T7D1SZM7lBUdsKb3f9I2xz7sjy', 'ADMIN')
        RETURNING id)
INSERT
INTO admin (id)
SELECT id
FROM new_user;