-- Create the customers table
CREATE TABLE customers (
    customer_id BIGINT PRIMARY KEY,
    customer_name VARCHAR(50),
    contact_name VARCHAR(50),
    country VARCHAR(50)
);

-- insert statements for Table 1: customers
INSERT INTO customers (customer_id, customer_name, contact_name, country) VALUES
(1, 'Customer 1', 'John Smith', 'USA'),
(2, 'Customer 2', 'Jane Doe', 'Canada'),
(3, 'Customer 3', 'Miguel Rodriguez', 'Mexico');