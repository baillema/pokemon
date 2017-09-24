import { TestBed, inject } from '@angular/core/testing';

import { PokemonsHabitatsTranslationsService } from './pokemons-habitats-translations.service';

describe('PokemonsHabitatsTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsHabitatsTranslationsService]
    });
  });

  it('should be created', inject([PokemonsHabitatsTranslationsService], (service: PokemonsHabitatsTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
