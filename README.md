# **STOCK MANAGER ADA**

## Class Usuario

nombreUsuario: String -> PrimaryKey  
password: String -> Not Null | Longitud 20

## Class Login

Literalmente un login con nombre y contraseña

## Class AppStockControl

* Alta Producto
* Baja Producto
* Modificar Nombre Producto
* Modificar Stock Producto
* Obtener 1 Producto
* Obtener Productos con Stock
* Obtener Productos sin Stock
* Get Proveedor de 1 Producto
* Get todos los Proveedores

## Class Producto

* id: String -> PrimaryKey  
* categoria: String  
* nombre: String  
* descripcion: String  
* precioSinIva: Float  
* precioConIva: Float  
* fechaAlta: Date  
* stock: Int  
* proveedor: Proveedor  

## Class Proveedor

* id: Long -> PrimaryKey
* nombre: String
* direccion: String
* productos: List< Producto >

**Nota**  
id -> categoria + nombre + proveedor (3 primeras letras)  
precioConIva -> 21%  
fechaAlta -> Hoy

## Directorio Service

Maneja la lógica de negocio de la aplicación, actuando como un puente entre la capa de repositorio y la capa de interfaz de usuario (o consola en este caso)

## Directorio utils

