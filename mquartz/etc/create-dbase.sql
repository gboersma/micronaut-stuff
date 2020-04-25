CREATE DATABASE mquartz;
CREATE USER 'mquartz'@'localhost' IDENTIFIED BY 'mquartz';
GRANT ALL ON mquartz.* TO 'mquartz'@'localhost';
flush privileges;
