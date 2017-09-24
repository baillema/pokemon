import { TestBed, inject } from '@angular/core/testing';

import { PokemonSpeciesService } from './pokemon-species.service';

describe('PokemonSpeciesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonSpeciesService]
    });
  });

  it('should be created', inject([PokemonSpeciesService], (service: PokemonSpeciesService) => {
    expect(service).toBeTruthy();
  }));
});
