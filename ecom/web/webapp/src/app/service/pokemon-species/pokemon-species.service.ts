import { PokemonSpecies } from '../../model/pokemon-species';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonSpeciesService {

  constructor(private http: Http) { }

  public all(): Observable<MultiplePokemonSpeciesResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-species-translations/french`)
      .map(res => {
        const body = res.json();
        return { err: null, species: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, species: null });
      });
  }
}

export interface MultiplePokemonSpeciesResponse {
  err: any;
  species: PokemonSpecies[];
}

export interface PokemonSpeciesResponse {
  err: any;
  species: PokemonSpecies;
}
