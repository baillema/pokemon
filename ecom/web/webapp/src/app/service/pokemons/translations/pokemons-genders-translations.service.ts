import { PokemonGenderTranslation } from '../../../model/pokemons/translations/pokemon-gender-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsGendersTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<PokemonGendersTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<PokemonGendersTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<PokemonGendersTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonGenderTranslationsResponse> {
    return this.getFrom(`/id/${id}`);
  }

  public getFromLang(id: number): Observable<PokemonGendersTranslationsResponse> {
    return this.allOf(`/lang/${id}`);
  }

  public getFromIdLang(genderId: number, langId): Observable<PokemonGenderTranslationsResponse> {
    return this.getFrom(`/idLang/${genderId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonGenderTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-genders-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, genderTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, genderTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<PokemonGendersTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-genders-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, gendersTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, gendersTranslations: null });
    });
  }
}

export interface PokemonGendersTranslationsResponse {
  err: any;
  gendersTranslations: PokemonGenderTranslation[];
}

export interface PokemonGenderTranslationsResponse {
  err: any;
  genderTranslations: PokemonGenderTranslation;
}
