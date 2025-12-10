💰 Expense Tracker API – Backend

API REST desarrollada con Spring Boot para la gestión de gastos personales.
Permite crear, listar y filtrar gastos por mes y año, devolviendo la información lista para ser consumida por un frontend Angular.

🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

📌 Funcionalidades

✅ Crear gastos
✅ Listar todos los gastos
✅ Filtrar gastos por mes y año
✅ Cálculo del total mensual
✅ Arquitectura en capas (Controller · Service · Repository)
✅ Uso de DTOs para exponer la API
✅ Validación y manejo correcto de fechas

📂 Estructura del proyecto

src/main/java/GastosMensuales.Gastos
│
├── controller
│   └── ExpenseController.java
├── dto
│   └── ExpenseDTO.java
├── mapper
│   └── ExpenseMapper.java
├── model
│   └── Expense.java
├── repository
│   └── ExpenseRepository.java
├── service
│   └── ExpenseService.java
└── GastosApplication.java

🧩 Endpoints principales
Método	Endpoint	Descripción
POST	/api/expenses	Crear un gasto
GET	/api/expenses	Listar todos los gastos
GET	/api/expenses/filter?year=YYYY&month=MM	Filtrar por mes y año

🔗 Proyecto relacionado

👉 Frontend Angular:
https://github.com/Luiki17/gastos-front

👤 Autor

Desarrollado por Luis
Proyecto personal orientado a portfolio y aprendizaje práctico de Spring Boot.
