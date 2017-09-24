import { PokemonHabitatTranslation } from '../../../model/pokemons/translations/pokemon-habitat-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsHabitatsTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<PokemonHabitatsTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<PokemonHabitatsTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<PokemonHabitatsTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonHabitatTranslationsResponse> {
    return this.getFrom(`id/${id}`);
  }

  public getFromLang(id: number): Observable<PokemonHabitatsTranslationsResponse> {
    return this.allOf(`lang/${id}`);
  }

  public getFromIdLang(habitatId: number, langId): Observable<PokemonHabitatTranslationsResponse> {
    return this.getFrom(`idLang/${habitatId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonHabitatTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-habitats-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, habitatTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, habitatTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<PokemonHabitatsTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-habitats-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, habitatsTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, habitatsTranslations: null });
    });
  }
}

export interface PokemonHabitatsTranslationsResponse {
  err: any;
  habitatsTranslations: PokemonHabitatTranslation[];
}

export interface PokemonHabitatTranslationsResponse {
  err: any;
  habitatTranslations: PokemonHabitatTranslation;
}
