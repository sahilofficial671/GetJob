CREATE TABLE users (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(80) NOT NULL,
    phone int DEFAULT NULL,
    age TINYINT DEFAULT NULL,
    UNIQUE(id, email),
    PRIMARY KEY id
)