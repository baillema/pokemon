import { TestBed, inject } from '@angular/core/testing';

import { PokemonsSpeciesService } from './pokemons-species.service';

describe('PokemonsSpeciesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsSpeciesService]
    });
  });

  it('should be created', inject([PokemonsSpeciesService], (service: PokemonsSpeciesService) => {
    expect(service).toBeTruthy();
  }));
});
