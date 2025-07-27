
CREATE TABLE roles (
	id INT NOT NULL AUTO_INCREMENT,
	code varchar(5) NULL,
	name varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);
\
INSERT INTO roles (id, code, name, description)
VALUES (1, 'A', 'Admin', 'Administration Role'), 
(2, 'U', 'User', 'Customer Role');

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    role_id INT NULL,
    name VARCHAR(50) NULL,
    email VARCHAR(100) NULL,
    username VARCHAR(25) NULL,
    password VARCHAR(255) NULL,
    salt VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);


ALTER TABLE users
ADD CONSTRAINT users_role_id_fk FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE users ADD COLUMN salt VARCHAR(255) NOT NULL DEFAULT '';

CREATE SEQUENCE users_id_seq;

ALTER TABLE users ALTER COLUMN id SET DEFAULT nextval('users_id_seq');

ALTER SEQUENCE users_id_seq OWNED BY users.id;

CREATE TABLE nasabah (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100) NOT NULL,
    umur INT NOT NULL
);

CREATE TABLE polis (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nasabah_id INT,
    jenis VARCHAR(50),
    premi DOUBLE,
    FOREIGN KEY (nasabah_id) REFERENCES nasabah(id)
);

CREATE TABLE klaim (
    id INT PRIMARY KEY AUTO_INCREMENT,
    polis_id INT,
    tanggal DATE,
    status VARCHAR(20),
    FOREIGN KEY (polis_id) REFERENCES polis(id)
);