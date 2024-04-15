DELETE FROM `bd-hibernate-una-entidad`.cliente  c WHERE c .idCliente > 4;

/* reset counter of autoincremento to last inserted */ 
ALTER TABLE `bd-hibernate-una-entidad`.cliente AUTO_INCREMENT = 0;

/* Deleted and again create AUTO-INCREMENT field
 
ALTER TABLE `bd-hibernate-una-entidad`.cliente DROP idCliente;
ALTER TABLE `bd-hibernate-una-entidad`.cliente 
ADD idCliente INT UNSIGNED NOT NULL AUTO_INCREMENT FIRST,
ADD PRIMARY KEY (idCliente);

*/

 # Line comment with "#" SELECT * FROM `bd-hibernate-una-entidad`.cliente WHERE idCliente = LAST_INSERT_ID();

-- line comment with "-- " return last record inserted in table
/* Multiline comment with "/*" 
 * This is a Multiline comment
*/

/* return last record inserted in table */
SELECT * from `bd-hibernate-una-entidad`.cliente ORDER BY idCliente DESC LIMIT 1;

