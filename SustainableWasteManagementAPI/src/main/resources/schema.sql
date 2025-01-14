CREATE TABLE waste_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Automatically increments and is the primary key
    name VARCHAR(255) NOT NULL,            -- The name column cannot be null
    description VARCHAR(255) NOT NULL      -- The description column cannot be null
);
