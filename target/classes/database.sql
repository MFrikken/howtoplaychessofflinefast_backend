CREATE SCHEMA IF NOT EXISTS howtoplaychessofflinefast;
CREATE DATABASE IF NOT EXISTS howtoplaychessofflinefast;

USE howtoplaychessofflinefast;

CREATE TABLE IF NOT EXISTS played_games_entity (
    id INTEGER,
    count INTEGER,

    PRIMARY KEY(id)
    );

INSERT INTO played_games_entity VALUES (1, 0);