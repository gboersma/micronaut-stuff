CREATE DATABASE mjob;
CREATE USER 'mjob'@'localhost' IDENTIFIED BY 'mjob';
GRANT ALL ON mjob.* TO 'mjob'@'localhost';
flush privileges;
