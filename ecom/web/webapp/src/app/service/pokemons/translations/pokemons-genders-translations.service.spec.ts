import { TestBed, inject } from '@angular/core/testing';

import { PokemonsGendersTranslationsService } from './pokemons-genders-translations.service';

describe('PokemonsGendersTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsGendersTranslationsService]
    });
  });

  it('should be created', inject([PokemonsGendersTranslationsService], (service: PokemonsGendersTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
