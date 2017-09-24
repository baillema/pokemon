import { PokemonSpeciesTranslation } from '../../model/pokemons/translations/pokemon-species-translation';
import { PokemonArticle } from '../../model/articles/pokemon-article';
import { PokemonsSpeciesTranslationsService } from '../../service/pokemons/translations/pokemons-species-translations.service';
import { PokemonsArticlesService } from '../../service/articles/pokemons-articles.service';
import { Component, OnInit, ElementRef } from '@angular/core';

import { Pokemon } from './../../model/pokemon';

@Component({
  selector: 'app-add-pokemon-form',
  templateUrl: './add-pokemon-form.component.html',
  styleUrls: ['./add-pokemon-form.component.css']
})
export class AddPokemonFormComponent implements OnInit {
  private maxNameLength = 20;
  private MaxDescriptionLength = 500;

  private article: PokemonArticle;
  private species: PokemonSpeciesTranslation[];
  err: any;

  constructor(private pokemonsSpeciesService: PokemonsSpeciesTranslationsService,
              private pokemonsArticlesService: PokemonsArticlesService) {}

  ngOnInit() {
    this.article = {} as PokemonArticle;
    this.article.shininess  = false;
    this.pokemonsSpeciesService.allEnglish().subscribe(res => {
      this.species = res.speciesTranslations;
      this.err = res.err;
    });
  }

  _keyPress(event: KeyboardEvent) {
    const input = String.fromCharCode(event.charCode);

    if (input === 'e' || input === ',') {
      event.preventDefault();
    }
  }

  onSubmit(): void {
    this.article.userId = 1;
    console.log(this.article);
    this.pokemonsArticlesService.save(this.article).subscribe(res => {
        this.article = res.article;
    });
  }
}
