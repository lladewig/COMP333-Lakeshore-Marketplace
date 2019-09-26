# Lakeshore Marketplace

This is a group project created by Lindsay, Carolina, and Maha for COMP333: Web Services.

## Local Database Setup

This guide assumes that you have PostgreSQL and Apache Maven properly configured and installed.

To setup the database on your local machine, run: 
```
sudo -u $USER psql < setup.sql
```

You should now be able to see the database on the local machine. Eventually, the database will be hosted on AWS.

To connect your application and the database, you will need to download the [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html). Download the 4.2 driver. 

Once this has been downloaded, install the JAR file to your maven lib. For example, on my machine, the path to my maven lib is:
```
/usr/local/Cellar/maven/3.6.2/libexec/lib/
```
Maven dependencies should take care of the rest for you. 