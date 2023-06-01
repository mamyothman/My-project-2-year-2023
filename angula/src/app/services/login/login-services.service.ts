import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroment/enviroment';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoginServicesService {

  private login = environment.url + 'Account/';

  constructor(
    private http: HttpClient
   ) { }

    login_authentication(username:any,password:any):Observable<any>{
      return this.http.get(this.login + '/' + username + '/' + password);
    }

    user_registrations(data:any):Observable<any>{
      return this.http.post(this.login +'register',data);
    }

}
