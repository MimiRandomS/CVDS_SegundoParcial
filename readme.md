# Segundo Parcial
## 1. Generación de la estructura del proyecto con Spring Initializr

Para iniciar el proyecto, utilizamos [Spring Initializr](https://start.spring.io/) con la siguiente configuración:

### **Configuración de los campos:**
- **Group**: `edu.eci.cvds.parcial`
- **Artifact**: `ECICredit`
- **Name**: `ECICredit`

### **Dependencias requeridas**
Las siguientes dependencias son necesarias para el desarrollo del proyecto:
- **Spring Web**: Para la creación del API REST.
- **OpenFeign**: Para la comunicación entre servicios.
- **Lombok**: Para reducir el código repetitivo mediante anotaciones.
- **Spring Data MongoDB**: Para el uso de MongoDB como base de datos.

![springInitalizr.png](assets%2Fimgs%2FspringInitalizr.png)

## 2. Arquitectura del Proyecto Backend
```
C:.
├───.idea
├───assets
└───src
    ├───main
    │   ├───java
    │   │   └───edu
    │   │       └───eci
    │   │           └───cvds
    │   │               └───ECICredit
    │   │                   ├───config
    │   │                   ├───controller
    │   │                   ├───model
    │   │                   │   └───enums
    │   │                   ├───repository
    │   │                   └───service
    │   │                       └───impl
    │   └───resources
    │       ├───static
    │       └───templates
    └───test
        └───java
            └───edu
                └───eci
                    └───cvds
                        └───ECICredit
                            ├───controller
                            └───service
```

### **Diagrama de Componentes del Backend**
![componentes.jpg](assets%2Fimgs%2Fcomponentes.jpg)

## 3. Conexión con MongoDB
Para establecer la conexión con MongoDB, agregamos las siguientes configuraciones en `application.properties`:

```properties
spring.data.mongodb.uri=mongodb+srv://<usuario>:<password>@cluster0.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
spring.data.mongodb.database=ECICredit
```

