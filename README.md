
# 🚀 Spring Boot REST API - Customers CRUD

API REST construida con Spring Boot que implementa operaciones CRUD (Create, Read, Update, Delete) sobre una lista de personas existentes en BD MySQL.
Este proyecto sirve como base para aprender desarrollo con Spring Boot y probar endpoints REST usando Postman.
Se utilizan los conceptos de Repository, Service.

## 📌 Características
- ✅ CRUD completo (Create, Read, Update, Delete).  
- ✅ API REST construida con Spring Boot.
- ✅ Persistencia en BD MySQL

---

## 🛠️ Tecnologías utilizadas
- **Java 17** → Lenguaje principal  
- **Spring Boot 3.3.7** → Framework  
- **Maven** → Gestión de dependencias  
- **Postman** → Pruebas de endpoints
- **MySQL** → Motor de Base de datos
- **IntelliJ IDEA** → IDE Desarrollo

---

## 📂 Estructura del proyecto
```bash

├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───RestAPI_Persona
│   │   │           ├───controller
│   │   │           ├───model
│   │   │           ├───repository
│   │   │           └───service
│   │   └───resources
│   └───test
│       └───java
│           └───com
│               └───RestAPI_Persona

```
---

## ⚙️ Instalación y ejecución
### 🔹 Requisitos previos

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)


## 🔹 Pasos

1. Clonar repositorio
git clone https://github.com/omarpedraza1979/springboot-crud-api-personas

2. Iniciar instancia de MySQL

3. Compilar y ejecutar
 ..springboot-crud-api-personas> mvn spring-boot:run

4. La API quedará disponible en:  
http://localhost:8080

---

## 📌 Endpoints principales

| Método | Endpoint                    | Descripción                        |
|--------|-----------------------------|------------------------------------|
| GET    | `/personas`                 | Listar las personas                |
| GET    | `/login`                    | Buscar persona por login/username  |
| POST   | `/guardarPersona`           | Crear persona                      |
| PUT    | `/editarPersona/{id}`       | Actualizar persona                 |
| DELETE | `/borrarPersona/{id}`       | Eliminar persona por ID            |


## 🧪 Ejemplo con CURL


**1. Listar todos las personas (GET)**

 curl -X GET http://localhost:8080/personas

**2. Buscar persona por login/username**

 curl -X POST http://localhost:8080/login \
     -H "Content-Type: application/json" \
     -d '{
           "login": "jugom",
           "password": "888844"
         }'

**2. Crear una nueva persona (POST)**

 curl -X POST http://localhost:8080/guardarPersona \
     -H "Content-Type: application/json" \
     -d '{
           "nombre": "Pablo Gomez",
           "telefono": "123456789",
           "ubicacion": "Cra 19 17-65",
           "login": "453535",
           "password": "567657567"
         }'
  
**3. Actualizar persona**

 curl -X PUT http://localhost:8080/editarPersona/1 \
     -H "Content-Type: application/json" \
     -d '{
           "nombre": "Pablo Garcia",
           "telefono": "987654321",
           "ubicacion": "Cra 19 17-65",
           "login": "453535",
           "password": "nuevaContraseña"
         }'  
  
**3. Eliminar persona por ID (DELETE)**

 curl -X DELETE http://localhost:8080/borrarPersona/1


## 🧪 Postman
Este proyecto incluye una colección de Postman para probar los endpoints de la API. 
[SpringBootPersonas.postman_collection.json](./SpringBootPersonas.postman_collection.json)


## 📌 Ejemplos de Body JSON

### POST → Crear persona
```json

{
     "nombre": "Pablo Gomez",
     "telefono": "sssssss",
     "ubicacion": "Cra 19 17-65",
     "login": "453535",
     "password": "567657567"
}
```

### PUT → Actualizar persona
```json
{
     "nombre": "Pablo Garcia",
     "telefono": "sssssss",
     "ubicacion": "Cra 19 17-65",
     "login": "453535",
     "password": "567657567"
}
```

---
## 🧪 Pruebas
```bash
mvn test
```
---

## 👨‍💻 Autor
- **Omar Orlando Pedraza Garzón**
- [GitHub](https://github.com/omarpedraza1979)
---


## 📜 Licencia
Este proyecto está bajo la licencia [MIT](LICENSE).  
Eres libre de usarlo, modificarlo y distribuirlo con fines personales o educativos.


