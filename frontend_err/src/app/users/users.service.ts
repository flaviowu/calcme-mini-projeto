import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRequest } from './users.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private url = "http://localhost:8080/customers";

  constructor(private http: HttpClient) { }

  createUser(payload: UserRequest): Observable<void> {
    return this.http.post<void>(this.url, payload);
  }
}
