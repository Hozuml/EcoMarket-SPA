# Ecomarket_SPA
Código e informe de la segunda, tercera y examen final de Desarrollo Fullstack


**_Estructura de proyecto_**

com.ecomarket
  -Usuario
    -controller
    -service
    -model
    -repository
  -Inventario
  -Ventas
  -Logística

===================================================================================

**_Microservicios creados:_**

* Gestion de usuarios
* Inventario
* Ventas y pedidos
* Logística y envíos

  ``[Nombre | Descripción | Funcionalidades | Rutas | Métodos | Status Code]``

  - [Usuarios] | [Gestiona registros y autenticación] | [Crear, obtener, actualizar y
    eliminar usuarios] | [/api/usuarios] | [GET, POST, PUT, DELETE] | [200, 201, 404]

  - [Inventario] | [Maneja productos y stock] | [Alta/Baja producto, stock, búsqueda]
    | [/api/productos] | [GET, POST, PUT, DELETE] | [200, 404]

  - [Ventas] | [Administra órdenes y facturación] | [Crear orden, listar ventas]
    | [/api/ventas] | [GET, POST] | [200, 201]

  - [Logística] | [Gestión de envíos y seguimiento] | [Registrar envío, ver estado]
    | [/api/envios] | [GET, POST] | [200, 201]


===================================================================================

``OPCIONAL``

**_Buenas prácticas_**

* Código modular: cada clase en su archivo
* Nombres significativos: clases en PascalCase, funciones en camelCase
* No repetición de código (DRY)
* Funciones de única responsabilidad
* Rutas REST correctas (/api/usuarios, /api/productos, etc.)
* Uso apropiado de códigos HTTP (200, 201, 400, 404, 500)

===================================================================================

**_Uso de herramientas_**

*_IntelliJ IDEA_
Utilizamos IntelliJ para crear el proyecto Spring Boot y manejar los módulos de 
forma organizada. Nos facilitó la depuración y ejecución de los microservicios.

*_GitHub_
El repositorio fue creado con GitHub Desktop. Usamos ramas para cada microservicio, 
y pull requests para revisar código. El control de versiones permitió trabajo 
colaborativo sin conflictos.

===================================================================================
