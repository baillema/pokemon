import { TestBed, inject } from '@angular/core/testing';

import { PokemonsShapesService } from './pokemons-shapes.service';

describe('PokemonsShapesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsShapesService]
    });
  });

  it('should be created', inject([PokemonsShapesService], (service: PokemonsShapesService) => {
    expect(service).toBeTruthy();
  }));
});
