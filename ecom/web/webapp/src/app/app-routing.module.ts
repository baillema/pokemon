import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ItemsComponent} from './component/items/items.component';
import {HomeComponent} from './component/home/home.component';
import {UsersComponent} from './component/users/users.component';
import {AjoutComponent} from './component/ajout/ajout.component';
import {ItemComponent} from './component/item/item.component';
import {ProfilsComponent} from './component/profils/profils.component';
import {EchangeComponent} from './component/echange/echange.component';
import {CartComponent} from './component/cart/cart.component'
import {DashboardComponent} from './component/dashboard/dashboard.component';

// Routes
const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'items', component: ItemsComponent},
  {path: 'item', component: ItemComponent},
  {path: 'profil', component: ProfilsComponent},
  {path: 'change', component: EchangeComponent},
  {path: 'login', component: UsersComponent},
  {path: 'add', component: AjoutComponent},
  {path: 'cart', component: CartComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}

];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
