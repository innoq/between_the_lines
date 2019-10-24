CREATE SCHEMA IF NOT EXISTS jugendhilfe;

CREATE TABLE jugendhilfe.candidate (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR,
    address VARCHAR,
    postalcode VARCHAR,
    location VARCHAR,
    state VARCHAR,
    phonenumber VARCHAR,
    mail VARCHAR,
    website VARCHAR
);