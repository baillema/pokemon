import { PokemonShapeTranslation } from '../../../model/pokemons/translations/pokemon-shape-translation';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsShapesTranslationsService {
  constructor(private http: Http) { }

  public all(): Observable<PokemonShapesTranslationsResponse> {
    return this.allOf();
  }

  public allFrench(): Observable<PokemonShapesTranslationsResponse> {
    return this.allOf('french');
  }

  public allEnglish(): Observable<PokemonShapesTranslationsResponse> {
    return this.allOf('english');
  }

  public getFromId(id: number): Observable<PokemonShapeTranslationsResponse> {
    return this.getFrom(`id/${id}`);
  }

  public getFromLang(id: number): Observable<PokemonShapesTranslationsResponse> {
    return this.allOf(`lang/${id}`);
  }

  public getFromIdLang(shapeId: number, langId): Observable<PokemonShapeTranslationsResponse> {
    return this.getFrom(`idLang/${shapeId}/${langId}`);
  }

  private getFrom(path: string): Observable<PokemonShapeTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-shapes-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, shapeTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, shapeTranslations: null });
    });
  }

  private allOf(path: string = ''): Observable<PokemonShapesTranslationsResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-shapes-translations/${path}`)
    .map(res => {
      const body = res.json();
      return { err: null, shapesTranslations: body };
    })
    .catch(err => {
      console.log('Server error: ' + JSON.stringify(err, null, 2));
      return Observable.of({ err: err, shapesTranslations: null });
    });
  }
}

export interface PokemonShapesTranslationsResponse {
  err: any;
  shapesTranslations: PokemonShapeTranslation[];
}

export interface PokemonShapeTranslationsResponse {
  err: any;
  shapeTranslations: PokemonShapeTranslation;
}
