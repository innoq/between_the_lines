CREATE SCHEMA IF NOT EXISTS jugendhilfe;

CREATE TABLE jugendhilfe.candidate (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR,
    address VARCHAR,
    postal_code VARCHAR,
    location VARCHAR,
    state VARCHAR,
    phone_numbers VARCHAR,
    mail VARCHAR,
    website VARCHAR
);