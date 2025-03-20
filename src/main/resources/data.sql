-- Waste Categories
INSERT INTO waste_category (name, description) VALUES ('Plastic', 'Non-biodegradable waste.');
INSERT INTO waste_category (name, description) VALUES ('Organic', 'Biodegradable waste such as food scraps.');
INSERT INTO waste_category (name, description) VALUES ('Electronic', 'E-waste including old gadgets and devices.');
INSERT INTO waste_category (name, description) VALUES ('Metal', 'Scrap metal waste from cans, tools, etc.');
INSERT INTO waste_category (name, description) VALUES ('Glass', 'Discarded glass bottles, jars, and items.');
INSERT INTO waste_category (name, description) VALUES ('Paper', 'Recyclable waste like newspapers, magazines, etc.');
INSERT INTO waste_category (name, description) VALUES ('Textile', 'Clothing, fabrics, and textile scraps.');
INSERT INTO waste_category (name, description) VALUES ('Hazardous', 'Chemical or toxic waste.');
INSERT INTO waste_category (name, description) VALUES ('Construction', 'Debris from construction projects.');
INSERT INTO waste_category (name, description) VALUES ('Medical', 'Used medical equipment and waste.');

-- Insert into recycling_tip using the IDs of the waste categories
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Plastic'), 'Clean and sort plastics before recycling.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Organic'), 'Compost organic waste at home or in community compost bins.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Electronic'), 'Remove personal data before recycling electronics.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Metal'), 'Rinse food cans before recycling to avoid contamination.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Glass'), 'Separate glass by color if required by your local recycler.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Paper'), 'Avoid recycling wet or greasy paper.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Textile'), 'Repair or repurpose old clothes before recycling.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Hazardous'), 'Seal hazardous materials tightly before disposal.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Construction'), 'Reuse materials like bricks and wood if possible.');
INSERT INTO recycling_tip (category_id, tip) VALUES ((SELECT id FROM waste_category WHERE name = 'Medical'), 'Place sharps in a puncture-proof container before disposal.');

-- Insert disposal guidelines for various waste types
INSERT INTO disposal_guideline (waste_type, disposal_method, instructions, hazardous)
VALUES
('Paper', 'Recycling', 'Collect paper in a separate bin. Ensure it is clean and dry.', false),
('Batteries', 'Hazardous Waste Collection', 'Dispose of batteries at designated hazardous waste collection points.', true),
('Plastic', 'Recycling', 'Separate by type and remove any food residues before disposal.', false),
('Organic', 'Composting', 'Use home or community compost bins to reduce landfill waste.', false),
('Electronic', 'E-Waste Recycling', 'Drop off at certified e-waste recycling centers.', true),
('Metal', 'Recycling', 'Ensure items are clean and sorted by type before recycling.', false),
('Glass', 'Recycling', 'Sort by color if required and remove any lids or caps.', false),
('Textile', 'Donation/Recycling', 'Donate usable items, recycle unusable fabrics.', false),
('Hazardous', 'Specialized Disposal', 'Follow local guidelines and dispose of at authorized centers.', true),
('Construction', 'Reuse/Recycling', 'Sort materials and reuse where possible, recycle the rest.', false),
('Medical', 'Biohazard Disposal', 'Use designated biohazard containers for disposal.', true);
