# hotelManagement

A hotel management system with 2 REST API endpoints

# Overview 
The system is build using Spring boot framework, hibernate and mysql for datastore. I chose spring framework because of its a lightweight framework, faster development, support for hibernate providing easy data access and easy compatibility with any datastore (may be Node.js would have been faster, but spring is the one I am most comfortable with). 
The datastore could have been anything, I wanted to use a relational database and I am most comfortable with MySQL. For a application of this scale I could have gone with MongoDB as there are no foreign key involved and just data to dump in the db, but thinking about the future of the system I thought a relational database would be a better choice.

# Usage
I built this using IntelliJ IDEA, you can use eclipse if you want. To run the system, import this as a Spring project, import all the maven dependencies, build it and run it, you should be good. Since it is a REST API, I used Postman for testing the endpoints. The URLs to be used and data format to be sent is given below.

# Endpoints testing

1. Add/Update booking configuration

URL : http://localhost:8080/bookingConfig

METHOD : POST

HEADER : Content-Type - application/json

BODY :
 
[{
	"configName" : "overbooking",
	"configNumber" : 11
},
{
	"configName" : "rooms",
	"configNumber" : 10
}]


2. Make a new booking by adding guest details

URL : http://localhost:8080/addGuestDetails

METHOD : POST

HEADER : Content-Type - application/json

BODY :
 
{
	"guestName": "Guest",
	"guestEmail": "guest@gmail.com",
	"arrival": "2017-02-09",
	"departure": "2017-02-12"
}

RETURN :
 
{
        "guestId": 3,
	"guestName": "Guest",
	"guestEmail": "guest@gmail.com",
	"arrival": "2017-02-09",
	"departure": "2017-02-12"
}

RETURN ERROR :
 
{
    "404": "Booking limit reached for Sat Feb 11 00:00:00 PST 2017"
}
