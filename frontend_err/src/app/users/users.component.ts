import { Component, OnInit } from '@angular/core';
import { UserRequest } from './users.model';
import { UsersService } from './users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})

export class UsersComponent implements OnInit {

  payload: UserRequest = {
    name: "",
    email: "",
    phoneNumber: "",
  }

  constructor(private usersService: UsersService) { }

  ngOnInit(): void {
  }

  handleCreateUser() {
    this.usersService.createUser(this.payload).subscribe(res => {
      console.log(res);
    })
  }

}


