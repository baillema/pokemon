import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ItemsComponent} from './component/items/items.component';
import {HomeComponent} from './component/home/home.component';
import {UsersComponent} from './component/users/users.component';
import {AjoutComponent} from './component/ajout/ajout.component';
import {ItemComponent} from './component/item/item.component';
import {ProfilsComponent} from './component/profils/profils.component';
import {EchangeComponent} from './component/echange/echange.component';

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
