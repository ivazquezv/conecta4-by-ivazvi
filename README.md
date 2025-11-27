# Conecta4 by ivazquezv 🎮

Proyecto desarrollado en **Java** con NetBeans que implementa el clásico juego **Conecta 4**.  
El objetivo es ofrecer una arquitectura clara, flexible y escalable, con integración de IA para distintos modos de juego.

---

## 🚀 Características
- Juego de **Conecta 4** totalmente funcional.
- Modos disponibles:
  - Humano vs Humano
  - Humano vs IA
  - IA vs IA
- Arquitectura modular con patrones de diseño (Factory, Strategy, MVC).
- Interfaz sencilla y adaptable.
- Preparado para futuras mejoras y extensiones.

---

## 📂 Estructura del proyecto
Conecta4byivazquezv/
├── .gitignore
├── README.md
├── pom.xml                # Maven
├── build/                 # Archivos compilados (ignorado en Git)
├── dist/                  # Ejecutables .jar (ignorado en Git)
├── nbproject/             # Configuración de NetBeans
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── ivazquezv/
│       │           └── conecta4/
│       │               ├── Main.java
│       │               ├── Player.java
│       │               ├── Board.java
│       │               └── AIPlayer.java
│       └── resources/    # Archivos de configuración o assets
└── target/                # Carpeta generada por Maven (ignorada en Git)



---

## ⚙️ Requisitos
- **Java JDK 17+**
- **NetBeans IDE** (o cualquier IDE compatible con proyectos Maven/Ant)
- Git para control de versiones

---

## ▶️ Ejecución
1. Clona el repositorio:
   ```bash
   git clone https://github.com/ivazquezv/conecta4-by-ivazvi.git

Abre el proyecto en NetBeans o tu IDE favorito.

Compila y ejecuta el archivo principal:
java -jar dist/Conecta4.jar

👨‍💻 Autor
Iván Vázquez Vidador
