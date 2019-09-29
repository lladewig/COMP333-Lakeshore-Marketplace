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
    partner_id INT REFERENCES partner(partner_id),
    product_cost DECIMAL,
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

CREATE TABLE review(
    review_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    product_id INT REFERENCES product(product_id),
    review_body VARCHAR(255),
    review_score INT
);

CREATE TABLE product_order(
    order_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customer(customer_id),
    product_id INT REFERENCES product(product_id),
    payment_id INT REFERENCES payment(payment_id),
    order_cost DECIMAL,
    shipment_address INT REFERENCES address(address_id),
    order_status VARCHAR(255)
);