import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor() { }

  toggleBlock() {
    const toggleBlock = document.getElementsByClassName('toggle-block');
    for (let i = 0; i < toggleBlock.length; i++) {
      toggleBlock[i].classList.toggle('closed');
    }
  }
}
