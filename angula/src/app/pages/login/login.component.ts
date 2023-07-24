import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { login } from 'src/app/model/login';
import { LoginServicesService } from 'src/app/services/login/login-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  login_model: login = new login();

  constructor(private login_services:LoginServicesService,private route:Router){}



  login_process(username:any,password:any){
    return this.login_services.login_authentication(username,password).subscribe(
      respo=>{
        console.log(respo)
        sessionStorage.setItem("username",respo.username)
        if(respo.roles=="user"){
          this.route.navigate(['/home/'])
        }else{
          alert("error")
        }
      }
    )
  }

  login(){
      this.login_process(this.login_model.username,this.login_model.password)
      // console.log(this.login_model);
  }

}
