import { Component, OnChanges, OnInit } from '@angular/core';
import { CartService } from '../../service/cart/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

export class CartComponent implements OnInit {
  cart: Cart;

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
    this.cartService
      .deleteArticleFromCart(article, cart)
      .then(basket => this.cart = basket);
    return this.cart;
  }

  addArticle(article: Article, cart: Cart): Cart {
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

  updatingCartLifeCycle(): void {
    this.cartService
      .updatingCartLifeCycle();
  }
}
