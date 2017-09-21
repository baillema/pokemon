import {Component, OnInit} from '@angular/core';

declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-profils',
  templateUrl: './profils.component.html',
  styleUrls: ['./profils.component.css']
})
export class ProfilsComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

  showPane(e: string) {
    $('.list-group-item.active').removeClass('active');
    $('#' + e + 'Item').addClass('active');
    $('.tab-pane.active').removeClass('active');
    $('#' + e).addClass('active');
  }

  toggleItemsGrid() {
    const grid = $('#itemGrid');
    if (grid.hasClass('grid')) {
      grid.removeClass('grid').addClass('line');
      grid.find('.col-md-4').each(() => $(this).removeClass('col-md-4').addClass('col-md-12'));
    } else if (grid.hasClass('line')) {
      grid.removeClass('line').addClass('grid');
      grid.find('.col-md-12').each(() => $(this).removeClass('col-md-12').addClass('col-md-4'));
    }
  }
}
