Trabajo Integrador Pedro Rocha:

Para levantar el proyecto es necesario importar el archivo digital-media.json en keycloak 18.0.0 ubicado en la carpeta keycloak_config y correr todos los microservicios en un entorno local.

No logre levantar todo con docker debido a un error en los .jars, la idea era utilizar el script ./make.sh y levantar todo el proyecto con un script.
El problema esta en que el archivo Dockerfile no logra encontrar la ubicacion de los jars de cada proyecto.

El API gateway tiene un error en la configuracion que no logre identificar, por lo que para acceder a los enpoints es necesario usar los puertos nativos de los microservicios.

Los demas requerimientos estan completados.

Muchas gracias.