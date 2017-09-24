import { TestBed, inject } from '@angular/core/testing';

import { PokemonsGendersService } from './pokemons-genders.service';

describe('PokemonsGendersService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsGendersService]
    });
  });

  it('should be created', inject([PokemonsGendersService], (service: PokemonsGendersService) => {
    expect(service).toBeTruthy();
  }));
});
