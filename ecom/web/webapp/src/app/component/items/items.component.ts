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

}
