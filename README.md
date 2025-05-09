# SpringMVC

Cvičení 9 a 10

## APIController   
Jednoduchý @RestController pro testy, vrací výsledky v JSON formátu:    
### Users:
Vrátí všechny UserEntity sestupně podle id -findAllByOrderByIdDesc():  
http://localhost:9090/api/users/getall

Vrátí entitu nalezenou podle userName:  
http://localhost:9090/api/users/searchbyusername?username=pe

Vrátí seznam List<UserEntity> nalezených podle Emailu:  
http://localhost:9090/api/users/searchbyemail?email=.com

Vytvoří UserEntity na základě requestu v cestě:  
http://localhost:9090/api/users/createuser/testname/testemail@testdomain.com

Vytvoří UserEntity na základě requestu v parametrech:  
http://localhost:9090/api/users/createuser?username=testname&email=testmail@testdomain.com  

### Articles
Vrátí všechny články:  
http://localhost:9090/api/articles/getall

Vrátí články podle id uživatele (autora)  
http://localhost:9090/api/articles/getbyuserid/1





