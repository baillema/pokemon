import { TestBed, inject } from '@angular/core/testing';

import { PokemonsDescriptionsTranslationsService } from './pokemons-descriptions-translations.service';

describe('PokemonsDescriptionsTranslationsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsDescriptionsTranslationsService]
    });
  });

  it('should be created', inject([PokemonsDescriptionsTranslationsService], (service: PokemonsDescriptionsTranslationsService) => {
    expect(service).toBeTruthy();
  }));
});
