import { PokemonSpeciesTranslation } from '../../../model/pokemons/translations/pokemon-species-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsSpeciesTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<MultiplePokemonSpeciesTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<MultiplePokemonSpeciesTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<MultiplePokemonSpeciesTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonSpeciesTranslationsResponse> {
    return this.getFrom(`/id/${id}`);
  }

  public getFromLang(id: number): Observable<MultiplePokemonSpeciesTranslationsResponse> {
    return this.allOf(`/lang/${id}`);
  }

  public getFromIdLang(specieId: number, langId): Observable<PokemonSpeciesTranslationsResponse> {
    return this.getFrom(`/idLang/${specieId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonSpeciesTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-species-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, specieTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, specieTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<MultiplePokemonSpeciesTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-species-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, speciesTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, speciesTranslations: null });
    });
  }
}

export interface MultiplePokemonSpeciesTranslationsResponse {
  err: any;
  speciesTranslations: PokemonSpecieTranslation[];
}

export interface PokemonSpeciesTranslationsResponse {
  err: any;
  specieTranslations: PokemonSpecieTranslation;
}
