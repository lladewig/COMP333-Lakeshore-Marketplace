# Lakeshore Marketplace

This is a group project created by Lindsay, Carolina, and Maha for COMP333: Web Services.

## Local Database Setup

This guide assumes that you have PostgreSQL properly configured and installed.

To setup the database on your local machine, run: 
```
sudo -u $USER psql < setup.sql
```

You should now be able to see the database on the local machine. Eventually, the database will be hosted on AWS.

Maven dependencies should take care of the rest for you. 