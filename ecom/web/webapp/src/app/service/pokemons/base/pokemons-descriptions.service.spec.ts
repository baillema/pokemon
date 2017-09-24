import { TestBed, inject } from '@angular/core/testing';

import { PokemonsDescriptionsService } from './pokemons-descriptions.service';

describe('PokemonsDescriptionsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsDescriptionsService]
    });
  });

  it('should be created', inject([PokemonsDescriptionsService], (service: PokemonsDescriptionsService) => {
    expect(service).toBeTruthy();
  }));
});
