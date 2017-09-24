import { PokemonSpeciesTranslation } from '../translations/pokemon-species-translation';

export interface PokemonSpecies {
  id: number;
  translations: PokemonSpeciesTranslation[];
}
