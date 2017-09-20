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
  private species: string[];
  constructor() {}

  ngOnInit() {
    this.newPokemon();
    this.species = [
      'Pikachu',
      'Mew',
      'MewTwo'
    ];
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
    console.log(this.pokemon);
  }
}
