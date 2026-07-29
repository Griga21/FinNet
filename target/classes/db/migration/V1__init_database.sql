CREATE TABLE IF NOT EXISTS bank_account (
    id BIGSERIAL PRIMARY KEY,
    account_balance NUMERIC(15, 2) NOT NULL DEFAULT 0,
    account_number VARCHAR NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS transactions (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGINT  NOT NULL,
    amount NUMERIC(15, 2) NOT NULL CHECK (amount >= 0),
    type INTEGER NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transactions_bank_account
        FOREIGN KEY (account_id)
        REFERENCES bank_account(id)
        ON DELETE RESTRICT
);

CREATE INDEX idx_transactions_account_id ON transactions(account_id);
CREATE INDEX idx_transactions_type ON transactions(type);
CREATE INDEX idx_transactions_status ON transactions(status);
CREATE INDEX idx_transactions_created_at ON transactions(created_at);