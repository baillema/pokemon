import { PokemonSpeciesTranslation } from '../../model/pokemons/translations/pokemon-species-translation';
import { PokemonSpeciesService } from '../../service/pokemon-species/pokemon-species.service';
import { Component, OnInit, ElementRef } from '@angular/core';

import { Pokemon } from './../../model/pokemon';

@Component({
  selector: 'app-add-pokemon-form',
  templateUrl: './add-pokemon-form.component.html',
  styleUrls: ['./add-pokemon-form.component.css']
})
export class AddPokemonFormComponent implements OnInit {
  private maxNicknameLength = 10;
  private MaxDescriptionLength = 500;

  private pokemon: Pokemon;
  private species: PokemonSpeciesTranslation[];
  err: any;

  constructor(private pokemonSpeciesService: PokemonSpeciesService) {}

  ngOnInit() {
    this.newPokemon();
    this.pokemonSpeciesService.all().subscribe(res => {
      this.species = res.species;
      this.err = res.err;
    });
  }

  newPokemon(): void {
    this.pokemon = new Pokemon();
  }

  _keyPress(event: KeyboardEvent) {
    const input = String.fromCharCode(event.charCode);

    if (input === 'e' || input === ',') {
      event.preventDefault();
    }
  }

  onSubmit(): void {
    console.log(this.species[0].translation);
    console.log(this.pokemon);
  }
}
