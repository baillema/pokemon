# Pokemon Infos Retriever

This command line tool retrieves data from [Pokeapi](https://pokeapi.co/) and generates sql files allowing us to 
easily populate our database. Since we don't do any caching on the data, and because we might do a lot of calls 
(for non-english languages), this tool runs slowly depending on the data being retrieved (e.g 720 calls for the 
pokemons). That being said, since this should be used as a "run once every few months" tool (e.g when a new game comes 
out), it is fine for now. 

## Usage

No proper usage for now, you have to modify the main function and call whatever functions you need (e.g if you need to 
write the ``colors_translations`` table, call ``writePokemonColorsTransInserts()``). 

## Notes

- Quick & dirty code, not tested, band aid programming
- Items are not yet implemented
