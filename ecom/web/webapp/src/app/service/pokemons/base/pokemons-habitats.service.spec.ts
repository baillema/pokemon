import { TestBed, inject } from '@angular/core/testing';

import { PokemonsHabitatsService } from './pokemons-habitats.service';

describe('PokemonsHabitatsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PokemonsHabitatsService]
    });
  });

  it('should be created', inject([PokemonsHabitatsService], (service: PokemonsHabitatsService) => {
    expect(service).toBeTruthy();
  }));
});
