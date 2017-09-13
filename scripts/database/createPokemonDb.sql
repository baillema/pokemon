------------------------------------------------------------------------------------------------------------------------
--- DROP TABLES
------------------------------------------------------------------------------------------------------------------------
drop schema public cascade;
create schema public;

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
--- USERS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE permissions (
  id SERIAL PRIMARY KEY,
  permission VARCHAR(10)
);

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

CREATE TABLE roles_permissions 
(
  role_id INT NOT NULL REFERENCES roles (id),
  permission_id INT NOT NULL REFERENCES permissions (id),
  PRIMARY KEY (role_id, permission_id)
);

------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE articles 
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20),
  price REAL,
  description TEXT,
  user_id INT NOT NULL REFERENCES users (id)
);

CREATE TABLE feedback
(
  id SERIAL PRIMARY KEY,
  text TEXT,
  mark INT CHECK (mark >= 1 AND mark <= 10),
  user_id INT REFERENCES users (id),
  article_id INT REFERENCES articles (id)
);

CREATE TABLE lots
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(25),
  description TEXT,
  prix REAL
);

CREATE TABLE lots_articles
(
  lot_id INT NOT NULL REFERENCES lots (id),
  article_id INT NOT NULL REFERENCES articles (id),
  PRIMARY KEY (lot_id, article_id)
);

CREATE TABLE tags 
(
  article_id INT NOT NULL REFERENCES articles (id),
  article_coupled_id INT NOT NULL REFERENCES articles (id),
  CONSTRAINT valid_tag CHECK (article_id != article_coupled_id),
  PRIMARY KEY (article_id, article_coupled_id)
);

------------------------------------------------------------------------------------------------------------------------
--- BASKETS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE baskets 
(
  id SERIAL PRIMARY KEY
);

CREATE TABLE baskets_lots
(
  basket_id INT NOT NULL REFERENCES baskets (id),
  lot_id INT NOT NULL REFERENCES lots (id),
  PRIMARY KEY (basket_id, lot_id)
);

------------------------------------------------------------------------------------------------------------------------
--- TRANSACTION RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE orders
(
  user_id INT NOT NULL REFERENCES users (id),
  basket_id INT NOT NULL REFERENCES baskets (id),
  PRIMARY KEY (user_id, basket_id)
);

CREATE TABLE trades
(
  first_user_id INT NOT NULL REFERENCES users (id),
  first_article_id INT NOT NULL REFERENCES articles (id),
  second_user_id INT NOT NULL REFERENCES users (id),
  second_article_id INT NOT NULL REFERENCES articles (id),
  CONSTRAINT valid_user_coupled CHECK (first_user_id != second_user_id),
  CONSTRAINT valid_article_exchange CHECK (first_article_id != second_article_id),
  PRIMARY KEY (first_user_id, first_article_id, second_user_id, second_article_id)
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
  gender_id INT NOT NULL REFERENCES pokemons_genders (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (gender_id, language_id)
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
  PRIMARY KEY (pokemon_specie_id, language_id)
);

CREATE TABLE pokemons_colors
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_colors_translations
(
  pokemon_color_id INT NOT NULL REFERENCES pokemons_colors (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_color_id, language_id)
);

CREATE TABLE pokemons_shapes
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_shapes_translations
(
  pokemon_shape_id INT NOT NULL REFERENCES pokemons_shapes (id),
  language_id INT REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_shape_id, language_id)
);

CREATE TABLE pokemons_habitats
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_habitats_translations
(
  pokemon_habitat_id INT NOT NULL REFERENCES pokemons_habitats (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_habitat_id, language_id)
);

CREATE TABLE pokemons_descriptions
(
  id INT PRIMARY KEY
);

CREATE TABLE pokemons_descriptions_translations
(
  pokemon_description_id INT NOT NULL REFERENCES pokemons_descriptions (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation TEXT,
  PRIMARY KEY (pokemon_description_id, language_id)
);

CREATE TABLE pokemons
(
  id INT PRIMARY KEY,
  species_id INT NOT NULL REFERENCES pokemons_species (id),
  habitat_id INT NOT NULL REFERENCES pokemons_habitats (id),
  color_id INT NOT NULL REFERENCES pokemons_colors (id),
  shape_id INT NOT NULL REFERENCES pokemons_shapes (id),
  description INT NOT NULL REFERENCES pokemons_descriptions (id)
);

CREATE TABLE pokemons_accepted_genders
(
  pokemon_id INT NOT NULL REFERENCES pokemons (id),
  pokemon_gender_id INT REFERENCES pokemons_genders (id),
  PRIMARY KEY (pokemon_id, pokemon_gender_id)
);

------------------------------------------------------------------------------------------------------------------------
--- OWNED POKEMONS RELATED
------------------------------------------------------------------------------------------------------------------------

-- Note: we need some kind of trigger on the gender: we need to check in pokemons_accepted_genders if the couple
-- (pokemons_reference_id, pokemon_reference_gender) must be in pokemons_accepted_genders.
CREATE TABLE pokemons_references
(
  id INT PRIMARY KEY,
  pokemon_id INT NOT NULL REFERENCES pokemons (id),
  name VARCHAR(50),
  level INT CHECK (level <= 100 AND level >= 1),
  description TEXT,
  shininess BOOLEAN
);

------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE items_names
(
  id INT PRIMARY KEY
);

CREATE TABLE items_names_translations
(
  item_name_id INT NOT NULL REFERENCES items_names (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (item_name_id, language_id)
);

CREATE TABLE items_descriptions
(
  id INT PRIMARY KEY
);

CREATE TABLE items_descriptions_translations
(
  item_description_id INT NOT NULL REFERENCES items_descriptions (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation TEXT,
  PRIMARY KEY (item_description_id, language_id)
);

CREATE TABLE item_categories
(
  id INT PRIMARY KEY
);

CREATE TABLE items_categories_translations
(
  item_category_id INT NOT NULL REFERENCES item_categories (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (item_category_id, language_id)
);

CREATE TABLE items_references
(
  id INT PRIMARY KEY,
  item_name_id INT REFERENCES items_names (id),
  item_category_id INT REFERENCES item_categories (id),
  item_description_id INT REFERENCES items_descriptions (id)
);

CREATE TABLE items
(
  id INT PRIMARY KEY,
  quantity INT CHECK (quantity >= 0),
  item_reference_id INT NOT NULL REFERENCES items_references (id)
);

------------------------------------------------------------------------------------------------------------------------
--- ARTICLES RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE articles_categories
(
  id INT PRIMARY KEY,
  name varchar(50) UNIQUE
);

CREATE TABLE articles_references_translations
(
  translation_id INT NOT NULL REFERENCES articles_categories (id),
  language_id INT NOT NULL REFERENCES languages (id),
  translation VARCHAR(50),
  PRIMARY KEY (translation_id, language_id)
);

-- Link with categrories_articles
CREATE TABLE item_references_articles
(
  item_reference_article_article_id INT REFERENCES articles (id),
  item_reference_article_item_reference_id INT REFERENCES items_references (id),
  PRIMARY KEY (item_reference_article_article_id, item_reference_article_item_reference_id)
);

-- Link with articles
CREATE TABLE pokemons_references_articles
(
  article_id INT NOT NULL REFERENCES articles (id),
  pokemon_reference_id INT NOT NULL REFERENCES pokemons_references (id),
  PRIMARY KEY (article_id, pokemon_reference_id)
);

