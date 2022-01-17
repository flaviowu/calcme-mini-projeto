import { Component, OnInit } from '@angular/core';
import { Request } from './customer.model';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.scss'],
})
export class CustomerFormComponent implements OnInit {
  payload: Request = {
    name: '',
    email: '',
    phoneNumber: '',
  };

  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {}

  handleCreateCustomer() {
    this.customerService.createCustomer(this.payload).subscribe((res) => {
      console.log(res);
    });
  }
}
