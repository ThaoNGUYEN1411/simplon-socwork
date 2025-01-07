DROP TABLE IF EXISTS t_account_roles;
DROP TABLE IF EXISTS t_accounts;
DROP TABLE IF EXISTS t_roles;

CREATE TABLE t_accounts(
	id INT GENERATED ALWAYS AS IDENTITY,
	username varchar(200),
	password varchar(255),
	CONSTRAINT t_account_pkey PRIMARY KEY (id),
	CONSTRAINT t_account_nkey UNIQUE (username)
);

CREATE TABLE t_roles(
	id INT GENERATED ALWAYS AS IDENTITY,
	role_name varchar(200)NOT NULL UNIQUE,
	role_default boolean DEFAULT FALSE,
	CONSTRAINT t_role_pkey PRIMARY KEY (id),
	CONSTRAINT t_role_nkey UNIQUE (role_name)
	);

CREATE TABLE t_account_roles(
	account_id INT NOT NULL,
	role_id INT NOT NULL,
	CONSTRAINT t_account_roles_ukey UNIQUE (account_id, role_id),
	CONSTRAINT t_account_roles_account_fkey FOREIGN KEY (account_id) REFERENCES t_accounts(id),
	CONSTRAINT t_account_roles_role_fkey FOREIGN KEY (role_id) REFERENCES t_roles(id)
);