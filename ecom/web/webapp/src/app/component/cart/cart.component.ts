import {Component, OnInit, OnChanges} from '@angular/core';
import {CartService} from '../../service/cart/cart.service';
import {TimerObservable} from 'rxjs/observable/TimerObservable';
import {Subscription} from 'rxjs';
import {Article} from '../../model/article';
import {Cart} from '../../model/cart';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

export class CartComponent implements OnInit {
  cart: Cart;

  private subscription: Subscription;


  constructor(private cartService: CartService) {
  }

  ngOnInit() {
    this.getCart(1);
  }

  OnChanges(): Cart {
    return this.cart;
  }


  getCart(userId: number): void {
    this.cartService
      .findCurrentCartForUser(userId)
      .then(cart => this.cart = cart);
  }

  deleteArticle(article: Article, cart: Cart): Cart {

    this.resetLifeCycleCart();


    this.cartService
      .deleteArticleFromCart(article, cart)
      .then(basket => this.cart = basket);
    return this.cart;
  }

  addArticle(article: Article, cart: Cart): Cart {

    this.initLifeCycle();

    this.cartService
      .addArticleFromCart(article, cart)
      .then(basket => this.cart = basket);
    return this.cart;
  }

  placeOrder(cart: Cart): Cart {
    this.cartService
      .placeOrderFromCart(cart)
      .then(basket => this.cart = basket);
    return this.cart;
  }


  /*Life Cycle Cart*/
  resetCart(cart: Cart): void {
    // this.cartService
      // .deleteArticlesFromCart(cart);
  }

  resetLifeCycleCart() {
    this.subscription.unsubscribe();
    this.initLifeCycle();
  }

  /*Must to call it when a user session start*/
  initLifeCycle() {
    const timer = TimerObservable.create(300000, 1);
    this.subscription = timer.subscribe(t => {
      this.resetCart(this.cart);
    });
  }

  /*Must to call it when a user logout*/
  stopLifeCycle() {
    this.subscription.unsubscribe();
  }

  updatingCartLifeCycle(): void {
    // this.cartService.updatingCartLifeCycle();
  }
}
