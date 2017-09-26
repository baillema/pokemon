///<reference path="../../../../node_modules/@angular/core/src/metadata/lifecycle_hooks.d.ts"/>
import {Component, OnInit} from '@angular/core';
import {Pokemons} from "../../model/pokemons";
import {ItemsService, PokemonsResponse} from '../../service/items/items.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})

export class ItemsComponent implements OnInit {
  public pkmTab : Pokemons[];

  public types = [
      'acier','combat','dragon','eau','electrique','fee','feu','glace','insecte','normal','plante','poison','psy','roche','sol','spectre','tenebres','vol'
  ];


  err: any;

  constructor(private itemsService: ItemsService) {}

  ngOnInit() {
    this.newPokemonTab();
  }

  private newPokemonTab() {
    this.pkmTab = [];
  }


  private mapping(res: PokemonsResponse) {
    for(var i = 0; i < res.resultPkm["total"]; i++)
    {
      var pkm : Pokemons;
      pkm = new Pokemons;

      pkm.translation = res.resultPkm["hits"][i]["_source"]["translation"];
      pkm.timestamp = res.resultPkm["hits"][i]["_source"]["@timestamp"];
      pkm.language_id = res.resultPkm["hits"][i]["_source"]["language_id"];
      pkm.pokemon_specie_id = res.resultPkm["hits"][i]["_source"]["pokemon_specie_id"];
      this.err = res.err;

      this.pkmTab[i] = pkm;
    }
  }

  public search(name : string, request: string, fuzzy : boolean) {
    this.newPokemonTab();
    //Exact search
    if(request.startsWith("\"") && request.endsWith("\"")) this.itemsService.exact(name, request).subscribe(res => { this.mapping(res)});
    //Wildcard search
    else if(request.indexOf("*") != -1 || request.indexOf("?") != -1) this.itemsService.wildcard(name, request).subscribe(res => { this.mapping(res)});
    //Fuzzy query
    else if(fuzzy) this.itemsService.fuzzy(name, request).subscribe(res => { this.mapping(res)});
    //Simple search
    else this.itemsService.simple(name, request).subscribe(res => { this.mapping(res)});
  }

  private matchall() {
    this.itemsService.matchall().subscribe(res => {this.mapping(res)});
  }

  public typeCheck(type: string): void {
      const elem = document.getElementById('img'+type);

      if(elem.classList.contains('active')){
        elem.classList.remove('active');
      }else{
        elem.classList.add('active');
      }
  }

}
