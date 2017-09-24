import { PokemonArticle } from '../../model/articles/pokemon-article';
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { environment as env } from '../../../environments/environment';
import 'rxjs/Rx';

@Injectable()
export class PokemonsArticlesService {

  constructor(private http: Http) { }

  public all(): Observable<PokemonArticlesResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-articles/`)
      .map(res => {
        const body = res.json();
        return { err: null, articles: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, articles: null });
      });
  }

  public get(id: number): Observable<PokemonArticleResponse> {
    return this.http.get(`${env.serverUrl}/pokemons-articles/id/${id}`)
      .map(res => {
        const body: any = res.json();
        return { err: null, article: body };
      })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, article: null });
      });
  }

  public save(article: PokemonArticle): Observable<PokemonArticleResponse> {
    let obs: Observable<Response>;
    if (article.id) {
      obs = this.http.put(`${env.serverUrl}/pokemons-articles/id/${article.id}`, article);
    } else {
      obs = this.http.post(`${env.serverUrl}/pokemons-articles`, article);
    }

    return obs.map(res => {
      const body: any = res.json();
      return { err: null, article: body };
    })
      .catch(err => {
        console.log('Server error: ' + JSON.stringify(err, null, 2));
        return Observable.of({ err: err, article: null });
      });
  }
}

export interface PokemonArticlesResponse {
  err: any;
  articles: PokemonArticle[];
}

export interface PokemonArticleResponse {
  err: any;
  article: PokemonArticle;
}
