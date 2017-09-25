import {Injectable} from '@angular/core';
import {USERS} from '../mocks/mock-users';
import {User} from '../../model/user';

@Injectable()
export class UserService {


  constructor() {
  }

  getUsers(): Promise<User[]> {
    return Promise.resolve(USERS);
  }


}
