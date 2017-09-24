import { PokemonShape } from '../../../model/pokemons/base/pokemon-shape';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsShapesService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonShapesResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-shapes/`)
      .map(res => {
        const body = res.json();
        return { err: null, shapes: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, shapes: null });
      });
  }

  public get(id: number): Observable<PokemonShapeResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-shapes/${id}`)
    .map(res => {
      const body: any = res.json();
      return { err: null, shape: body};
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({err: err, shape: null});
    });
  }
}

export interface PokemonShapesResponse {
  err: any;
  shapes: PokemonShape[];
}

export interface PokemonShapeResponse {
  err: any;
  shape: PokemonShape;
}
