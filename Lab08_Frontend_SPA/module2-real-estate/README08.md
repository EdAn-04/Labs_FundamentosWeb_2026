# Lab 08 – Frontend SPA (Property Comparison)

**Curso:** Fundamentos de Aplicaciones Web
**Universidad:** Universidad Galileo
**Estudiante:** Edgar Andrés Culajay Hernández
**Repositorio:** Labs_FundamentosWeb_2026

---

## Descripción

En este laboratorio se implementó una funcionalidad de **comparación de propiedades inmobiliarias** dentro de una aplicación **Single Page Application (SPA)** desarrollada con **React**.

La característica principal permite que el usuario seleccione propiedades desde la lista principal y luego visualice una tabla comparativa con información relevante para facilitar la toma de decisiones.

El objetivo del laboratorio fue aplicar conceptos de **manejo de estado en el frontend**, **persistencia en el navegador** y **navegación dentro de una SPA utilizando React Router**.

---

## Funcionalidades implementadas

Las siguientes funcionalidades corresponden a la **Parte 1 del laboratorio**:

* Selección de propiedades desde la lista principal.
* Botón de comparación en cada tarjeta de propiedad.
* Límite máximo de **3 propiedades para comparar**.
* Persistencia de las propiedades seleccionadas usando **localStorage**.
* Página dedicada para la comparación de propiedades.
* Tabla comparativa con las siguientes métricas:

  * Precio
  * Habitaciones
  * Baños
  * Área
* Resaltado automático de:

  * Propiedad con **menor precio**
  * Propiedad con **mayor área**
* Opción para **remover propiedades de la comparación**.
* Mensaje informativo cuando no hay propiedades seleccionadas.

---

## Tecnologías utilizadas

* **React 19**
* **TypeScript**
* **React Router**
* **Tailwind CSS**
* **Shadcn UI**
* **Lucide React Icons**
* **LocalStorage API**

---

## Estructura de archivos implementados

Los archivos principales agregados o modificados para este laboratorio fueron:

```
src/
 ├─ components/
 │   ├─ PropertyCard.tsx
 │   └─ CompareButton.tsx
 │
 ├─ pages/
 │   └─ ComparePage.tsx
 │
 ├─ lib/
 │   └─ compare.ts
 │
 └─ App.tsx
```

---

## Funcionamiento

1. El usuario navega por la lista de propiedades.
2. Cada propiedad tiene un botón para **agregar o quitar de la comparación**.
3. Las propiedades seleccionadas se almacenan en **localStorage**.
4. Al navegar a la ruta `/compare`, el sistema muestra una **tabla comparativa**.
5. El usuario puede eliminar propiedades de la comparación directamente desde la tabla.

---

## Cómo ejecutar el proyecto

Clonar el repositorio:

```bash
git clone https://github.com/EdAn-04/Labs_FundamentosWeb_2026.git
```

Entrar al laboratorio:

```bash
cd Lab08_Frontend_SPA
```

Instalar dependencias:

```bash
npm install
```

Ejecutar la aplicación:

```bash
npm run dev
```

Abrir en el navegador:

```
http://localhost:5173
```

---

## Ruta de comparación

La vista de comparación está disponible en:

```
/compare
```

En esta página se muestran las propiedades seleccionadas y sus métricas comparativas.

---

## Conclusión

Este laboratorio permitió reforzar el uso de **React para la construcción de aplicaciones SPA**, así como el manejo de **estado del lado del cliente** y la **persistencia de datos en el navegador**.

Además, se implementó una funcionalidad común en aplicaciones inmobiliarias reales: la **comparación de propiedades**, la cual ayuda a los usuarios a evaluar diferentes opciones antes de tomar una decisión.

---
