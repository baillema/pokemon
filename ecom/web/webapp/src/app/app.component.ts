import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
})

export class AppComponent implements  OnInit{


  constructor(private router: Router) {}

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
}

