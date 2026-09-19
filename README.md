# Práctica 2: Librería en Línea MVC

Aplicación web desarrollada en Java que simula el catálogo de una librería. El proyecto implementa de manera estricta el patrón de arquitectura **Modelo-Vista-Controlador (MVC)**, permitiendo a los usuarios registrar, visualizar, buscar y filtrar libros mediante una interfaz responsiva y dinámica.

## Autor
* **Marco Antonio Hernández Torres**
* **Institución:** Universidad Nacional Autónoma de México UNAM
* **Asignatura:** Tecnologías para Desarrollos en Internet

## Tecnologías y Herramientas
* **Lenguaje:** Java 26
* **Servidor de Aplicaciones:** Apache Tomcat 9.0.x
* **Entorno de Desarrollo:** Apache NetBeans IDE (Proyecto basado en Ant)
* **Frontend:** HTML5, CSS3 (CSS Grid), JSP (JavaServer Pages)
* **Librerías:** JSTL (JavaServer Pages Standard Tag Library) 1.2

## Arquitectura del Proyecto
El código está organizado siguiendo la separación de responsabilidades del patrón MVC empresarial:
* **Model (`model/Book.java`):** Clase que representa la entidad del dominio con los atributos `id`, `nombre`, `autor` y `precio`. Utiliza identificadores universales (UUID).
* **DAO (`dao/BookDAO.java`):** Objeto de Acceso a Datos que simula el almacenamiento en memoria (mediante colecciones estáticas) y gestiona la lógica de búsqueda. Sus métodos están sincronizados (`synchronized`) para mantener la integridad de los datos ante peticiones concurrentes (Thread-safe).
* **Controller (`controller/BookServlet.java`):** Servlet central que intercepta las peticiones HTTP (`GET` y `POST`), coordina las transacciones de datos con el DAO y despacha las respuestas.
* **View (`WEB-INF/views/libreria.jsp`):** Interfaz protegida contra accesos directos desde el navegador. Sustituye los *scriptlets* tradicionales de Java por etiquetas JSTL (`<c:forEach>`, `<c:choose>`) para garantizar una separación limpia entre la lógica y la presentación.

## Instrucciones de Ejecución

### Opción A: Despliegue desde NetBeans
1. Clonar este repositorio en el entorno local:
   ```bash
   git clone [https://github.com/MarcoHernandez2005/Practica2_Libreria.git](https://github.com/MarcoHernandez2005/Practica2_Libreria.git)
