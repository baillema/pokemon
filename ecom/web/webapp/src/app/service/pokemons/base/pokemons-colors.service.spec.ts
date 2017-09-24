import { TestBed, inject } from '@angular/core/testing';

import { PokemonsColorsService } from './pokemons-colors.service';

describe('PokemonsColorsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsColorsService]
    });
  });

  it('should be created', inject([PokemonsColorsService], (service: PokemonsColorsService) => {
    expect(service).toBeTruthy();
  }));
});
