SELECT 'CREATE INDEX fk_' || conname || '_idx ON ' 
       || relname || ' ' || 
       regexp_replace(
           regexp_replace(pg_get_constraintdef(pg_constraint.oid, true), 
           ' REFERENCES.*$','',''), 'FOREIGN KEY ','','') || ';'
FROM pg_constraint 
JOIN pg_class 
    ON (conrelid = pg_class.oid)
JOIN pg_namespace
    ON (relnamespace = pg_namespace.oid)
WHERE contype = 'f'
  AND nspname = 'public'
  AND NOT EXISTS (
  SELECT * FROM pg_class pgc
    JOIN pg_namespace pgn ON (pgc.relnamespace = pgn.oid)
  WHERE relkind='i'
    AND pgc.relname = ('fk_' || conname || '_idx') );

