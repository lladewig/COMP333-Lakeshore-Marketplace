DROP DATABASE lakeshore_marketplace;
CREATE DATABASE lakeshore_marketplace;
\c lakeshore_marketplace

CREATE TABLE partner(
    partner_id SERIAL PRIMARY KEY,
    partner_name VARCHAR(255),
    partner_type VARCHAR(255),
    partner_details VARCHAR(255)
);

CREATE TABLE product(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    partner_owner INT REFERENCES partner(partner_id),
    product_cost FLOAT,
    product_description VARCHAR(255)
);

CREATE TABLE customer(
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone_number INT
);

CREATE TABLE address(
    address_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    street_address VARCHAR(255),
    unit_number VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code INT
);

CREATE TABLE payment(
    payment_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    card_number INT,
    security_code INT,
    expiration_date VARCHAR(255),
    billing_address INT REFERENCES address(address_id)
);

CREATE TABLE review_score(
    review_score_id SERIAL PRIMARY KEY,
    review_score INT,
    review_score_details VARCHAR(255)
);

INSERT INTO review_score(review_score, review_score_details) VALUES (1, '1 star');
INSERT INTO review_score(review_score, review_score_details) VALUES (2, '2 stars');
INSERT INTO review_score(review_score, review_score_details) VALUES (3, '3 stars');

CREATE TABLE review(
    review_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    product_id INT REFERENCES product(product_id),
    review_body VARCHAR(255),
    billing_address INT REFERENCES review_score(review_score_id)
);


CREATE TABLE order_status(
    order_status_id SERIAL PRIMARY KEY,
    order_status_name VARCHAR(255),
    order_status_details VARCHAR(255)
);

INSERT INTO order_status(order_status_name, order_status_details) VALUES ('processing', 'The order is being processed.');
INSERT INTO order_status(order_status_name, order_status_details) VALUES ('shipped', 'The order is being shipped to you.');
INSERT INTO order_status(order_status_name, order_status_details) VALUES ('delivered', 'The order has been delivered.');
INSERT INTO order_status(order_status_name, order_status_details) VALUES ('canceled', 'The order has been canceled.');

CREATE TABLE proudct_order(
    order_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    product_id INT REFERENCES product(product_id),
    payment_id INT REFERENCES payment(payment_id),
    order_cost FLOAT,
    shipment_address INT REFERENCES address(address_id),
    order_status_id INT REFERENCES order_status(order_status_id)
);