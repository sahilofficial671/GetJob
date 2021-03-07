CREATE TABLE users (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(80) NOT NULL,
    phone int DEFAULT NULL,
    age TINYINT DEFAULT NULL,
    UNIQUE(id, email),
    PRIMARY KEY id
)

CREATE TABLE jobs (
    id int AUTO_INCREMENT NOT NULL,
    title varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    company varchar(100) NOT NULL,
    location varchar(100) NOT NULL,
    salary_offered int NOT NULL,
    min_exp int NOT NULL,
    max_exp int NOT NULL,
    PRIMARY KEY (id)
)
insert into jobs (title, description, company, location, salary_offered, min_exp, max_exp) values ('Software Enginner', 'Permanent Job', 'HCL', 'Gurgaon', 30000, 18, 27)