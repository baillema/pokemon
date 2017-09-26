import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})

<<<<<<< HEAD
export class AppComponent implements OnInit {


  constructor(private router: Router) {
  }

=======
export class AppComponent implements  OnInit{


  constructor(private router: Router) {}

>>>>>>> 455621431c2ea757562b5b4ad957f2da6593a5c0
  ngOnInit(): void {
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
<<<<<<< HEAD

=======
>>>>>>> 455621431c2ea757562b5b4ad957f2da6593a5c0
}

