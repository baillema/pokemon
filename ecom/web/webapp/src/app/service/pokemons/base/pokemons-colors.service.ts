import { PokemonColor } from '../../../model/pokemons/base/pokemon-color';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsColorsService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonColorsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-colors/`)
      .map(res => {
        const body = res.json();
        return { err: null, colors: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, colors: null });
      });
  }

  public get(id: number): Observable<PokemonColorResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-colors/${id}`)
    .map(res => {
      const body: any = res.json();
      return { err: null, color: body};
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({err: err, color: null});
    });
  }
}

export interface PokemonColorsResponse {
  err: any;
  colors: PokemonColor[];
}

export interface PokemonColorResponse {
  err: any;
  color: PokemonColor;
}
