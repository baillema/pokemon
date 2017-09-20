import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ItemsComponent } from './component/items/items.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './component/home/home.component';
import { UsersComponent } from './component/users/users.component';
import { ItemComponent } from './component/item/item.component';
import { ProfilsComponent } from './component/profils/profils.component';
import { AjoutComponent } from './component/ajout/ajout.component';
import { EchangeComponent } from './component/echange/echange.component';
import { CartComponent } from './component/cart/cart.component';
import { CartService } from './service/cart/cart.service';
import { AddPokemonFormComponent } from './component/add-pokemon-form/add-pokemon-form.component';

@NgModule({
  declarations: [
    AppComponent,
    ItemsComponent,
    HomeComponent,
    UsersComponent,
    ItemComponent,
    ProfilsComponent,
    AjoutComponent,
    EchangeComponent,
    CartComponent,
    AddPokemonFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [
    CartService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
