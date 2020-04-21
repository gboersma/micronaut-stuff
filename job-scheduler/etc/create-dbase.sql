CREATE DATABASE mjobs;
CREATE USER 'mjobs'@'localhost' IDENTIFIED BY 'mjobs';
GRANT ALL ON mjobs.* TO 'mjobs'@'localhost';
flush privileges;
