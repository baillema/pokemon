import {Component} from '@angular/core';
import {Router} from '@angular/router';

declare var jquery: any;
declare var $: any;


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})


export class AppComponent {

  constructor(private router: Router) {
    //window.onscroll = toggleStickyHeader();
    window.addEventListener('scroll', toggleStickyHeader);
    function toggleStickyHeader(): void {
      const header = document.getElementById('header');
      const stickyHeight = 80;
      if (scrollY > stickyHeight) {
        header.classList.add('sticky');
      } else {
        header.classList.remove('sticky');
      }
    }
  }

  title = 'PokeShop';


}

/*
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
}
*/
