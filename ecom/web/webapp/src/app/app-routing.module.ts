import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ItemsComponent} from './items/items.component';
import {HomeComponent} from './home/home.component';
import {UsersComponent} from './users/users.component';
import {AjoutComponent} from './ajout/ajout.component';
import {ItemComponent} from './item/item.component';
import {ProfilsComponent} from './profils/profils.component';
import {EchangeComponent} from './echange/echange.component';

// routes
const appRoutes: Routes = [
  {path: 'accueil', component: HomeComponent},
  {path: 'items', component: ItemsComponent},
  {path : 'item' , component : ItemComponent},
  {path : 'profil', component : ProfilsComponent},
  {path : 'echange', component : EchangeComponent},
  {path: 'connexion', component: UsersComponent},
  {path: 'ajout', component: AjoutComponent},
  {path: '' , redirectTo: 'accueil', pathMatch: 'full'}
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
