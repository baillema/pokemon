import { PokemonHabitat } from '../../../model/pokemons/base/pokemon-habitat';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsHabitatsService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonHabitatsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-habitats/`)
      .map(res => {
        const body = res.json();
        return { err: null, habitats: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, habitats: null });
      });
  }

  public get(id: number): Observable<PokemonHabitatResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-habitats/${id}`)
    .map(res => {
      const body: any = res.json();
      return { err: null, habitat: body};
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({err: err, habitat: null});
    });
  }
}

export interface PokemonHabitatsResponse {
  err: any;
  habitats: PokemonHabitat[];
}

export interface PokemonHabitatResponse {
  err: any;
  habitat: PokemonHabitat;
}
