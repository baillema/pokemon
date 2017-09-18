import { Injectable } from '@angular/core';
import {Http} from '@angular/http';

import 'rxjs/Rx';
import {Observable} from 'rxjs';
import {Pokemons} from "../../model/pokemons";

@Injectable()
export class ItemsService {

  constructor(private http:Http) {}

  public matchall(): Observable<PokemonsResponse> {
    return this.http.get(`http://152.77.78.29:8080/web/api/pokelastic/matchall/pokemons_species_translations/`)
      .map(res => {
        const body = res.json().hits;
        return { err: null, resultPkm: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, species: null});
      });
  }

  public simple(name, request): Observable<PokemonsResponse> {
    return this.http.get(`http://152.77.78.29:8080/web/api/pokelastic/simple/pokemons_species_translations/`+name+"/"+request)
      .map(res => {
        const body = res.json().hits;
        return { err: null, resultPkm: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, species: null});
      });
  }

  public exact(name, request): Observable<PokemonsResponse> {
    return this.http.get(`http://152.77.78.29:8080/web/api/pokelastic/exact/pokemons_species_translations/`+name+"/"+request)
      .map(res => {
        const body = res.json().hits;
        return { err: null, resultPkm: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, species: null});
      });
  }

  public wildcard(name, request): Observable<PokemonsResponse> {
    return this.http.get(`http://152.77.78.29:8080/web/api/pokelastic/wildcard/pokemons_species_translations/`+name+"/"+request)
      .map(res => {
        const body = res.json().hits;
        return { err: null, resultPkm: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, species: null});
      });
  }

  public fuzzy(name, request): Observable<PokemonsResponse> {
    return this.http.get(`http://152.77.78.29:8080/web/api/pokelastic/fuzzy/pokemons_species_translations/`+name+"/"+request)
      .map(res => {
        const body = res.json().hits;
        return { err: null, resultPkm: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({err: err, species: null});
      });
  }
}

export interface PokemonsResponse {
    err: any;
    resultPkm: Pokemons[];
  }
