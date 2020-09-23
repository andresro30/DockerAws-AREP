# DockerAws-AREP

Aplicación web que se conecta con una base de datos MongoDB y permite consultar e insertar datos.


## Pre-requisitos
* [Maven](https://maven.apache.org/) : Herramienta encargada de la construcción del proyecto y el manejo de dependencias
* [Git](https://git-scm.com/) : Sistema de control de versiones.
* [JDK](https://www.oracle.com/technetwork/es/java/javase/downloads/index.html) : Herramienta de Desarrollo para Java 
* [Docker](https://www.docker.com/) : Herramienta de gestión de contenedores

Es importante verificar que usted cuente con los siguientes programas 
* Versión de Maven:
```
mvn -version
```
* Versión de Git:
```
git --version
```
* Versión del JDK:
```
java -version
```
* Versión de Docker:
```
docker --version
```

## Instalación
Para instalar el programa debe descargar el repositorio usando el siguiente comando desde su consola CMD
```
git clone https://github.com/andresro30/DockerAws-AREP.git
```
## Ejecución
Para compilar el proyecto debe use el siguiente comando cuando acceda al directorio SparkWebCalculadora
```
mvn package
```

## Visualiación del programa
Página inicial de la aplicación:
![](https://github.com/andresro30/DockerAws-AREP/blob/master/img/cliente.PNG)

Resultado al realizar una consulta a la base de datos
![](https://github.com/andresro30/DockerAws-AREP/blob/master/img/find.PNG)


## Ejecución de pruebas
Para correr las pruebas debe usar el siguiente comando
```
mvn test
```


## Construido con
* [Maven](https://maven.apache.org/) : Herramienta encargada de la construcción del proyecto y el manejo de dependencias
* [Spark](https://spark.apache.org/docs/0.9.1/java-programming-guide.html) : Framwework para desarrollo de aplicaciones web
* [Git](https://git-scm.com/) : Sistema de control de versiones.
* [CircleCI](https://circleci.com/) : Integración contínua [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/andresro30/SparkWebCalculadora-Lab2AREP)
* [AWS](https://aws.amazon.com/es/education/awseducate/) : Despliegue contínuo. 
* [Docker](https://www.docker.com/) : Herramienta de gestión de contenedores
* Java : Lenguaje de Programación.
## Autor
* **Andrés Rocha** - [andresro30](https://github.com/andresro30)

## Licencia 
Este proyecto está licenciado por Apache License 2.0 - mira aquí [LICENSE.md](LICENSE.txt) los detalles
