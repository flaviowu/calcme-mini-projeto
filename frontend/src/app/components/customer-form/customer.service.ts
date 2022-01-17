import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './customer.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private url = "http://localhost:8080/customers";

  constructor(private http: HttpClient) { }

  createCustomer(payload: Request): Observable<void> {
    return this.http.post<void>(this.url, payload);
  }
}