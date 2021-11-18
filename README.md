# RateMovie - Haaga-Helia Palvelinohjelmointi kurssin harjoitustyö
	- Java Spring Boot
	
# Roles (Roles from Enum):
 	- ADMIN: can remove users, add/rename genres, add/edit/delete movies
 	- MOD: can add movies to database
 	- USER: can rate movies
 
# Java Spring Security
	- Authentication
 
# Thymeleaf
	- All HTML files in /resources
	- Custom Error page (ErrorController)
	- Custom Login page (SiteController/login.html)
 
# JPA
	- ManyToMany - ManyToOne - OneToMany database tables
	- H2 Database
	- JPA Custom Query (MovieRepository)
	- Cascade (User.class = When User removed -> Ratings from user removed) 
 
# Spring Boot Rest
 	- All RestControllers
 	
# Testing
 	- Few AssertThat tests for MovieRepository