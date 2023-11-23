INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}jdbcDefault', true);

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');