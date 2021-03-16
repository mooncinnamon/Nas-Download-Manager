DROP TABLE IF EXISTS config;

CREATE TABLE config
(
    seq  INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(250) NOT NULL,
    url  VARCHAR(250) NOT NULL
);

INSERT INTO config (type, url)
VALUES ('video', '/Users/mooncinnamon/Project/Temp/Video');