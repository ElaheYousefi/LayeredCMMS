CREATE TABLE defined_task (
                              id SERIAL PRIMARY KEY,
                              task_name VARCHAR(255),
                              end_date DATE,
                              period_day INTEGER,
                              start_date DATE
);