CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    account_id UUID NOT NULL,
    amount NUMERIC(15, 2) NOT NULL,
    type Integer NOT NULL,  -- ← Добавлено
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);