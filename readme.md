# Segundo Parcial
## 1. Generación de la 
estructura del proyecto con Spring Initializr

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


## 4. Creación de Pruebas Unitarias y Cobertura con JaCoCo

### **Pruebas Unitarias**
![UnitTest.png](assets%2Fimgs%2FUnitTest.png)
### **Cobertura con JaCoCo**
![JaCoCo.png](assets%2Fimgs%2FJaCoCo.png)

---

## 5. Pruebas en Postman

### **Crear un pago**
#### Aprobado
![postman1.png](assets%2Fimgs%2Fpostman1.png)
#### Declinado
![postman3.png](assets%2Fimgs%2Fpostman3.png)

### **Obtener todos los pagos**
![postman2.png](assets%2Fimgs%2Fpostman2.png)

## 6. Creación del CORS para peticiones cruzadas con el frontend

Para permitir peticiones desde el frontend alojado en `http://localhost:5173`, se configura CORS de la siguiente manera:

```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
```


## 7. Despliegue en Azure
1. **Entrar en el portal de Azure**
![Azure1.png](assets%2Fimgs%2FAzure1.png)
2. **Crear un recurso App Service**
![Azure2.png](assets%2Fimgs%2FAzure2.png)
3. **Desplegar la aplicación con Azure DevOps o GitHub Actions**
![Azure3.png](assets%2Fimgs%2FAzure3.png)
![Azure4.png](assets%2Fimgs%2FAzure4.png)
4. **Probar la API desplegada**: Enlace = https://parcialecicredit-cnfxd0b0f3c4aabz.brazilsouth-01.azurewebsites.net

Repositorio del frontend: https://github.com/MimiRandomS/CVDS_SegundoParcialFront

---


