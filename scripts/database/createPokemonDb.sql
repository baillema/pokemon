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
  language_id INT PRIMARY KEY,
  language_name VARCHAR(20)
);

------------------------------------------------------------------------------------------------------------------------
--- USERS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE permissions (
  permission_id INT PRIMARY KEY,
  permission VARCHAR(10)
);

CREATE TABLE roles 
(
  role_id INT PRIMARY KEY,
  role_name VARCHAR(20)
);

CREATE TABLE roles_translations
(
  role INT REFERENCES roles (role_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (role, language_id)
);

CREATE TABLE users 
(
  user_id INT PRIMARY KEY,
  user_firstname VARCHAR(20),
  user_birthday date,
  user_gender VARCHAR(6) CHECK (user_gender = 'male' OR user_gender = 'female'),
  user_email VARCHAR(20),
  user_password chkpass,
  user_lastname VARCHAR(30),
  user_role INT REFERENCES roles (role_id)
);

CREATE TABLE users_roles 
(
  user_role_user_id INT REFERENCES users (user_id),
  user_role_role_id INT REFERENCES roles (role_id),
  PRIMARY KEY (user_role_user_id, user_role_role_id)
);

CREATE TABLE roles_permissions 
(
  role_permission_role_id INT REFERENCES roles (role_id),
  role_permission_permission_id INT REFERENCES permissions (permission_id),
  PRIMARY KEY (role_permission_role_id, role_permission_permission_id)
);

CREATE TABLE feedback 
(
  feedback_id INT PRIMARY KEY,
  feedback_TEXT TEXT,
  feedback_mark INT CHECK (feedback_mark >= 1 AND feedback_mark <= 10),
  feedback_user_id INT REFERENCES users (user_id)
);

------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE articles 
(
  article_id INT PRIMARY KEY,
  article_name VARCHAR(20),
  article_price REAL,
  article_description TEXT,
  article_user_id INT REFERENCES users (user_id),
  article_feedback_id INT REFERENCES feedback (feedback_id)
);

CREATE TABLE lots
(
  lot_id INT PRIMARY KEY,
  lot_name VARCHAR(20),
  lot_description TEXT
);

CREATE TABLE lots_articles
(
  lot_article_lot_id INT REFERENCES lots (lot_id),
  lot_article_article_id INT REFERENCES articles (article_id),
  PRIMARY KEY (lot_article_lot_id, lot_article_article_id) 
);

CREATE TABLE tags 
(
  tag_article_id INT REFERENCES articles (article_id),
  tag_article_coupled INT REFERENCES articles (article_id),
  CONSTRAINT valid_tag CHECK (tag_article_id != tag_article_coupled),
  PRIMARY KEY (tag_article_id, tag_article_coupled)
);

------------------------------------------------------------------------------------------------------------------------
--- BASKETS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE baskets 
(
  basket_id INT PRIMARY KEY
);

CREATE TABLE baskets_lots
(
  basket_lot_basket_id INT REFERENCES baskets (basket_id),
  basket_lot_lot_id INT REFERENCES lots (lot_id),
  PRIMARY KEY (basket_lot_basket_id, basket_lot_lot_id)
);

------------------------------------------------------------------------------------------------------------------------
--- TRANSACTION RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE orders
(
  order_user_id INT REFERENCES users (user_id),
  order_basket_id INT REFERENCES baskets (basket_id),
  PRIMARY KEY (order_user_id, order_basket_id)
);

CREATE TABLE trades
(
  trade_first_user_id INT REFERENCES users (user_id),
  trade_first_article_id INT REFERENCES articles (article_id),
  trade_second_user_id INT REFERENCES users (user_id),
  trade_second_article_id INT REFERENCES articles (article_id),
  CONSTRAINT valid_user_coupled CHECK (trade_first_user_id != trade_second_user_id), 
  CONSTRAINT valid_article_exchange CHECK (trade_first_article_id != trade_second_article_id),
  PRIMARY KEY (trade_first_user_id, trade_first_article_id, trade_second_user_id, trade_second_article_id)
);

------------------------------------------------------------------------------------------------------------------------
--- ARTICLES RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE articles_categories
(
  article_category_id INT PRIMARY KEY
);

CREATE TABLE articles_categories_translations
(
  article_category_id INT REFERENCES articles_categories (article_category_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (article_category_id, language_id)
);


------------------------------------------------------------------------------------------------------------------------
--- POKEMONS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE pokemons_genders
(
  pokemon_gender_id INT PRIMARY KEY
);

CREATE TABLE pokemons_genders_translations
(
  pokemon_gender_id INT REFERENCES pokemons_genders (pokemon_gender_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_gender_id, language_id)
);

CREATE TABLE pokemons_species
(
  pokemon_species_id INT PRIMARY KEY
);

CREATE TABLE pokemons_species_translations
(
  pokemon_species_id INT REFERENCES pokemons_species (pokemon_species_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_species_id, language_id)
);

CREATE TABLE pokemons_colors
(
  pokemon_color_id INT PRIMARY KEY
);

CREATE TABLE pokemons_colors_translations
(
  pokemon_color_id INT REFERENCES pokemons_colors (pokemon_color_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_color_id, language_id)
);

CREATE TABLE pokemons_shapes
(
  pokemon_shape_id INT PRIMARY KEY
);

CREATE TABLE pokemons_shapes_translations
(
  pokemon_shape_id INT REFERENCES pokemons_shapes (pokemon_shape_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_shape_id, language_id)
);

CREATE TABLE pokemons_habitats
(
  pokemon_habitat_id INT PRIMARY KEY
);

CREATE TABLE pokemons_habitats_translations
(
  pokemon_habitat_id INT REFERENCES pokemons_habitats (pokemon_habitat_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (pokemon_habitat_id, language_id)
);

CREATE TABLE pokemons_descriptions
(
  pokemon_description_id INT PRIMARY KEY
);

CREATE TABLE pokemons_descriptions_translations
(
  pokemon_description_id INT REFERENCES pokemons_descriptions (pokemon_description_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(500),
  PRIMARY KEY (pokemon_description_id, language_id)
);

CREATE TABLE pokemons
(
  pokemon_id INT PRIMARY KEY,
  pokemon_species_id INT REFERENCES pokemons_species (pokemon_species_id),
  pokemon_habitat_id INT REFERENCES pokemons_habitats (pokemon_habitat_id),
  pokemon_color_id INT REFERENCES pokemons_colors (pokemon_color_id),
  pokemon_shape_id INT REFERENCES pokemons_shapes (pokemon_shape_id),
  pokemon_description INT REFERENCES pokemons_descriptions (pokemon_description_id)
);

CREATE TABLE pokemons_accepted_genders
(
  pokemon_id INT REFERENCES pokemons (pokemon_id),
  pokemon_gender_id INT REFERENCES pokemons_genders (pokemon_gender_id)
);

------------------------------------------------------------------------------------------------------------------------
--- OWNED POKEMONS RELATED
------------------------------------------------------------------------------------------------------------------------

-- Note: we need some kind of trigger on the gender: we need to check in pokemons_accepted_genders if the couple
-- (pokemons_reference_id, pokemon_reference_gender) must be in pokemons_accepted_genders.
CREATE TABLE pokemons_references
(
  pokemon_reference_id INT PRIMARY KEY,
  pokemon_reference_pokemon_id INT REFERENCES pokemons (pokemon_id),
  pokemon_reference_name VARCHAR(50),
  pokemon_reference_level INT CHECK (pokemon_reference_level <= 100 AND pokemon_reference_level >= 1),
  pokemon_reference_description VARCHAR(500),
  pokemon_reference_shininess BOOLEAN
);

-- Link with articles
CREATE TABLE pokemons_references_articles
(
  pokemon_reference_article_article_id INT REFERENCES articles (article_id),
  pokemon_reference_article_pokemon_reference_id INT REFERENCES pokemons_references (pokemon_reference_id),
  PRIMARY KEY (pokemon_reference_article_article_id, pokemon_reference_article_pokemon_reference_id)
);

------------------------------------------------------------------------------------------------------------------------
--- ITEMS RELATED
------------------------------------------------------------------------------------------------------------------------

CREATE TABLE items_names
(
  item_name_id INT PRIMARY KEY
);

CREATE TABLE items_names_translations
(
  item_name_id INT REFERENCES items_names (item_name_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (item_name_id, language_id)
);

CREATE TABLE items_descriptions
(
  item_description_id INT PRIMARY KEY
);

CREATE TABLE items_descriptions_translations
(
  item_description_id INT REFERENCES items_descriptions (item_description_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(500),
  PRIMARY KEY (item_description_id, language_id)
);

CREATE TABLE item_categories
(
  item_category_id INT PRIMARY KEY
);

CREATE TABLE items_categories_translations
(
  item_category_id INT REFERENCES item_categories (item_category_id),
  language_id INT REFERENCES languages (language_id),
  translation VARCHAR(50),
  PRIMARY KEY (item_category_id, language_id)
);

CREATE TABLE items_references
(
  item_reference_id INT PRIMARY KEY,
  item_name_id INT REFERENCES items_names (item_name_id),
  item_category_id INT REFERENCES item_categories (item_category_id),
  item_description_id INT REFERENCES items_descriptions (item_description_id)
);

-- Link with articles
CREATE TABLE item_references_articles
(
  item_reference_article_article_id INT REFERENCES articles (article_id),
  item_reference_article_item_reference_id INT REFERENCES items_references (item_reference_id),
  PRIMARY KEY (item_reference_article_article_id, item_reference_article_item_reference_id)
);

CREATE TABLE items
(
  item_id INT PRIMARY KEY,
  item_quantity INT CHECK (item_quantity >= 0),
  item_reference_id INT REFERENCES items_references (item_reference_id)
);
