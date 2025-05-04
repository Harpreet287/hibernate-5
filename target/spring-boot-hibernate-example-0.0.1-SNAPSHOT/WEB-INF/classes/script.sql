-- Create the userdetails table with id as auto-incrementing primary key
-- and columns for email, firstname, lastname, and password
create table userdetails (
    id integer not null auto_increment,  -- Primary key with auto-increment
    email varchar(255),                  -- User's email address
    firstname varchar(255),              -- User's first name
    lastname varchar(255),               -- User's last name
    password varchar(255),               -- User's password (stored as plaintext, not secure for production)
    primary key (id)                     -- Define id as the primary key
) ENGINE=InnoDB;                         -- Use InnoDB storage engine for transaction support

-- Insert admin user record
INSERT INTO userdetails(email,firstname,lastname,password) 
VALUES ('admin@admin.com','admin','admin','admin');

-- Insert sample user "John Doe"
INSERT INTO userdetails(email,firstname,lastname,password) 
VALUES ('john@gmail.com','john','doe','johndoe');

-- Insert sample user "Sham Tis"
INSERT INTO userdetails(email,firstname,lastname,password) 
VALUES ('sham@yahoo.com','sham','tis','shamtis');