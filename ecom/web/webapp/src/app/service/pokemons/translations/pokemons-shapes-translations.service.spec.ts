import { TestBed, inject } from '@angular/core/testing';

import { PokemonsShapesTranslationsService } from './pokemons-shapes-translations.service';

describe('PokemonsShapesTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsShapesTranslationsService]
    });
  });

  it('should be created', inject([PokemonsShapesTranslationsService], (service: PokemonsShapesTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
