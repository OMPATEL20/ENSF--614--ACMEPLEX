CREATE DATABASE ENSF614ACMEPLEX;
USE ENSF614ACMEPLEX;
CREATE TABLE IF NOT EXISTS MOVIE
    (movieId            int             NOT NULL,
     title                VARCHAR(30)        NOT NULL,
	rating                double            NOT NULL,
     theaterId            int            NOT NULL,
     releasedate           date        NOT NULL,
     PRIMARY KEY (movieId),
     foreign key(theaterId) references THEATER(theaterId)
);
INSERT INTO MOVIE (movieId,title,rating,theaterId,releasedate) VALUES
("1","Anchorman","4","1","2022-12-01"),
("2","The Lion King","5","1","2021-12-02"),
("3","Titanic","5","2","2021-12-01"),
("4","Pulp Fiction","4","1","2021-11-01"),
("5","Finding Nemo","3","2","2021-12-03");




INSERT INTO THEATER (theaterId, theaterName) VALUES
("1", "Sunridge Spectrum"),
("2", "Market Mall"),
("3", "Deerfoot City"),
("4", "Country Hills"),
("5", "Seton Cineplex");



