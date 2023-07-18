CREATE DATABASE got_family_tree;

\c got_family_tree

-- Create the tables and schema
-- Replace with your schema definition SQL
CREATE TABLE character (
  id SERIAL PRIMARY KEY,
  character_name VARCHAR(100) NOT NULL,
  house_name VARCHAR(100),
  royal BOOLEAN,
  character_link VARCHAR(255),
  actor_name VARCHAR(100),
  actor_link VARCHAR(255),
  character_image_thumb VARCHAR(255),
  character_image_full VARCHAR(255),
  nickname VARCHAR(100)
);

CREATE TABLE character_relationship (
  id SERIAL PRIMARY KEY,
  character_id INT,
  related_character_id INT,
  relationship_type VARCHAR(100),
  FOREIGN KEY (character_id) REFERENCES character (id) ON DELETE CASCADE,
  FOREIGN KEY (related_character_id) REFERENCES character (id) ON DELETE CASCADE
);


-- Load the JSON data into the tables
COPY character (character_name, house_name, royal, character_link, actor_name, actor_link, character_image_thumb, character_image_full, nickname)
FROM '/docker-entrypoint-initdb.d/characters.json' DELIMITER ',' CSV HEADER;
