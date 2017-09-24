import { TestBed, inject } from '@angular/core/testing';

import { PokemonsSpeciesTranslationsService } from './pokemons-species-translations.service';

describe('PokemonsSpeciesTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsSpeciesTranslationsService]
    });
  });

  it('should be created', inject([PokemonsSpeciesTranslationsService], (service: PokemonsSpeciesTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
