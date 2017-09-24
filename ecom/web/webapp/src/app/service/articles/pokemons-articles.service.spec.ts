import { TestBed, inject } from '@angular/core/testing';

import { PokemonsArticlesService } from './pokemons-articles.service';

describe('PokemonsArticlesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsArticlesService]
    });
  });

  it('should be created', inject([PokemonsArticlesService], (service: PokemonsArticlesService) => {
    expect(service).toBeTruthy();
  }));
});
