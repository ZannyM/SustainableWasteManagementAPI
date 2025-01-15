--WasteCategories table schema
CREATE TABLE waste_category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

--recycling tip table schema
CREATE TABLE recycling_tip (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category BIGINT NOT NULL,              -- Changed to BIGINT to match waste_category id
    tip VARCHAR(255) NOT NULL,             -- Changed from recycling_tip to tip
    FOREIGN KEY (category) REFERENCES waste_category(id)  -- Added foreign key constraint
);

--disposal guideline table schema
CREATE TABLE disposal_guideline (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    waste_type VARCHAR(255) NOT NULL,
    disposal_method VARCHAR(255) NOT NULL,
    instructions VARCHAR(255) NOT NULL,
    hazardous BOOLEAN NOT NULL
);
