import { PokemonGender } from '../../../model/pokemons/base/pokemon-gender';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsGendersService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonGendersResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-genders/`)
      .map(res => {
        const body = res.json();
        return { err: null, genders: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, genders: null });
      });
  }

  public get(id: number): Observable<PokemonGenderResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-genders/${id}`)
    .map(res => {
      const body: any = res.json();
      return { err: null, gender: body};
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({err: err, gender: null});
    });
  }
}

export interface PokemonGendersResponse {
  err: any;
  genders: PokemonGender[];
}

export interface PokemonGenderResponse {
  err: any;
  gender: PokemonGender;
}
