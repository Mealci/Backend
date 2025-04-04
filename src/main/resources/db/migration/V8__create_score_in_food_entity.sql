ALTER TABLE food
    ADD nova_group_score INTEGER DEFAULT 0;

ALTER TABLE food
    ADD nutri_score INTEGER DEFAULT 0;

ALTER TABLE food
    ALTER COLUMN nova_group_score SET NOT NULL;

ALTER TABLE food
    ALTER COLUMN nutri_score SET NOT NULL;