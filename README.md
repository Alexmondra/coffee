# ☕ Sistema de Gestión Comercial de Café

Sistema web para la administración de negocios dedicados a la compra, venta y comercialización de café en sus diferentes presentaciones.

Diseñado especialmente para emprendedores, pequeños comerciantes, tiendas de café, acopiadores y negocios que necesitan controlar sus operaciones comerciales de manera sencilla y eficiente.

## 1. Descripción del proyecto

El sistema tiene como objetivo facilitar la gestión diaria de un negocio comercializador de café, permitiendo registrar compras, ventas, inventario, precios, clientes, proveedores y movimientos de dinero.

El negocio podrá comercializar diferentes tipos de café, cada uno con precios independientes.

### Tipos de café

- Café en pergamino.
- Café en coco.
- Café seco.
- Café pilado.
- Café verde.
- Otros tipos configurables.

Los nombres comerciales podrán personalizarse según la región o las necesidades del negocio.

Cada producto tendrá su propio precio de compra, precio de venta, unidad de medida y existencias.

## 2. Objetivo principal

Desarrollar una plataforma que permita al comerciante conocer en tiempo real:

- Cuánto café tiene disponible.
- Cuánto café ha comprado.
- Cuánto café ha vendido.
- Cuánto dinero ha invertido.
- Cuánto dinero ha cobrado.
- Cuánto le deben sus clientes.
- Cuánto debe a sus proveedores.
- Cuánto está ganando con sus operaciones.

El sistema debe ser intuitivo, rápido y accesible desde computadoras, tablets y teléfonos móviles.

---

## 3. Módulos del sistema

### 📊 3.1. Dashboard

Panel principal con información resumida del negocio.

**Indicadores:**

- Ventas del día.
- Compras del día.
- Ingresos registrados.
- Gastos registrados.
- Ganancia bruta estimada.
- Stock disponible.
- Cuentas por cobrar.
- Cuentas por pagar.

Incluir gráficos de ventas y compras por períodos.

### ☕ 3.2. Gestión de productos

Permite administrar los diferentes tipos de café comercializados.

**Información del producto:**

- Código.
- Nombre.
- Tipo de café.
- Descripción.
- Unidad de medida.
- Precio de compra referencial.
- Precio de venta referencial.
- Stock disponible.
- Estado activo o inactivo.

**Características:**

- Precios independientes por producto.
- Actualización de precios.
- Venta por kilogramo o quintal.
- Conversión de unidades configurable.
- Consulta de existencias.

Los precios podrán modificarse durante las operaciones sin alterar los registros históricos.

### 🛒 3.3. Gestión de compras

Permite registrar el café adquirido a productores o proveedores.

**Información de compra:**

- Número de compra.
- Fecha.
- Proveedor.
- Tipo de café.
- Cantidad.
- Unidad de medida.
- Precio por unidad.
- Importe total.
- Monto pagado.
- Saldo pendiente.
- Observaciones.

**Funcionalidades:**

- Compras al contado.
- Compras al crédito.
- Registro de pagos parciales.
- Historial de compras.
- Consulta de compras por proveedor.
- Actualización automática del inventario.

**Ejemplo:**

| Concepto | Valor |
|---|---|
| Producto | Café pergamino |
| Cantidad | 500 kg |
| Precio de compra | S/ 12.00 |
| Total | S/ 6,000.00 |
| Pago realizado | S/ 4,000.00 |
| Saldo pendiente | S/ 2,000.00 |

El sistema registrará el ingreso de 500 kg al inventario y una deuda de S/ 2,000 al proveedor.

### 💰 3.4. Gestión de ventas

Permite registrar todas las ventas realizadas por el negocio.

**Información de venta:**

- Número de venta.
- Fecha.
- Cliente.
- Producto.
- Cantidad.
- Precio de venta.
- Subtotal.
- Descuento.
- Total.
- Método de pago.
- Estado de pago.

**Funcionalidades:**

- Ventas al contado.
- Ventas al crédito.
- Precios personalizados por operación.
- Venta de varios productos.
- Registro de pagos parciales.
- Historial de ventas.
- Comprobante interno imprimible.
- Descuento automático del inventario.

**Ejemplo:**

| Concepto | Valor |
|---|---|
| Producto | Café pilado |
| Cantidad | 100 kg |
| Precio de venta | S/ 18.00 |
| Total | S/ 1,800.00 |

El sistema descontará automáticamente 100 kg del inventario correspondiente.

### 📦 3.5. Control de inventario

Módulo encargado de controlar las existencias de café.

**Funcionalidades:**

