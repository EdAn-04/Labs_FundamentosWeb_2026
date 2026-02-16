# 📱 Lab 04 — Pagination, Stats & Local Search (Amiibo Vault)

## 👨‍💻 Autor
**Edgar Andrés Culajay Hernández**

---

## 📚 Descripción del Laboratorio

En este laboratorio se implementaron mejoras avanzadas en la aplicación **Amiibo Vault**, enfocadas en mejorar la experiencia del usuario mediante:

- Modo offline con manejo de errores
- Paginación infinita
- Búsqueda local reactiva
- Arquitectura basada en Flow y Room
- Manejo robusto de estados UI

---

## 🧩 Parte 1 — Graceful Offline Mode

### 🎯 Objetivo
Permitir que la aplicación continúe mostrando datos almacenados localmente cuando ocurre un error de red o servidor.

---

### ✅ Funcionalidades Implementadas

- Manejo de errores tipados
- Persistencia de datos cacheados
- Visualización de mensajes de error sin bloquear la UI
- Reintentos manuales
- Snackbar informativo
- Pull to refresh
- Paginación con control de errores

---

### 🛠 Implementación Técnica

Se extendió el estado UI para permitir mostrar datos cacheados:

```kotlin
data class Error(
    val message: String,
    val cachedAmiibos: List<AmiiboEntity>
)
