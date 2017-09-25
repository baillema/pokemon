///<reference path="../../../../node_modules/@angular/core/src/metadata/lifecycle_hooks.d.ts"/>
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})

export class ItemsComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  checkSelected(id: string) {
    const checkbox = $('#' + id);
    const label = $(`label[for="` + id + `"]`);
    if (checkbox.is(':checked') === false) {
      label.find('img').addClass('selected');
    } else {
      label.find('img').removeClass('selected');
    }
  }

  toggleItemsGrid() {
    const grid = $('#itemGrid');
    if (grid.hasClass('grid')) {
      grid.removeClass('grid').addClass('line');
      grid.find('.col-md-4').each(function(){
        $(this).removeClass('col-md-4').addClass('col-md-12');
      });
    } else if (grid.hasClass('line')) {
        grid.removeClass('line').addClass('grid');
        grid.find('.col-md-12').each(function(){
          $(this).removeClass('col-md-12').addClass('col-md-4');
        });
    }
  }

}
