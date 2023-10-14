CREATE TABLE IF NOT EXISTS tb_tasks (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description TEXT,
    title VARCHAR(50),
    start_at TIMESTAMP,
    end_at TIMESTAMP,
    priority TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_user UUID
);
