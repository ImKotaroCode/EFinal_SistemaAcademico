EL POSTMAN NO FUNCIONABA EN LA PC, PERO CONFIO EN QUE TODO ESTA BIEN.
USUARIOS PARA POBRAR:
ALUMNO:
username1 = alumno1
password = 123456
docente:
username = docente1
password = 123456

puerto = 8081
endpoints
login = localhost:8081/api/auth/login
{
  "username": "alumno1",
  "password": "123456"
}
logueado como alumno
ver notas = localhost:8081/api/notas/mis-notas

logueado como docente
{
  "username": "docente1",
  "password": "123456"
}

registrar = POST localhost:8081/api/notas/registrar

body:
  "alumnoId": 1,
  "asignaturaId": 1,
  "nota": 18
}
