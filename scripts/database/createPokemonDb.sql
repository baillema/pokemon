------------------------------------------------------------------------------------------------------------------------
--- DROP TABLES
------------------------------------------------------------------------------------------------------------------------
DROP TABLE languages CASCADE;
DROP TABLE roles CASCADE;
DROP TABLE roles_translations CASCADE;
DROP TABLE users CASCADE;
DROP TABLE users_roles CASCADE;
DROP TABLE feedback CASCADE;
DROP TABLE lots CASCADE;
DROP TABLE lots_articles CASCADE;
DROP TABLE suggestions CASCADE;
DROP TABLE carts CASCADE;
DROP TABLE trades CASCADE;
DROP TABLE pokemons_genders CASCADE;
DROP TABLE pokemons_genders_translations CASCADE;
DROP TABLE pokemons_species CASCADE;
DROP TABLE pokemons_species_translations CASCADE;
DROP TABLE pokemons_colors CASCADE;
DROP TABLE pokemons_colors_translations CASCADE;
DROP TABLE pokemons_shapes CASCADE;
DROP TABLE pokemons_shapes_translations CASCADE;
DROP TABLE pokemons_habitats CASCADE;
DROP TABLE pokemons_habitats_translations CASCADE;
DROP TABLE pokemons_descriptions CASCADE;
DROP TABLE pokemons_descriptions_translations CASCADE;
DROP TABLE pokemons CASCADE;
DROP TABLE pokemons_accepted_genders CASCADE;
DROP TABLE pokemons_articles CASCADE;
DROP TABLE items_names CASCADE;
DROP TABLE items_names_translations CASCADE;
DROP TABLE items_descriptions CASCADE;
DROP TABLE items_descriptions_translations CASCADE;
DROP TABLE item_categories CASCADE;
DROP TABLE items_categories_translations CASCADE;
DROP TABLE items_articles CASCADE;
DROP TABLE items CASCADE;
DROP TABLE items_articles CASCADE;
DROP TABLE pokemons_articles CASCADE;
DROP TABLE articles_states CASCADE;
------------------------------------------------------------------------------------------------------------------------
--- EXTENSION
------------------------------------------------------------------------------------------------------------------------
CREATE EXTENSION chkpass;

------------------------------------------------------------------------------------------------------------------------
--- LANGUAGES RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE languages
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20)
);

------------------------------------------------------------------------------------------------------------------------
--- POKEMONS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE pokemons_genders
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_genders_translations
(
  gender_id INT  REFERENCES pokemons_genders (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (gender_id, language_id, translation)
);

CREATE TABLE pokemons_species
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_species_translations
(
  pokemon_specie_id INT REFERENCES pokemons_species (id),
  language_id INT REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_specie_id, language_id, translation)
);

CREATE TABLE pokemons_colors
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_colors_translations
(
  pokemon_color_id INT  REFERENCES pokemons_colors (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_color_id, language_id, translation)
);

CREATE TABLE pokemons_shapes
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_shapes_translations
(
  pokemon_shape_id INT  REFERENCES pokemons_shapes (id),
  language_id INT REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_shape_id, language_id, translation)
);

CREATE TABLE pokemons_habitats
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_habitats_translations
(
  pokemon_habitat_id INT  REFERENCES pokemons_habitats (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_habitat_id, language_id, translation)
);

CREATE TABLE pokemons_descriptions
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_descriptions_translations
(
  pokemon_description_id INT  REFERENCES pokemons_descriptions (id),
  language_id INT  REFERENCES languages (id),
  translation TEXT,
  PRIMARY KEY (pokemon_description_id, language_id, translation)
);

CREATE TABLE pokemons
(
  id INT PRIMARY KEY,
  species_id INT  REFERENCES pokemons_species (id),
  habitat_id INT  REFERENCES pokemons_habitats (id),
  color_id INT  REFERENCES pokemons_colors (id),
  shape_id INT  REFERENCES pokemons_shapes (id),
  description INT  REFERENCES pokemons_descriptions (id)
);

CREATE TABLE pokemons_accepted_genders
(
  pokemon_id INT  REFERENCES pokemons (id),
  pokemon_gender_id INT REFERENCES pokemons_genders (id),
  PRIMARY KEY (pokemon_id, pokemon_gender_id)
);

CREATE TABLE items_names
(
  id INT PRIMARY KEY
);

