import { TestBed, inject } from '@angular/core/testing';

import { PokemonsColorsTranslationsService } from './pokemons-colors-translations.service';

describe('PokemonsColorsTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsColorsTranslationsService]
    });
  });

  it('should be created', inject([PokemonsColorsTranslationsService], (service: PokemonsColorsTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
