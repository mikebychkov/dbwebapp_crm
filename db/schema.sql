
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id serial,
    first_name varchar(45),
    last_name varchar(45),
    email varchar(45),
    PRIMARY KEY (id)
);

INSERT INTO customer VALUES
('David','Adams','david@luv2code.com'),
('John','Doe','john@luv2code.com'),
('Ajay','Rao','ajay@luv2code.com'),
('Mary','Public','mary@luv2code.com'),
('Maxwell','Dixon','max@luv2code.com');

SELECT * FROM customer;
