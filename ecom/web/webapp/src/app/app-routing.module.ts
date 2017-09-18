import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ItemsComponent} from "./items/items.component";
import {HomeComponent} from "./home/home.component";

// routes
const appRoutes: Routes = [
  {path: 'accueil', component: HomeComponent},
  {path: 'items', component: ItemsComponent},
  {path:'' , redirectTo:'accueil', pathMatch:'full'}
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
