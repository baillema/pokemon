import { PokemonColor } from './base/pokemon-color';
import { PokemonDescription } from './base/pokemon-description';
import { PokemonHabitat } from './base/pokemon-habitat';
import { PokemonShape } from './base/pokemon-shape';
import { PokemonSpecies } from './base/pokemon-species';

export interface Pokemon {
  id: number;
  color: PokemonColor;
  description: PokemonDescription;
  habitat: PokemonHabitat;
  shape: PokemonShape;
  species: PokemonSpecies;
}
