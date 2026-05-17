CREATE TABLE workorder (

                           id SERIAL PRIMARY KEY,

                           assigntask_id INTEGER,
                           employee_id INTEGER,

                           due_date DATE,
                           observ_result VARCHAR(1000),

                           work_order_status VARCHAR(50),
                           equip_status VARCHAR(50),

                           done_date DATE,

                           CONSTRAINT fk_workorder_assigntask
                               FOREIGN KEY (assigntask_id)
                                   REFERENCES assign_task(id),

                           CONSTRAINT fk_workorder_employee
                               FOREIGN KEY (employee_id)
                                   REFERENCES employee(id)
);