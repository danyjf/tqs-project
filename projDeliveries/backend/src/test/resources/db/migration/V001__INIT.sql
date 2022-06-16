CREATE TABLE user (
    id INT PRIMARY KEY,
    username VARCHAR(255) not null,
    email VARCHAR(255) not null,
    password VARCHAR(255) not null,
    phone VARCHAR(255) not null,
    type VARCHAR(255) not null
);
