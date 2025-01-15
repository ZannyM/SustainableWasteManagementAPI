---- Insert waste categories into the database
--INSERT INTO waste_category (name, description) VALUES ('Plastic', 'Non-biodegradable waste made from synthetic or semi-synthetic organic compounds. Includes items like bottles, bags, and packaging materials.');
--INSERT INTO waste_category (name, description) VALUES ('Organic', 'Biodegradable waste from natural sources, such as food scraps, garden waste, and agricultural byproducts.');
--INSERT INTO waste_category (name, description) VALUES ('Electronic', 'Waste from electronic devices and gadgets, such as old phones, computers, and appliances (e-waste).');
--INSERT INTO waste_category (name, description) VALUES ('Metal', 'Waste made from metals, including aluminum cans, scrap metal, and metal containers.');
--INSERT INTO waste_category (name, description) VALUES ('Glass', 'Non-biodegradable waste made from glass materials, such as bottles, jars, and broken glass.');
--INSERT INTO waste_category (name, description) VALUES ('Paper', 'Waste made from paper products, such as newspapers, cardboard, and office paper.');
--INSERT INTO waste_category (name, description) VALUES ('Textile', 'Waste generated from clothing, fabric, and other textile materials.');
--INSERT INTO waste_category (name, description) VALUES ('Construction and Demolition (C&D)', 'Waste from construction and demolition activities, such as concrete, bricks, wood, and drywall.');
--INSERT INTO waste_category (name, description) VALUES ('Hazardous', 'Waste that poses a potential risk to human health or the environment, such as chemicals, batteries, and medical waste.');
--INSERT INTO waste_category (name, description) VALUES ('Medical/Biomedical', 'Waste generated from medical facilities, such as syringes, bandages, and pharmaceutical waste.');
--INSERT INTO waste_category (name, description) VALUES ('Rubber', 'Waste made from rubber materials, such as tires, rubber bands, and rubberized products.');
--INSERT INTO waste_category (name, description) VALUES ('Wood', 'Waste generated from wooden materials, such as furniture, pallets, and untreated wood scraps.');
--INSERT INTO waste_category (name, description) VALUES ('Plastic Composite', 'Waste made from mixed materials that include plastic, such as Tetra Pak cartons and composite packaging.');
--INSERT INTO waste_category (name, description) VALUES ('Chemical', 'Waste from industrial or household chemicals, such as solvents, detergents, and fertilizers.');
--INSERT INTO waste_category (name, description) VALUES ('Ash', 'Residue from burning materials, such as coal ash or wood ash.');
--INSERT INTO waste_category (name, description) VALUES ('Ceramic', 'Waste made from ceramic materials, such as pottery, tiles, and porcelain.');
--INSERT INTO waste_category (name, description) VALUES ('Food Waste', 'Waste from discarded or spoiled food products, including kitchen scraps and leftovers.');
--INSERT INTO waste_category (name, description) VALUES ('Green Waste', 'Biodegradable waste from gardens and parks, such as grass clippings, leaves, and branches.');
--INSERT INTO waste_category (name, description) VALUES ('Leather', 'Waste generated from leather products, such as shoes, belts, and bags.');
--INSERT INTO waste_category (name, description) VALUES ('Municipal Solid Waste (MSW)', 'General household waste, including mixed materials that are not sorted.');
--INSERT INTO waste_category (name, description) VALUES ('Industrial Waste', 'Waste from industrial processes, such as slag, tailings, and manufacturing debris.');
--INSERT INTO waste_category (name, description) VALUES ('Nuclear', 'Radioactive waste generated from nuclear power plants, medical treatments, or research.');
--INSERT INTO waste_category (name, description) VALUES ('Paint and Coatings', 'Waste from leftover paints, varnishes, and other surface treatments.');
--INSERT INTO waste_category (name, description) VALUES ('Packaging', 'Waste from packaging materials, including bubble wrap, Styrofoam, and cardboard boxes.');
--INSERT INTO waste_category (name, description) VALUES ('Composite Materials', 'Waste from mixed materials like carbon fiber or fiberglass.');

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

-- Disposal Guidelines
INSERT INTO disposal_guideline (category, guideline) VALUES ('Plastic', 'Dispose plastics in designated recycling bins.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Organic', 'Place organic waste in a compost bin or donate to local composting facilities.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Electronic', 'Dispose of electronics at e-waste recycling centers.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Metal', 'Take scrap metal to a recycling yard.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Glass', 'Recycle glass in appropriate glass recycling containers.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Paper', 'Place paper products in paper recycling bins.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Textile', 'Donate usable textiles to charities or recycle.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Hazardous', 'Take hazardous waste to specialized disposal facilities.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Construction', 'Dispose of construction debris at designated facilities.');
INSERT INTO disposal_guideline (category, guideline) VALUES ('Medical', 'Dispose of medical waste through approved medical waste disposal services.');

-- Recycling Tips
INSERT INTO recycling_tip (category, tip) VALUES ('Plastic', 'Clean and sort plastics before recycling.');
INSERT INTO recycling_tip (category, tip) VALUES ('Organic', 'Compost organic waste at home or in community compost bins.');
INSERT INTO recycling_tip (category, tip) VALUES ('Electronic', 'Remove personal data before recycling electronics.');
INSERT INTO recycling_tip (category, tip) VALUES ('Metal', 'Rinse food cans before recycling to avoid contamination.');
INSERT INTO recycling_tip (category, tip) VALUES ('Glass', 'Separate glass by color if required by your local recycler.');
INSERT INTO recycling_tip (category, tip) VALUES ('Paper', 'Avoid recycling wet or greasy paper.');
INSERT INTO recycling_tip (category, tip) VALUES ('Textile', 'Repair or repurpose old clothes before recycling.');
INSERT INTO recycling_tip (category, tip) VALUES ('Hazardous', 'Seal hazardous materials tightly before disposal.');
INSERT INTO recycling_tip (category, tip) VALUES ('Construction', 'Reuse materials like bricks and wood if possible.');
INSERT INTO recycling_tip (category, tip) VALUES ('Medical', 'Place sharps in a puncture-proof container before disposal.');
