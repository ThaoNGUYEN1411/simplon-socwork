DROP TABLE IF EXISTS t_accounts;

CREATE TABLE t_accounts(
	id INT GENERATED ALWAYS AS IDENTITY,
	username varchar(255),
	password varchar(16),
	CONSTRAINT t_account_pkey PRIMARY KEY (id),
	CONSTRAINT t_account_ukey UNIQUE (username)
);
