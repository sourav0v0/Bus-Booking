# Bus-Booking
**Intro** ➡ 
  This project was done in my final year of graduation.The motive for building this project was to see how things interact to produce a major action. for example booking a ticket and canceling it . where there were two user and admin(The one who runs the business who can add busses and remove those busses) and an customer(the one who bookes the ticket) 

# Technology Used
- Backend  - Java
- Database - MYSQL
# Packages (Modules)
- pojo package 
  - basic class of the project the main object for the interaction eg - bus ,customer 
- dao package
  - It contains the interfaces and classes .Where in interfaces contains method(Actions) which an class can perform eg bus can be added and removed or search 
  - Classes contains the implentation of those interfaces
- util package
  - it contains classes related to things like database connection,Encryption do password,Mail of data
-Controller package
  - It contains the contoller classes which are noting but servelet classes which is use to controll the flow 
# Design Patten
- MVC 
  -The MVC is the industry standard patten it was a nice way to implement it 
    -M stands for model which is in our case POJO
    -V stands for view which is our JSP(Java server page)
    -C stands for controller which is our servelet


