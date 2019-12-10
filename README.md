# Lakeshore Marketplace

This is a group project created by Lindsay, Carolina, and Maha for COMP333: Web Services.

## Local Database Setup

This guide assumes that you have PostgreSQL properly configured and installed.

To setup the database on your local machine, run: 
```bash
sudo -u $USER psql < setup.sql
```

You should now be able to see the database on the local machine. 

Maven dependencies should take care of the rest for you. 

In `hibernate.cfg.xml`, make sure to change the `connection.username` to reflect what your username is for PostgreSQL. This will usually be the same as your $USER variable.

## Remote Database (RDS AWS)

Now, we have a database on AWS. If you would like to connect to the database from the command line, use this command:
```bash
psql --host=webservices-lakeshore-mp.clvkxzutxsxi.us-east-2.rds.amazonaws.com --port=5432 --username=webservices --password --dbname=lakeshore_marketplace
```

## Database Model
This is the model of our database used in this project.
![LMP Lakeshore Marketplace DB](https://github.com/lladewig/COMP333-Project-2/blob/master/LMP%20Database%20Model.png)

## State Diagram
This is our state diagram.
![LMP Lakeshore Marketplace State Diagram](https://github.com/lladewig/COMP333-Lakeshore-Marketplace/blob/state/state%20diagram.png)

# API
Featured here are some sample responses and requests from the various service endpoints. Currently, each endpoint accepts `JSON` and `XML`, but all sample responses and requests are shown in `XML`. Additionally, each endpoint and its respective HTTP verb are shown.

All endpoints that retrieve all of an item support pagination. If offset is not specified, it defaults to 0. If limit is not specified, it defaults to 5, with the exception for retrieving all payments for a specific customer, in which case the limit defaults to 20.
## Customer
The Customer endpoint has the following URIs and corresponding methods:

Main Customer endpoint URI: `/customerservice/`

Get Customer by ID:
``` 
@GET
/customers/{customerID}
```
Get all customers: 
```
@GET
/customers
```
Add customer:
```
@POST
/customers
```
Delete customer:
```
@DELETE
/customers/{customerID}
```
Update Customer's First Name:
```
@PUT
/customers/first
```
Update Customer's Last Name:
```
@PUT
/customers/last
```
Update Customer's phone number:
```
@PUT
/customers/phone
```
### Below are some sample requests and responses
`CustomerRequest` sample:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<CustomerRequest>
        <firstName>Karen</firstName>
        <lastName>Johnson</lastName>
        <phoneNumber>12345678</phoneNumber>
</CustomerRequest>
```

`Customer` sample:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Customer>
        <customerID>1</customerID>
        <firstName>Karen</firstName>
        <lastName>Johnson</lastName>
        <phoneNumber>12345678</phoneNumber>
</Customer>
```

## Address
The Address endpoint has the following URIs and corresponding methods:

Main Address endpoint URI: `/addressservice/`

Get Address by ID:
``` 
@GET
/addresses/{addressID}
```
Get all addresses: 
```
@GET
/addresses
```
Add address:
```
@POST
/addresses
```
Delete address:
```
@DELETE
/addresses/{addressID}
```

### Below are some sample requests and responses

`AddressRequest` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<AddressRequest>
    <customerID>1</customerID>
    <streetAddress>123 Main St</streetAddress>
    <unitNumber>1</unitNumber>
    <zipCode>12345</zipCode>
    <city>Chicago</city>
    <state>IL</state>
</AddressRequest>
```

`Address` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Address>
    <addressID>1</addressID>
    <customer>
        <customerID>1</customerID>
        <firstName>John</firstName>
        <lastName>Doe</lastName>
        <phoneNumber>12345678</phoneNumber>
    </customer>
    <streetAddress>123 Main St</streetAddress>
    <unitNumber>1</unitNumber>
    <zipCode>12345</zipCode>
    <city>Chicago</city>
    <state>IL</state>
</Address>
```


## Payment 
The Payment endpoint has the following URIs and corresponding methods:

Main Payment endpoint URI: `/paymentservice/`

Get payment by ID:
``` 
@GET
/payments/{paymentID}
```
Get all payments: 
```
@GET
/payments
```
Get all payments for a customer: 
```
@GET
/payments/customer/{customerID}
```
Add payment:
```
@POST
/payments
```
Delete address:
```
@DELETE
/payments/{paymentID}
```
Update payment card number:
```
@PUT
/payments/card
```
Update payment security code:
```
@PUT
/payments/security
```
Update payment expiration date:
```
@PUT
/payments/expiration
```
Update payment address:
```
@PUT
/payments/address
```
### Below are some sample requests and responses

`PaymentRequest` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<PaymentRequest>
        <customerID>1</customerID>
        <paymentID>1</paymentID>
        <cardNumber>1234567</cardNumber>
        <securityCode>123</securityCode>
        <expirationDate>12/24</expirationDate>
        <addressID>1</addressID>
</PaymentRequest>
```
`Payment` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Payment>
    <paymentID>1</paymentID>
    <cardNumber>1234567</cardNumber>
    <securityCode>123</securityCode>
    <expirationDate>12/24</expirationDate>
    <address>
        <addressID>1</addressID>
        <city>Chicago</city>
        <customer>
            <customerID>1</customerID>
            <firstName>Karen</firstName>
            <lastName>Johnson</lastName>
            <phoneNumber>12345678</phoneNumber>
        </customer>
        <state>IL</state>
        <streetAddress>567 street st</streetAddress>
        <unitNumber>3</unitNumber>
        <zipCode>123456</zipCode>
    </address>
</Payment>
```
## Partner
The Partner endpoint has the following URIs and corresponding methods:

Main Partner endpoint URI: `/partnerservice/`

Get partner by ID:
``` 
@GET
/partners/{partnerID}
```
Get all partners: 
```
@GET
/partners
```
Add partner:
```
@POST
/partners
```
Delete partner:
```
@DELETE
/partners/{partnerID}
```
Update partner name:
```
@PUT
/partners/name
```
Update partner details:
```
@PUT
/partners/details
```
### Below are some sample requests and responses

`PartnerRequest` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<PartnerRequest>
    <partnerName>Kutsu Incorporated</partnerName>
    <partnerType>3rd Party</partnerType>
    <partnerDetails>Sells shoes and socks</partnerDetails>
</PartnerRequest>
```

`Partner` sample:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Partner>
    <partnerID>1</partnerID>
    <partnerName>Kutsu Incorporated</partnerName>
    <partnerType>3rd Party</partnerType>
    <partnerDetails>Sells shoes and socks</partnerDetails>
</Partner>
```
