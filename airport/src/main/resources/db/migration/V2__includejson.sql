/* Modify flight table and insert json data, the id of each employee of the crew */
 
ALTER TABLE vuelo 
ADD id_tripulantes JSON NOT NULL;

UPDATE vuelo v
SET v.id_tripulantes = (
    SELECT JSON_ARRAYAGG(
    	JSON_OBJECT('cod_empleado', vt.tripulante_id))
    FROM vuelo_tripulante vt
    WHERE vt.vuelo_id = v.id);
   
ALTER TABLE avion
ADD revisiones_json JSON NOT NULL;
 
UPDATE avion a
SET revisiones_json = (
    SELECT JSON_ARRAYAGG(
    	JSON_OBJECT(
        	'id',r.id,
            'avion',r.avion_id,
            'fecha_inicio',r.fecha_inicio,
            'fecha_fin',r.fecha_fin,
            'horas',r.horas,
            'mecanico',r.mecanico_id,
            'tipo',r.tipo,
            'descripcion',r.descripcion,
            'aeropuerto',r.aeropuerto_id))
    FROM revision r
    WHERE r.avion_id = a.id);