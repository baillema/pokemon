import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokemons-list',
  templateUrl: './pokemons-list.component.html',
  styleUrls: ['./pokemons-list.component.css']
})
export class PokemonsListComponent implements OnInit {

  public  pokemons = [
    {
      "id": "59ca6b4dc5f47cfd5261db2e",
      "picture": "168.png",
      "nickname": "Acosta",
      "description": "Eu ipsum sit ea non exercitation deserunt veniam duis laboris amet labore aute. Ad aliquip nostrud enim esse magna nostrud non reprehenderit sit consectetur incididunt ad nostrud elit. Velit incididunt deserunt velit ullamco. Excepteur sint ipsum esse exercitation deserunt id aliquip incididunt irure ullamco esse. Aute ea tempor dolor tempor laboris. Esse sint aute laborum ipsum fugiat fugiat aute minim sit commodo enim labore adipisicing. Minim velit ipsum culpa exercitation incididunt.\r\n",
      "shininess": true,
      "price": 157
    },
    {
      "id": "59ca6b4d19267abc2597bb5a",
      "picture": "201.png",
      "nickname": "Kay",
      "description": "Sit adipisicing cupidatat veniam est nulla adipisicing tempor. Et officia cillum excepteur labore ea in Lorem labore. Pariatur exercitation veniam exercitation veniam exercitation ut do eiusmod elit. Cillum ullamco non id non reprehenderit eiusmod id consequat ipsum. Eiusmod cupidatat id laboris nostrud nisi aute cupidatat ad qui nulla magna sint labore occaecat.\r\n",
      "shininess": true,
      "price": 231
    },
    {
      "id": "59ca6b4ddcfa0eb294aa455c",
      "picture": "120.png",
      "nickname": "Reeves",
      "description": "Pariatur ex ea laboris dolor culpa reprehenderit ad voluptate minim. Ea Lorem adipisicing dolore anim sit deserunt non et pariatur ea. Commodo amet ad fugiat consequat elit aliqua dolore sit. Voluptate eiusmod officia labore cupidatat culpa proident. Pariatur ullamco amet aliquip voluptate veniam.\r\n",
      "shininess": false,
      "price": 200
    },
    {
      "id": "59ca6b4da70976f1d852d359",
      "picture": "31.png",
      "nickname": "Madge",
      "description": "Tempor cupidatat pariatur nostrud labore ad eu reprehenderit elit voluptate incididunt cillum. Eiusmod labore cillum sunt deserunt est ullamco anim labore. Duis reprehenderit est excepteur elit id nulla non adipisicing aute cillum in.\r\n",
      "shininess": false,
      "price": 315
    },
    {
      "id": "59ca6b4d49a6b9dedca19f42",
      "picture": "131.png",
      "nickname": "Koch",
      "description": "Non dolor deserunt voluptate ullamco ad officia irure id occaecat ea. Culpa occaecat anim tempor labore veniam minim minim adipisicing. Do sit minim voluptate do duis sint exercitation tempor excepteur reprehenderit. Velit nulla Lorem veniam excepteur ipsum deserunt. Fugiat ullamco dolor aliqua duis adipisicing nisi fugiat. Nisi laborum reprehenderit eu reprehenderit ad proident dolor officia veniam fugiat velit reprehenderit labore velit.\r\n",
      "shininess": true,
      "price": 40
    },
    {
      "id": "59ca6b4dcb6550c38513db29",
      "picture": "321.png",
      "nickname": "Jefferson",
      "description": "Proident duis qui dolore Lorem laboris voluptate nulla nulla ipsum. Velit eu irure laboris do labore occaecat consequat est. Ullamco incididunt exercitation veniam duis voluptate consequat ea elit tempor amet. Tempor elit mollit cupidatat elit minim dolore occaecat fugiat ipsum ullamco officia. Mollit deserunt sint ullamco occaecat enim nulla aute amet deserunt elit ad.\r\n",
      "shininess": false,
      "price": 352
    }
  ];


  constructor() { }

  ngOnInit() {
  }

}
