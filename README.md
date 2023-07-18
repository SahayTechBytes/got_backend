# got_backend

List of api

GET Request 
http://localhost:8080/api/character/houses - In response returns a list of all unique house names.
Example :   ["Lannister","Frey","Martell","Tyrell","Tully","Targaryen","Baratheon","Umber","Bolton","Mormont","Stark","Greyjoy","Arryn","Tarly"]


http://localhost:8080/api/character/{houseName} In response returns json with all characters belonging to a given house

http://localhost:8080/api/character/familytree/{houseName} In response returns all the characterName of given houseName

http://localhost:8080/api/character/favorites In response returns all json with characterName, houseName and image which is marked as favourite


PUT request
http://localhost:8080/api/character/{id}/favourite It will marks/unmark a character as a favourite with that particular id


Update application.properties with your database details
spring.datasource.url=jdbc:postgresql://localhost:{port_number}/{database_name}
spring.datasource.username={username}
spring.datasource.password={password}

Update Maven
Build your project
Run as Spring Boot App
