import { Pokemon } from '../../model/pokemons/pokemon';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../environments/environment';
import 'rxjs/Rx';


@Injectable()
export class PokemonsService {

  constructor(private http: Http) { }

    public all(): Observable<PokemonsResponse> {
      return this.http.get(`${env.serverUrl}/pokemons/`)
        .map(res => {
          const body = res.json();
          return { err: null, pokemons: body };
        })
        .catch(err => {
          console.log('Server error: ' + JSON.stringify(err, null, 2));
          return Observable.of({ err: err, pokemons: null });
        });
    }

    public get(id: number): Observable<PokemonResponse> {
      return this.http.get(`${env.serverUrl}/pokemons/${id}`)
      .map(res => {
        const body: any = res.json();
        return { err: null, pokemon: body};
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, pokemon: null});
      });
    }

}

export interface PokemonsResponse {
  err: any;
  pokemons: Pokemon[];
}

export interface PokemonResponse {
  err: any;
  pokemon: Pokemon;
}
