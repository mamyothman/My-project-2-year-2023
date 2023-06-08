import { user_info } from './../../model/User_Info';
import { Component, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserInfoService } from 'src/app/services/user_info/user-info.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
username!:any
check_login:boolean = true;
error:boolean = false;
constructor(private user_services:UserInfoService,private dialog: MatDialog,private route:Router){}
// user_info:user_info = new user_info();
data!:any
user_info: user_info= new user_info()
@ViewChild('sayHelloTemplate') sayHelloTemplate!: TemplateRef<any>;
@ViewChild('adduser') adduser!: TemplateRef<any>;
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
      this.getAll_User();
      this.username = sessionStorage.getItem("username");
      if(this.username==null){
        this.check_login = false
        this.error = true
      }
  }


  createUser(data:any){
    return this.user_services.createUser_Info(data).subscribe(respo=>{
      console.log(respo)

      this.dialog.closeAll();
      // window.alert("User inserted")
    })
  }
  getAll_User(){
    return this.user_services.getUser_Info().subscribe(respo=>{
      this.data = respo;
      this.user_info = this.data
      console.log(this.user_info)

    })
  }

  update_User(user_id:any,data:any){
    return this.user_services.updateUser_Info(user_id,data).subscribe(respo=>{
      console.log(respo)
      this.dialog.closeAll();
    })
  }

delete(data:any){
 this.user_info = data
return this.user_services.deleteUser_Info(this.user_info.user_id).subscribe(respo=>{
  window.alert("User Already Deleted")
  this.getAll_User()
})
}
openDialog(data:any): void {
  this.dialog.open(this.sayHelloTemplate,{width:'400px'});
  this.user_info = data;

}
openDialogAddUser():void{

    this.dialog.open(this.adduser,{width:'400px'});
}


UpdateUser(){

  this.update_User(this.user_info.user_id,this.user_info);
  // console.log(this.user_info.user_id,data)

}

AddUser(){
const data = {
  "user_id":0,
  "first_name":this.user_info.first_name,
  "second_name":this.user_info.second_name,
  "lastname":this.user_info.lastname,
  "phone":this.user_info.phone,
  "address":this.user_info.address,
}
this.createUser(data);
this.getAll_User();
// console.log(data)
}

logout(){
  sessionStorage.removeItem("username")
  this.route.navigate(['/nav-bar'])


}
}
