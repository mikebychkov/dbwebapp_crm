
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id serial,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    PRIMARY KEY (id)
);

INSERT INTO customer VALUES
(1,'David','Adams','david@luv2code.com'),
(2,'John','Doe','john@luv2code.com'),
(3,'Ajay','Rao','ajay@luv2code.com'),
(4,'Mary','Public','mary@luv2code.com'),
(5,'Maxwell','Dixon','max@luv2code.com');

SELECT * FROM customer;
