# Conversor de Moneda 💱

Este es un proyecto Java de consola que permite convertir entre monedas latinoamericanas utilizando una API de tipo de cambio en tiempo real. El usuario puede ingresar un monto en una moneda de origen y obtener el valor equivalente en la moneda de destino. Es una aplicación ideal para quienes desean practicar entrada/salida, manejo de excepciones, y consumo de APIs en Java.

## 🚀 Comenzando

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo, pruebas o aprendizaje.

### 📋 Pre-requisitos

* Tener instalado **Java JDK 17** o superior.
* Tener instalado **Gson** para serializar/deserializar JSON.
* Contar con un IDE como IntelliJ IDEA, Eclipse o VS Code con soporte para Java.
* Acceso a Internet para consumir la API de conversión de monedas.

### 🔧 Instalación

1. **Clona el repositorio** en tu máquina local:

```bash
git clone https://github.com/tuusuario/conversor-moneda-java.git
```

2. **Importa el proyecto en tu IDE** favorito.

3. **Agrega la dependencia de GSON** si no usas Maven o Gradle:

Descarga el `.jar` desde: [https://mvnrepository.com/artifact/com.google.code.gson/gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

O, si usas Maven, agrega:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

4. Ejecuta la clase `Principal.java`.


## ⚙️ Ejecutando las pruebas

Este proyecto no incluye pruebas automatizadas. Sin embargo, puedes probarlo manualmente ejecutando el programa y eligiendo diversas opciones y valores de conversión.


## 📦 Despliegue

Este proyecto es una aplicación de consola, por lo tanto, no requiere despliegue en servidor. Puedes compilarlo con:

```bash
javac Principal.java
java Principal
```

## 🛠️ Construido con

* **Java** - Lenguaje de programación principal.
* **GSON** - Biblioteca para trabajar con JSON.
* **API de tipo de cambio (ej. ExchangeRate-API o similar)** - Para obtener tasas de conversión reales.


## 🖇️ Contribuyendo

¡Las contribuciones son bienvenidas! Si deseas colaborar, puedes hacer un fork del proyecto y enviar un pull request con tus mejoras.


## 📖 Wiki

En el futuro se podrá incluir una wiki con más información del funcionamiento interno, documentación de clases y cómo extender el conversor.


## ✒️ Autores

* **\[Jesús Hdez]** - Desarrollo inicial - \[@JHdzH]


## 🎁 Expresiones de Gratitud

* Si te resultó útil, ⭐ dale estrella al repositorio.
* Comparte con tus colegas.
* Invítanos un café ☕ o una cerveza 🍺 (¡virtual!).


⌨️ con ❤️ por \[Jesús Hdez]
Plantilla inspirada en [@Villanuevand](https://gist.github.com/Villanuevand/6386899f70346d4580c723232524d35a)

