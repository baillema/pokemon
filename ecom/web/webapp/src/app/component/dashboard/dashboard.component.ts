import { Component, OnInit } from '@angular/core';
import {UserService} from '../../service/user/user.service';
import {User} from '../../model/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private isAdmin: boolean;
  private users: User[];
  private user: User;




  constructor(private userService: UserService) { }

  ngOnInit() {
    this.isAdmin = true;
    this.userService.getUsers().then(users => this.users = users );
  }

  onSubmit(): void {
    console.log(this.user);
  }
}
