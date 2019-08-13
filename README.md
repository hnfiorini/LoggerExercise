# LoggerExercise
Code Review / Refactoring exercise

Lo que facilmente vemos es el no cumplimiento a la idea de que un metodo debe hacer algo determinado, debe ser corto, con un comportamiento determinado, responsable de una tarea definida.
Al tener metodos mas cortos es mas facil reutilizarlos y mantenerlos.

Nombres pocos significativos en variables: Se deben usar nombres de variables mas descriptivos para facilitar el mantenimiento del codigo

La interface del metodo LogMessage es confusa con tantos parametros booleanos y pocos descriptivos

Si bien es una convencion y no algo obligatorio, los nombres de los metodos comienzan con minuscula, salvo los constructores (tienen el mismo nombre que las clases, comienzan con mayuscula)

La variable "initialized" no se usa.

Es recomendable que en la variable dbParams usemos Generics, es decir, pasarle a la clase Map por parametro el tipo de sus elementos contenidos. Asi evitaremos errores en runtime y nos advertira algun error durante la compilacion.

Existen muchos tipos y valores de configuración dentro del código: Es recomendable separar la logica de la configuración.

Falta JavaDoc y comentarios en general.
