CREATE TABLE assign_task (

                             id SERIAL PRIMARY KEY,

                             equip_id INTEGER,
                             defined_task_id INTEGER,

                             next_execution_date DATE,

                             active INTEGER,

                             status VARCHAR(50),

                             CONSTRAINT fk_assign_equipment
                                 FOREIGN KEY (equip_id)
                                     REFERENCES equipment(id),

                             CONSTRAINT fk_assign_definedtask
                                 FOREIGN KEY (defined_task_id)
                                     REFERENCES defined_task(id)
);