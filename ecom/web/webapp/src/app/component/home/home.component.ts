import { Component, OnInit } from '@angular/core';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor() { }

  toggleBlock(){
    const toggleBlock = document.getElementsByClassName('toggle-block');
    console.log(toggleBlock);
  }
}
