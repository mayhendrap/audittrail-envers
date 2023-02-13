CREATE TABLE IF NOT EXISTS revision_info
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY,
    timestamp BIGINT,
    username  VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id            VARCHAR PRIMARY KEY NOT NULL,
    username      VARCHAR             NOT NULL,
    password      VARCHAR             NOT NULL,
    created_date  timestamptz         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified timestamptz,
    created_by    VARCHAR,
    modified_by   VARCHAR
);

CREATE TABLE IF NOT EXISTS products
(
    id            VARCHAR PRIMARY KEY NOT NULL,
    name          VARCHAR             NOT NULL,
    description   VARCHAR             NOT NULL,
    created_date  timestamptz         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified timestamptz,
    created_by    VARCHAR,
    modified_by   VARCHAR
);