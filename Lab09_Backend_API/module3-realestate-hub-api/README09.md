# 🏠 RealEstate Hub API – Module 3 (Challenge Lab - Part 1)

## 📌 Descripción

Este proyecto implementa una API REST para la gestión de propiedades inmobiliarias utilizando **Node.js, Express y Prisma ORM**.

En este laboratorio se desarrolló la **Parte 1 del Challenge Lab**, que consiste en agregar **paginación y metadata** al endpoint:

```
GET /api/properties
```

---

## 🎯 Objetivo

Optimizar la respuesta del endpoint para manejar grandes volúmenes de datos mediante:

* Paginación (`page`, `limit`)
* Metadata de respuesta
* Validación de parámetros
* Integración con filtros existentes

---

## 🚀 Endpoint implementado

### 🔹 Obtener propiedades con paginación

```
GET /api/properties?page=1&limit=10
```

### 📥 Query Params

| Parámetro | Tipo   | Descripción                                    |
| --------- | ------ | ---------------------------------------------- |
| page      | number | Número de página (default: 1)                  |
| limit     | number | Cantidad de registros por página (default: 10) |

---

## 📤 Formato de respuesta

```json
{
  "success": true,
  "data": [...],
  "meta": {
    "total": 50,
    "page": 1,
    "limit": 10,
    "pages": 5
  }
}
```

---

## 🧠 Lógica implementada

* `skip = (page - 1) * limit`
* `total` se obtiene con `count()`
* `pages = Math.ceil(total / limit)`
* Uso de `Promise.all` para optimizar consultas
* Si la página está fuera de rango → retorna `data: []`

---

## ⚙️ Cambios realizados

### 📁 Controller (`propertyController.ts`)

* Se agregaron parámetros `page` y `limit`
* Validación de entrada
* Inclusión de metadata en la respuesta
* Uso de paginación con el repositorio

---

### 📁 Repository (`propertyRepository.ts`)

#### 🔹 Método actualizado:

```ts
findAll(filters, { skip, take })
```

#### 🔹 Nuevo método:

```ts
count(filters)
```

Ambos reutilizan la función `buildWhereClause` para mantener consistencia en los filtros.

---

## ✅ Validaciones

* `page` y `limit` deben ser números positivos
* Valores inválidos retornan error `400`
* Valores por defecto:

  * `page = 1`
  * `limit = 10`

---

## 🧪 Ejemplo de uso

```
GET /api/properties?page=2&limit=5
```

Respuesta:

```json
{
  "success": true,
  "data": [...5 propiedades...],
  "meta": {
    "total": 23,
    "page": 2,
    "limit": 5,
    "pages": 5
  }
}
```

---

## 🏗️ Arquitectura utilizada

Se implementó el patrón:

* **Controller** → Maneja HTTP (req/res)
* **Repository** → Acceso a base de datos (Prisma)

Esto permite:

* Separación de responsabilidades
* Código mantenible
* Fácil testing

---

## 🛠️ Tecnologías

* Node.js
* Express
* Prisma ORM
* SQLite
* TypeScript

---

## 📌 Notas

* No se implementó la Parte 2 (Statistics)
* El enfoque fue mantener una arquitectura limpia y escalable
* La paginación es compatible con filtros existentes

---

## 👨‍💻 Autor

Edgar Andrés Culajay Hernández - 23000109

---

## ✅ Estado

✔ Parte 1 completada

---
