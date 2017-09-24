import { PokemonDescriptionTranslation } from '../../../model/pokemons/translations/pokemon-description-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsDescriptionsTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<PokemonDescriptionsTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<PokemonDescriptionsTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<PokemonDescriptionsTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonDescriptionTranslationsResponse> {
    return this.getFrom(`/id/${id}`);
  }

  public getFromLang(id: number): Observable<PokemonDescriptionsTranslationsResponse> {
    return this.allOf(`/lang/${id}`);
  }

  public getFromIdLang(descriptionId: number, langId): Observable<PokemonDescriptionTranslationsResponse> {
    return this.getFrom(`/idLang/${descriptionId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonDescriptionTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-descriptions-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, descriptionTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, descriptionTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<PokemonDescriptionsTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-descriptions-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, descriptionsTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, descriptionsTranslations: null });
    });
  }
}

export interface PokemonDescriptionsTranslationsResponse {
  err: any;
  descriptionsTranslations: PokemonDescriptionTranslation[];
}

export interface PokemonDescriptionTranslationsResponse {
  err: any;
  descriptionTranslations: PokemonDescriptionTranslation;
}
