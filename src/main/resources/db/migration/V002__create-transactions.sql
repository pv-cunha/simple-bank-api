create table transactions (
    id UUID PRIMARY KEY NOT NULL,
    amount NUMERIC NOT NULL,
    sender_id UUID NOT NULL,
    receiver_id UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),

    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id)
);