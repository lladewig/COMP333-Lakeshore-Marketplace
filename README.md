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
