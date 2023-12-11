CREATE TABLE message
(
    id             BIGSERIAL PRIMARY KEY,
    uuid           TEXT NOT NULL DEFAULT uuid_generate_v4(),
    content        TEXT NOT NULL,
    user_uuid_from TEXT NOT NULL,
    user_uuid_to   TEXT NOT NULL,
    is_read        BOOLEAN       DEFAULT FALSE,
    created_at     TIMESTAMP     DEFAULT NOW(),
    updated_at     TIMESTAMP     DEFAULT NOW(),
    time           TIMESTAMP
);