- Stock por tipo de café.
- Entradas por compras.
- Salidas por ventas.
- Ajustes de inventario.
- Historial de movimientos.
- Alertas de stock bajo.
- Valorización del inventario.

**Ejemplo:**

| Producto | Entradas | Salidas | Stock |
|---|---:|---:|---:|
| Café pergamino | 1,000 kg | 350 kg | 650 kg |
| Café coco | 500 kg | 200 kg | 300 kg |
| Café seco | 800 kg | 400 kg | 400 kg |
| Café pilado | 600 kg | 250 kg | 350 kg |

El sistema debe impedir ventas superiores al stock disponible, salvo que exista una configuración explícita que permita inventario negativo.

### 👥 3.6. Gestión de clientes

Permite administrar la información de los compradores.

**Datos:**

- Nombres o razón social.
- DNI o RUC.
- Teléfono.
- Dirección.
- Observaciones.
- Estado.

**Funcionalidades:**

- Historial de compras.
- Total vendido por cliente.
- Deudas pendientes.
- Registro de abonos.
- Estado de cuenta.

### 🚚 3.7. Gestión de proveedores

Permite administrar productores, agricultores y proveedores comerciales.

**Datos:**

- Nombre o razón social.
- DNI o RUC.
- Teléfono.
- Dirección.
- Observaciones.

**Funcionalidades:**

- Historial de compras.
- Productos suministrados.
- Deudas pendientes.
- Registro de pagos.
- Estado de cuenta.

### 💳 3.8. Caja y movimientos de dinero

Permite controlar el dinero que ingresa y sale del negocio.

**Ingresos:**

- Cobros de ventas.
- Abonos de clientes.
- Otros ingresos.

**Egresos:**

- Pagos de compras.
- Pagos a proveedores.
- Gastos operativos.
- Otros egresos.

**Funcionalidades:**

- Apertura de caja.
- Cierre de caja.
- Registro de movimientos.
- Control por método de pago.
- Saldo disponible.
- Historial de caja.

Métodos de pago configurables:

- Efectivo.
- Yape.
- Plin.
- Transferencia bancaria.
- Otros.

Los movimientos de caja deben registrarse sin duplicar los pagos asociados a compras y ventas.

### 📈 3.9. Reportes

Permite consultar el rendimiento comercial del negocio.

**Reportes principales:**

- Ventas por día, semana y mes.
- Compras por período.
- Ventas por producto.
- Compras por proveedor.
- Productos más vendidos.
- Inventario actual.
- Ganancia bruta estimada.
- Cuentas por cobrar.
- Cuentas por pagar.
- Movimientos de caja.

Los reportes podrán filtrarse por fechas y exportarse a Excel o PDF.

### ⚙️ 3.10. Configuración

Administración general del sistema.

**Opciones:**

- Datos del negocio.
- Nombre comercial.
- RUC.
- Dirección.
- Teléfono.
- Moneda principal.
- Unidades de medida.
- Tipos de café.
- Métodos de pago.
- Usuarios y permisos.

---

## 4. Gestión de precios

Una característica fundamental será la flexibilidad de precios.

Los precios del café pueden cambiar constantemente según el mercado, la calidad y las condiciones de negociación.

Por ello, el sistema permitirá:

1. Definir precios referenciales de compra.
2. Definir precios referenciales de venta.
3. Modificar precios durante una operación.
4. Registrar el precio realmente negociado.
5. Mantener el precio histórico de cada compra y venta.
6. Consultar márgenes de ganancia.

### Ejemplo

| Producto | Precio compra/kg | Precio venta/kg |
|---|---:|---:|
| Café pergamino | S/ 12.00 | S/ 14.50 |
| Café coco | S/ 9.00 | S/ 11.00 |
| Café seco | S/ 13.00 | S/ 15.00 |
| Café pilado | S/ 16.00 | S/ 19.00 |

*Los precios son únicamente ilustrativos.*

El sistema no debe asumir que todos los productos tienen el mismo margen comercial.

---

## 5. Reglas de negocio

El sistema deberá cumplir las siguientes reglas:

1. Cada tipo de café tendrá inventario independiente.
2. Las compras confirmadas incrementarán el stock.
3. Las ventas confirmadas disminuirán el stock.
4. Los precios históricos no cambiarán al actualizar los precios referenciales.
5. Una venta podrá contener varios productos.
6. Una compra podrá contener varios productos.
7. Los pagos parciales actualizarán los saldos pendientes.
8. Las operaciones anuladas deberán revertir sus efectos correspondientes.
9. Los movimientos de inventario deberán conservar trazabilidad.
10. No se eliminarán físicamente operaciones comerciales confirmadas.
11. Las cantidades y los importes utilizarán tipos numéricos decimales.
12. Las operaciones de inventario y dinero deberán ejecutarse mediante transacciones para evitar inconsistencias.
13. Las ganancias deberán calcularse considerando el costo real de la mercancía vendida y no únicamente el precio referencial.
14. Los ajustes de inventario deberán registrar el motivo y el usuario responsable.

---

## 6. Usuarios y permisos

Inicialmente se contemplan dos roles.

### Administrador

Acceso completo al sistema.

Puede administrar productos, compras, ventas, inventario, clientes, proveedores, caja, reportes y configuración.

### Vendedor

Acceso limitado a las operaciones comerciales autorizadas.

Puede registrar ventas, consultar productos, verificar existencias y consultar sus operaciones.

Los permisos deberán poder ampliarse posteriormente.

---

## 7. Arquitectura del sistema

Se propone una arquitectura web moderna, modular y escalable.

### Frontend

Interfaz responsive orientada a la facilidad de uso.

Tecnologías sugeridas:

- React.
- TypeScript.
- Tailwind CSS.

### Backend

API encargada de la lógica de negocio, validaciones, autenticación y operaciones comerciales.

Tecnologías sugeridas:

- Node.js.
- TypeScript.
- NestJS.

### Base de datos

PostgreSQL.

La base de datos deberá garantizar la integridad de las compras, ventas, pagos y movimientos de inventario.

### Arquitectura

Se utilizará inicialmente un monolito modular.

Esta arquitectura permitirá mantener separados los módulos funcionales sin introducir la complejidad innecesaria de microservicios.

---

## 8. Estructura funcional

```text
Sistema Comercial de Café
│
├── Dashboard
│
├── Productos
│   ├── Tipos de café
│   ├── Precios
│   └── Unidades de medida
│
├── Compras
│   ├── Nueva compra
│   ├── Historial
│   └── Pagos
│
├── Ventas
│   ├── Nueva venta
│   ├── Historial
│   └── Cobros
│
├── Inventario
│   ├── Existencias
│   ├── Movimientos
│   └── Ajustes
│
├── Clientes
│
├── Proveedores
│
├── Caja
│   ├── Ingresos
│   ├── Egresos
│   └── Cierres
│
├── Reportes
│
└── Configuración
    ├── Negocio
    ├── Usuarios
    └── Permisos
```

---

## 9. Alcance de la primera versión (MVP)

La primera versión estará enfocada en resolver las necesidades esenciales del comerciante.

### Funcionalidades prioritarias

- Autenticación.
- Dashboard básico.
- Registro de productos.
- Precios de compra y venta.
- Gestión de clientes.
- Gestión de proveedores.
- Registro de compras.
- Registro de ventas.
- Control automático de inventario.
- Pagos y cobros.
- Control básico de caja.
- Reportes esenciales.

### Funcionalidades futuras

- Facturación electrónica SUNAT.
- Múltiples sucursales.
- Gestión avanzada de lotes.
- Control de humedad y calidad.
- Gestión de transformación de café.
- Aplicación móvil.
- Notificaciones automáticas.
- Reportes avanzados de rentabilidad.

Estas funcionalidades no formarán parte de la primera versión, salvo que sean necesarias para el funcionamiento comercial básico.

---

## 10. Principios de desarrollo

El proyecto deberá seguir estos principios:

**Simplicidad:** priorizar una experiencia sencilla para comerciantes sin conocimientos técnicos.

**Escalabilidad:** permitir futuras funcionalidades sin reconstruir todo el sistema.

**Integridad:** mantener consistencia entre compras, ventas, inventario y pagos.

**Seguridad:** implementar autenticación, autorización y validación de operaciones.

**Mantenibilidad:** utilizar código organizado, reutilizable y documentado.

**Rendimiento:** optimizar consultas y operaciones frecuentes.

**Trazabilidad:** conservar un historial confiable de las operaciones comerciales.

---

## 11. Resultado esperado

Al finalizar el desarrollo, el comerciante contará con una herramienta que le permitirá administrar su negocio desde una sola plataforma.

Podrá registrar cuánto café compra, a qué precio lo adquiere, cuánto vende, cuánto tiene almacenado y cuánto dinero gana.

El sistema estará orientado principalmente a pequeños y medianos negocios que necesitan reemplazar sus cuadernos, cálculos manuales y hojas de Excel por una solución digital práctica.

**Objetivo final: convertir la administración diaria de un negocio de café en un proceso sencillo, ordenado y confiable.**
