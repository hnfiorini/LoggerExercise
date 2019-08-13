# LoggerExercise

## Code Review / Refactoring exercise
Please review the following code snippet. Assume that all referenced assemblies have
been properly included.
The code is used to log different messages throughout an application. We want the ability
to be able to log to a text file, the console and/or the database. Messages can be marked
as message, warning or error. We also want the ability to selectively be able to choose
what gets logged, such as to be able to log only errors or only errors and warnings.
1. If you were to review the following code, what feedback would you give? Please be
specific and indicate any errors that would occur as well as other best practices and
code refactoring that should be done.
2. Rewrite the code based on the feedback you provided in question 1. Please include
unit tests on your code.

### 1.
Lo que facilmente vemos es el no cumplimiento a la idea de que un metodo debe hacer algo determinado, debe ser corto, con un comportamiento determinado, responsable de una tarea definida.
Al tener metodos mas cortos es mas facil reutilizarlos y mantenerlos.

Nombres pocos significativos en variables: Se deben usar nombres de variables mas descriptivos para facilitar el mantenimiento del codigo

La interface del metodo LogMessage es confusa con tantos parametros booleanos y pocos descriptivos

Si bien es una convencion y no algo obligatorio, los nombres de los metodos comienzan con minuscula, salvo los constructores (tienen el mismo nombre que las clases, comienzan con mayuscula)

La variable "initialized" no se usa.

Es recomendable que en la variable dbParams usemos Generics, es decir, pasarle a la clase Map por parametro el tipo de sus elementos contenidos. Asi evitaremos errores en runtime y nos advertira algun error durante la compilacion.

Existen muchos tipos y valores de configuración dentro del código: Es recomendable separar la logica de la configuración.

Falta JavaDoc y comentarios en general.

### 2.
- Se refactorizó el código subdividiendo metodos y clases.

- Se aplicó el patrón Factory y Singleton.

- Se convirtió a proyecto Maven.

- Se agregaron Java Docs.

- Se eliminaron variables que no se usaban y se siguio convenciones con respecto a nombres de metodos y variables.

- Se separó logica de configuración.

