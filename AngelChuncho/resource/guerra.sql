/**
*   Examen II
*   Angel David Chuncho Jiménez
*   Base de datos
*   version 1.0
*/

-- revisar el entorno de trabajo
.version
.database
.show

.tables

DROP TABLE IF EXISTS AC_USUARIO;

CREATE TABLE IF NOT EXISTS AC_USUARIO
(
    PK_ACID_USUARIO       INTEGER UNIQUE NOT NULL AUTO_INCREMENT
    ,ACCORREO             VARCHAR(50) UNIQUE NOT NULL
    ,ACCONTRASENA         VARCHAR(25) NOT NULL
    PRIMARY KEY (PK_ACID_USUARIO)
);

SELECT * FROM AC_USUARIO;

INSERT INTO AC_USUARIO(ACCORREO, ACCONTRASENA) 
       VALUES ('angel.chuncho@epn.edu.ec', 'uuebo+3cTFaqh4MBsm+Rzw==')
            , ('pepe.guzman@epn.edu.ec', 'lbdHY7hJBV2wkPhJZVEViQ==')
            , ('profe', 'u+5nZmALIsMJKyv0zqK2RQ==');

