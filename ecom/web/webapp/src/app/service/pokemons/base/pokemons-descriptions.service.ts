import { PokemonDescription } from '../../../model/pokemons/base/pokemon-description';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsDescriptionsService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonDescriptionsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-descriptions/`)
      .map(res => {
        const body = res.json();
        return { err: null, descriptions: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, descriptions: null });
      });
  }

  public get(id: number): Observable<PokemonDescriptionResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-descriptions/${id}`)
    .map(res => {
      const body: any = res.json();
      return { err: null, description: body};
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({err: err, description: null});
    });
  }
}

export interface PokemonDescriptionsResponse {
  err: any;
  descriptions: PokemonDescription[];
}

export interface PokemonDescriptionResponse {
  err: any;
  description: PokemonDescription;
}
