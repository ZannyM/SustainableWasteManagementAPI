--WasteCategories table schema
CREATE TABLE waste_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- Automatically increments and is the primary key
    name VARCHAR(255) NOT NULL,            -- The name column cannot be null
    description VARCHAR(255) NOT NULL      -- The description column cannot be null
);

--recycling tip table schema
CREATE TABLE recycling_tip (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    recycling_tip VARCHAR(255) NOT NULL
);

--disposal guideline table schema
CREATE TABLE disposal_guideline (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    guideline VARCHAR(255) NOT NULL
);


