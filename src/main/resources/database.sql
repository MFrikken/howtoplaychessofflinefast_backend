CREATE SCHEMA IF NOT EXISTS howtoplaychessofflinefast;
CREATE DATABASE IF NOT EXISTS howtoplaychessofflinefast;

USE howtoplaychessofflinefast;

CREATE TABLE IF NOT EXISTS played_games_entity (
    id INTEGER,
    count INTEGER,

    PRIMARY KEY(id)
);

INSERT INTO played_games_entity VALUES (1, 0);


CREATE TABLE IF NOT EXISTS compliments (
    id INTEGER,
    compliment VARCHAR (255),

    PRIMARY KEY(id)
);

INSERT INTO compliments VALUES (
                                "You´re awesome!",
                                "What a lovely outfit today!",
                                "Your smile is soo charming <3"
                               );