import { user_info } from './../../model/User_Info';
import { Component, TemplateRef, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { image } from 'src/app/model/image';
import { ImageServicesService } from 'src/app/services/image/image-services.service';
import { UserInfoService } from 'src/app/services/user_info/user-info.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
imageData!: FormData;
username!:any
check_login:boolean = true;
error:boolean = false;
image_model:image = new image()

constructor(
  private user_services:UserInfoService,
  private dialog: MatDialog,
  private image_services:ImageServicesService,
  private route:Router){}

// user_info:user_info = new user_info();
data!:any
user_info: user_info= new user_info()


@ViewChild('updateuser') updateuser!: TemplateRef<any>;
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

      // this.getAllFiles()
  }

// add user
  createUser(data:any){
    return this.user_services.createUser_Info(data).subscribe(respo=>{
      console.log(respo)

      this.dialog.closeAll();
      this.getAll_User();
      // window.alert("User inserted")
    })
  }
  // get all user
  getAll_User(){
    return this.user_services.getUser_Info().subscribe(respo=>{
      this.data = respo;
      this.user_info = this.data
      console.log(this.user_info)

    })
  }

  // update User
  update_User(user_id:any,data:any){
    return this.user_services.updateUser_Info(user_id,data).subscribe(respo=>{
      console.log(respo)
      this.dialog.closeAll();
      this.getAll_User();
    })
  }

  // delete user
delete(data:any){
 this.user_info = data
return this.user_services.deleteUser_Info(this.user_info.user_id).subscribe(respo=>{
  window.alert("User Already Deleted")
  this.getAll_User()
})
}
// open dialog for edit user
openDialog(data:any): void {
  this.dialog.open(this.updateuser,{width:'400px'});
  this.user_info = data;
  console.log(this.user_info )

}

// open dialog for add user
openDialogAddUser():void{

    this.dialog.open(this.adduser,{width:'400px'});
}

// update button submition
UpdateUser(){

  this.update_User(this.user_info.user_id,this.user_info);

  // console.log(this.user_info.user_id,data)

}

// add button submition
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

    // console.log(data)
}

// logout button
logout(){
  sessionStorage.removeItem("username")
  this.route.navigate(['/nav-bar'])
}
// onFileChange(event: any) {
//   if (event.target.files && event.target.files.length > 0) {
//     const file = event.target.files[0];
//     this.image_model.filename = file.name;
//     this.imageData = new FormData();
//     this.imageData.append('file', file);
//   }
// }
// selectedFile!: File;
// onFileSelected(event: any) {
//   this.selectedFile = event.target.files[0];
// }

// upload(file:File){
//   return this.image_services.uploadFile(file).subscribe(respo=>{
//     // console.log(respo)
//     const data = {
//       "url" : respo.message
//     }
//     console.log(data)

//     this.getAllFiles();
//   })
// }

// uploadFile() {
//   if (this.selectedFile) {
//     // console.log('Selected file:', this.selectedFile,id);
//       this.upload(this.selectedFile)
//   } else {
//     console.log('No file selected.');
//   }
// }
// files!: any[];
// filteredFiles: any[] = [];

// getAllFiles() {
//   this.image_services.getAllFiles().subscribe(
//     (response) => {
//       this.files = response;
//        // Filter files with id equal to 123
//        this.filteredFiles = this.files.filter(file => file.id === 1);

//        console.log(this.filteredFiles);
//     },
//     (error) => {
//       console.error('Error retrieving files:', error);
//     }
//   );
// }
}
