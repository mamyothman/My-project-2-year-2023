import { Component } from '@angular/core';
import { login } from 'src/app/model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
loginModel:login = new login();

register(){
console.log(this.loginModel)
}

}
