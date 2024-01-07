create table users (
    id UUID PRIMARY KEY NOT NULL,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    document VARCHAR(60) UNIQUE,
    email VARCHAR(60) UNIQUE,
    password VARCHAR(255) NOT NULL,
    balance NUMERIC,
    user_type VARCHAR(60),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);