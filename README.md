# Laboratorio 02 – Traffic Light Simulator 🚦

## Descripción
Este laboratorio consiste en la creación de un **simulador de semáforo** utilizando **Android Studio con Jetpack Compose**, con el objetivo de practicar el manejo de **estado** y el uso de **LaunchedEffect** para ejecutar lógica automática.

La aplicación simula un semáforo real, cambiando de color de forma continua sin interacción del usuario.

---

## Objetivos
- Practicar el manejo de estado en Jetpack Compose
- Utilizar `LaunchedEffect` para ejecutar procesos automáticos
- Comprender el ciclo de vida de una app en Android
- Implementar una interfaz simple y clara

---

## Funcionalidad
La aplicación muestra tres luces (círculos) colocadas verticalmente:

- **Rojo** – activo durante 2 segundos  
- **Verde** – activo durante 2 segundos  
- **Amarillo** – activo durante 1 segundo  

La luz activa se muestra con su color correspondiente y las luces inactivas se muestran en color gris.  
El ciclo se repite de forma infinita automáticamente.

---

## Tecnologías utilizadas
- Kotlin
- Android Studio
- Jetpack Compose
- State Management (`mutableStateOf`)
- `LaunchedEffect`
- Coroutines (`delay`)

---

## Estructura del proyecto
