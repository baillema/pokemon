import { PokemonColorTranslation } from '../../../model/pokemons/translations/pokemon-color-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsColorsTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<PokemonColorsTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<PokemonColorsTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<PokemonColorsTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonColorTranslationsResponse> {
    return this.getFrom(`/id/${id}`);
  }

  public getFromLang(id: number): Observable<PokemonColorsTranslationsResponse> {
    return this.allOf(`/lang/${id}`);
  }

  public getFromIdLang(colorId: number, langId): Observable<PokemonColorTranslationsResponse> {
    return this.getFrom(`/idLang/${colorId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonColorTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-colors-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, colorTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, colorTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<PokemonColorsTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-colors-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, colorsTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, colorsTranslations: null });
    });
  }
}

export interface PokemonColorsTranslationsResponse {
  err: any;
  colorsTranslations: PokemonColorTranslation[];
}

export interface PokemonColorTranslationsResponse {
  err: any;
  colorTranslations: PokemonColorTranslation;
}
