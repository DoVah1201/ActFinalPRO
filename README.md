
# 📓 Notas API - Spring Boot

Una API RESTful desarrollada con Spring Boot para gestionar usuarios y sus notas personales. Esta aplicación demuestra conceptos avanzados de POO, JPA, validaciones, controladores REST versionados y manejo robusto de errores.

---

## 🎯 Objetivos del Proyecto

- Modelar entidades JPA con relaciones bidireccionales.
- Aplicar herencia y abstracción con interfaces y clases abstractas (`CrudService`, `AbstractCrudService`).
- Exponer una API REST versionada con validaciones y buen manejo de errores.
- Demostrar el uso de transacciones, `cascade = ALL`, y `orphanRemoval = true`.
- Probar la API con herramientas como Postman o cURL.

---

## 🧱 Estructura de Paquetes

```
com.tuapp.notasapi
├── controller       → Controladores REST
├── model            → Entidades JPA
├── repository       → Repositorios JPA
├── service          → Lógica de negocio e interfaces
└── exception        → Manejo de errores global
```

---

## 🗃️ Entidades

### Usuario

- `id` (Long)
- `nombre` (String)
- `email` (String, único)
- `passwordHash` (String)
- `List<Nota>` → relación 1:N con cascade + orphanRemoval

### Nota

- `id` (Long)
- `titulo` (String)
- `contenido` (Lob)
- `fechaCreacion` (LocalDateTime)
- `usuario` (Usuario)

---

## 🔄 Relaciones

- **Usuario ↔ Nota**: Un usuario puede tener muchas notas.
- Las notas se guardan/borran automáticamente con el usuario (`cascade = ALL`).
- Notas huérfanas se eliminan automáticamente (`orphanRemoval = true`).

---

## 🧩 Servicios

- `CrudService<T, ID>` → interfaz genérica
- `AbstractCrudService<T, ID>` → lógica común con `JpaRepository`
- `UsuarioService` / `NotaService` → lógica de dominio
- `UsuarioServiceImpl`, `NotaServiceImpl` → implementación de servicios

---

## 🌐 Endpoints REST

### V1 - Usuarios (`/api/v1/usuarios`)

| Método | Ruta                  | Descripción                    |
|--------|------------------------|--------------------------------|
| GET    | /usuarios              | Obtener todos los usuarios     |
| GET    | /usuarios/{id}         | Obtener usuario por ID         |
| POST   | /usuarios              | Crear usuario con validación   |
| PUT    | /usuarios/{id}         | Actualizar usuario             |
| DELETE | /usuarios/{id}         | Eliminar usuario               |

### V2 - Autenticación (`/api/v2`)

| Método | Ruta             | Descripción                         |
|--------|------------------|-------------------------------------|
| POST   | /sign-in         | Iniciar sesión con email y password|

### V1 - Notas (`/api/v1/notas`)

| Método | Ruta                        | Descripción                              |
|--------|-----------------------------|------------------------------------------|
| GET    | /notas                      | Obtener todas las notas                  |
| GET    | /notas?usuarioId=1&order=asc| Filtrar notas por usuario y orden        |
| GET    | /notas/{id}                 | Obtener nota por ID                      |
| POST   | /notas?usuarioId=1          | Crear nota para un usuario               |
| PUT    | /notas/{id}                 | Actualizar nota                          |
| DELETE | /notas/{id}                 | Eliminar nota                            |

---

## ✅ Validaciones

Se usa `javax.validation` con anotaciones como:

- `@NotBlank`
- `@Email`
- `@Size`
- `@Positive`
- `@Valid` en controladores

---

## ❌ Manejo de errores

- `@ControllerAdvice` y `@ExceptionHandler`
- `ResponseStatusException` para errores 400 y 404 personalizados
- Respuestas de error en formato JSON claro para frontend/Postman

---

## 🧪 Pruebas con Postman

Ejemplo POST usuario:
```json
POST /api/v1/usuarios
{
  "nombre": "Juan Pérez",
  "email": "juan@example.com",
  "passwordHash": "1234"
}
```

Ejemplo POST nota:
```json
POST /api/v1/notas?usuarioId=1
{
  "titulo": "Mi primera nota",
  "contenido": "Texto de la nota..."
}
```

---

## ⚙️ Tecnologías

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Bean Validation (Hibernate Validator)
- H2 / MySQL (configurable)
- Lombok
- Postman / cURL para pruebas

---

## 🚀 Cómo ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/notas-api.git
   cd notas-api
   ```

2. Construye y ejecuta:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Accede a:
   ```
   http://localhost:8080/api/v1/usuarios
   http://localhost:8080/api/v1/notas
   ```

---

## 🛠 Configuración `application.properties` de ejemplo

```properties
spring.datasource.url=jdbc:h2:mem:notasdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

---

## 📎 Hecho por

Saúl González y Marisa Peña
