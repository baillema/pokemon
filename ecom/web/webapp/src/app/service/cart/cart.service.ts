import {Injectable} from '@angular/core';
import 'rxjs/Rx';

@Injectable()
export class CartService {
  cart: Cart;

  constructor() {
  }

  public findCurrentCartForUser(userId: number): Promise<Cart> {

    const articles: Article[] = [];
    const article1: Article = {
      id: 1,
      name: 'Article 1',
      price: 100,
      description: 'description',
      shininess: false,
      level: 100,
      picture: '/assets/img/pokemons/802.png',
      mark: 5
    };

    const article2: Article = {
      id: 2,
      name: 'Article 2',
      price: 10000,
      description: 'description',
      shininess: true,
      level: 100,
      picture: '/assets/img/pokemons/802.png',
      mark: 4
    };

    articles.push(article1);
    articles.push(article2);

    this.cart = {
      id: 1,
      total: 1100,
      articles: articles,
    };
    return Promise.resolve(this.cart);
  }

  public deleteArticleFromCart(article: Article, cart: Cart): Promise<Cart> {
    cart.articles = cart.articles
      .filter(cartArticle => cartArticle.id !== article.id);
    return Promise.resolve(cart);
  }

  public addArticleFromCart(article: Article, cart: Cart): Promise<Cart> {
    cart.articles.push(article);

<<<<<<< HEAD
=======
    this.updatingCartLifeCycle();

>>>>>>> XAdd cart
    return Promise.resolve(cart);
  }

  public placeOrderFromCart(cart: Cart): Promise<Cart> {
    const newCart: Cart = {
      id: 2,
      total: 0,
      articles: [],
    };

    return Promise.resolve(newCart);
  }

<<<<<<< HEAD
  public deleteArticlesFromCart(cart: Cart) {
=======
  public updatingCartLifeCycle(): void {
>>>>>>> XAdd cart

  }
}
