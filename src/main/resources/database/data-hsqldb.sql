INSERT INTO ERROR_INFO (ID, CODE, TITLE, DESCRIPTION) VALUES
(1, '10000', 'Error Interno del Servidor', 'Algo inesperado ha fallado.'),
(2, '10001', 'Formato JSON no Parseable', 'El contenido de la solicitud está mal formado.'),
(3, '10002', 'Recurso no Encontrado', 'El recurso al que está intentando acceder no existe.'),
(4, '10003', 'Clave Duplicada', 'El valor de la clave está siendo usada por otro recurso.'),
(5, '10004', 'Error de Validación', 'Algún dato no cumple con las restricciones de validación.'),
(6, '10005', 'Argumento Ilegal', 'Se ha informado de algún elemento no válido para realizar la operación.'),
(7, '10006', 'Error de Integridad Referencial', 'El recurso es referenciado por otros recursos.'),
(8, '10007', 'Método no Soportado', 'La operación no es soportada por la aplicación.');

INSERT INTO ERROR_CAUSE (ID, CAUSE, ERROR_INFO) VALUES
(1, 'Circunstancia no contemplada.', 1),
(2, 'JSON mal formado.', 2),
(3, 'El identificador del recurso es erróneo.', 3),
(4, 'El recurso pudo existir pero se eliminó.', 3),
(5, 'Ya existe otro recurso usando la clave única.', 4),
(6, 'Una o más restricciones de validación ha sido violada.', 5),
(7, 'Uno o más de los argumentos usados para realizar la operación no está permitido.', 6),
(8, 'Está intentando eliminar un registro que es referenciado por otros recursos.', 7),
(9, 'La operación que intenta realizar no está implementada.', 8);

INSERT INTO ERROR_SOLUTION (ID, SOLUTION, ERROR_INFO) VALUES
(1, 'Contacte con el administrador.', 1),
(2, 'Revise la sintaxsis. En el error específico debe aparecer indicaciones de cómo corregirlo.', 2),
(3, 'Compruebe el identificador del recurso.', 2),
(4, 'Revise el histórico de eliminaciones.', 3),
(5, 'Compruebe que la clave no esta siendo usada por otro recurso.', 4),
(6, 'Revise las restricciones para cada tipo de recurso.', 5),
(7, 'Compruebe los argumentos necesarios. En determinadas operaciones se requiere un identificador.', 6),
(8, 'Debe eliminar antes los registros que referencian al recurso.', 7),
(9, 'Revise la documentación del api para comprobar si la operación está soportada.', 8);

INSERT INTO CATEGORY (ID, NAME, CREATED, LAST_UPDATE) VALUES
(1, 'BIOQUÍMICA', NOW(), NOW()),
(2, 'HEMATOLOGÍA', NOW(), NOW()),
(3, 'INMUNOLOGÍA', NOW(), NOW()),
(4, 'COAGULACIÓN', NOW(), NOW()),
(5, 'PRUEBAS GENÉTICAS', NOW(), NOW()),
(6, 'HORMONAS', NOW(), NOW()),
(7, 'INTOLERANCIA Y ALERGIA', NOW(), NOW()),
(8, 'ORINA', NOW(), NOW()),
(9, 'SEMEN', NOW(), NOW()),
(10, 'HECES', NOW(), NOW()),
(11, 'EXUDADOS', NOW(), NOW()),
(12, 'CÁLCULOS RENALES', NOW(), NOW());

INSERT INTO SUBCATEGORY (ID, NAME, CREATED, LAST_UPDATE, CATEGORY) VALUES
(1, 'PRUEBAS HEPÁTICAS', NOW(), NOW(), 1),
(2, 'PRUEBAS RENALES', NOW(), NOW(), 1),
(3, 'CONTROL LIPÍDICO', NOW(), NOW(), 1),
(4, 'IONES', NOW(), NOW(), 1),
(5, 'CONTROL DIABETES', NOW(), NOW(), 1),
(6, 'VITAMINAS', NOW(), NOW(), 1),
(7, 'ESTUDIO FÉRRICO', NOW(), NOW(), 1),
(8, 'PRUEBAS REUMÁTICAS', NOW(), NOW(), 1),
(9,  'HEMOGRAMA', NOW(), NOW(), 2),
(10, 'VELOCIDAD DE SEDIMENTACIÓN', NOW(), NOW(), 2),
(11, 'ESTUDIO DE ANEMIAS', NOW(), NOW(), 2),
(12, 'GRUPO SANGUÍNEO Y FACTOR RH', NOW(), NOW(), 2),
(13, 'ENFERMEDADES AUTOINMUNES', NOW(), NOW(), 3),
(14, 'SEROLOGÍA', NOW(), NOW(), 3),
(15, 'PREOPERATORIO', NOW(), NOW(), 4),
(16, 'CONTROL DE SINTROM', NOW(), NOW(), 4),
(17, 'PRUEBAS DE PATERNIDAD', NOW(), NOW(), 5),
(18, 'TEST COMBINADO EN EMBARAZADAS', NOW(), NOW(), 5),
(19, 'CARIOTIPOS', NOW(), NOW(), 5),
(20, 'DETECCIÓN DE ATAXIAS', NOW(), NOW(), 5),
(21, 'TIROIDEAS', NOW(), NOW(), 6),
(22, 'OVÁRICAS', NOW(), NOW(), 6),
(23, 'MARCADORES TUMORALES', NOW(), NOW(), 6),
(24, 'ALIMENTOS', NOW(), NOW(), 7),
(25, 'MEDICAMENTOS', NOW(), NOW(), 7),
(26, 'ESPECIES VEGETALES Y ANIMALES', NOW(), NOW(), 7),
(27, 'GLUTEN', NOW(), NOW(), 7),
(28, 'LACTOSA', NOW(), NOW(), 7),
(29, 'ESTUDIO MICROBIOLÓGICO (SISTEMÁTICO, UROCULTIVO Y ANTIBIOGRAMA)', NOW(), NOW(), 8),
(30, 'TOXICOLOGÍA', NOW(), NOW(), 8),
(31, 'DIAGNÓSTICO DE EMBARAZO', NOW(), NOW(), 8),
(32, 'ESTUDIO DE FERTILIDAD (SEMINOGRAMA)', NOW(), NOW(), 9),
(33, 'CONTROL POSTVASECTOMÍA', NOW(), NOW(), 9),
(34, 'ESTUDIO MICROBIOLÓGICO', NOW(), NOW(), 9),
(35, 'PARÁSITOS', NOW(), NOW(), 10),
(36, 'SANGRE OCULTA', NOW(), NOW(), 10),
(37, 'DIGESTIÓN DE PRINCIPIOS INMEDIATOS', NOW(), NOW(), 10),
(38, 'COPROCULTIVO Y ANTIBIOGRAMA', NOW(), NOW(), 10),
(39, 'DETECCION DE HELICOBACTER PYLORI', NOW(), NOW(), 10),
(40, 'ESTUDIO MICROBIOLÓGICO', NOW(), NOW(), 11),
(41, 'CITOLOGÍAS', NOW(), NOW(), 11),
(42, 'ANATOMÍA PATOLÓGICA', NOW(), NOW(), 11),
(43, 'ESTUDIO DE COMPOSICIÓN', NOW(), NOW(), 12);