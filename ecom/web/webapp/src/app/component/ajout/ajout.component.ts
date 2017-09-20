import { Component, OnInit } from '@angular/core';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-ajout',
  templateUrl: './ajout.component.html',
  styleUrls: ['./ajout.component.css']
})
export class AjoutComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  showPane(e: string){
    $('.list-group-item.active').removeClass('active');
    $('#' + e + 'Item').addClass('active');
    $('.tab-pane.active').removeClass('active');
    $('#' + e).addClass('active');
  }
}