CREATE TABLE items_names_translations
(
  item_name_id INT  REFERENCES items_names (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (item_name_id, language_id, translation)
);

CREATE TABLE items_descriptions
(
  id INT PRIMARY KEY
);

CREATE TABLE items_descriptions_translations
(
  item_description_id INT  REFERENCES items_descriptions (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (item_description_id, language_id, translation)
);

CREATE TABLE item_categories
(
  id INT PRIMARY KEY
);

CREATE TABLE items_categories_translations
(
  item_category_id INT  REFERENCES item_categories (id),
  language_id INT  REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (item_category_id, language_id, translation)
);

------------------------------------------------------------------------------------------------------------------------
--- USERS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE roles
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20)
);

CREATE TABLE roles_translations
(
  role_id INT NOT NULL REFERENCES roles (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (role_id, language_id)
);

CREATE TABLE users
(
  id SERIAL PRIMARY KEY,
  firstname VARCHAR(20),
  birthday date,
  gender VARCHAR(6) CHECK (gender = 'Male' OR gender = 'Female'),
  email VARCHAR(20),
  password chkpass,
  lastname VARCHAR(30)
);

CREATE TABLE users_roles
(
  user_id INT NOT NULL REFERENCES users (id),
  role_id INT NOT NULL REFERENCES roles (id),
  PRIMARY KEY (user_id, role_id)
);

------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE carts
(
  id SERIAL PRIMARY KEY
);

CREATE TABLE lots
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(25),
  description TEXT,
  prix REAL,
  cart_id INT NOT NULL REFERENCES carts (id)
);

-- Enum
CREATE TABLE articles_states
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(12) CHECK (name = 'Saleable' OR name = 'Exchangeable' OR name = 'Blank')
);

CREATE TABLE pokemons_articles
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20),
  price REAL,
  description TEXT,
  shininess BOOLEAN,
  level INT CHECK (level <= 100 AND level >= 1),
  pokemon_id INT NOT NULL REFERENCES pokemons (id),
  state INT NOT NULL REFERENCES articles_states (id),
  user_id INT NOT NULL REFERENCES users (id),
  lot_id INT NOT NULL REFERENCES lots (id)
);

CREATE TABLE items_articles
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20),
  price REAL,
  description TEXT,
  state INT NOT NULL REFERENCES articles_states (id),
  user_id INT NOT NULL REFERENCES users (id),
  lot_id INT NOT NULL REFERENCES lots (id),
  item_name_id INT REFERENCES items_names (id),
  item_category_id INT REFERENCES item_categories (id),
  item_description_id INT REFERENCES items_descriptions (id)
);

CREATE TABLE feedback
(
  id SERIAL PRIMARY KEY,
  text TEXT,
  mark INT CHECK (mark >= 1 AND mark <= 10),
  author_id INT REFERENCES users (id),
  pokemon_id INT REFERENCES pokemons_articles (id),
  item_id INT REFERENCES items_articles (id),
  user_id INT REFERENCES users (id)
);

CREATE TABLE lots_articles
(
  lot_id INT NOT NULL REFERENCES lots (id),
  item_article_id INT REFERENCES items_articles (id),
  pokemon_article_id INT REFERENCES pokemons_articles (id),
  -- CONSTRAINT CHECK (item_article_id = NULL AND pokemon_article_id = NOT NULL) OR (item_article_id = NOT NULL AND pokemon_article_id = NULL)
  PRIMARY KEY (lot_id, item_article_id, pokemon_article_id)
);

CREATE TABLE suggestions
(
  pokemon_article_id INT REFERENCES pokemons_articles (id),
  item_article_id INT REFERENCES items_articles (id),
  pokemon_article_coupled_id INT REFERENCES pokemons_articles (id),
  item_article_coupled_id INT NOT NULL REFERENCES items_articles (id),
  CONSTRAINT valid_suggestions_pokemon CHECK (pokemon_article_id != pokemon_article_coupled_id),
  CONSTRAINT valid_suggestions_item CHECK (item_article_id != item_article_coupled_id),
  PRIMARY KEY (pokemon_article_id, item_article_id, pokemon_article_coupled_id, item_article_coupled_id)
);

------------------------------------------------------------------------------------------------------------------------
--- TRANSACTION RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE trades
(
  first_user_id INT NOT NULL REFERENCES users (id),
  first_lot_id INT NOT NULL REFERENCES lots (id),
  second_user_id INT NOT NULL REFERENCES users (id),
  second_lot_id INT NOT NULL REFERENCES lots (id),
  CONSTRAINT valid_user_coupled CHECK (first_user_id != second_user_id),
  CONSTRAINT valid_lot_exchange CHECK (first_lot_id != second_lot_id),
  PRIMARY KEY (first_user_id, first_lot_id, second_user_id, second_lot_id)
);
