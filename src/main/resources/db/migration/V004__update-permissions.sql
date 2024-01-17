alter table permissions add column created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW();

alter table permissions add column updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW();