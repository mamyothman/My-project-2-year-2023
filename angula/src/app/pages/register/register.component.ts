import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { login } from 'src/app/model/login';
import { LoginServicesService } from 'src/app/services/login/login-services.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  loginModel:login = new login();

  constructor(private loginServices:LoginServicesService,private router:Router){}
  register() {
    this.loginModel.roles = "user";
    this.loginModel.status = 1;

    // Checking if the password and confirm password match
    if (this.loginModel.confirmPassword != this.loginModel.password) {
      // Displaying an error message with SweetAlert
      Swal.fire({
        title: 'Error',
        text: 'Password does not match',
        icon: 'error'
      });

      // Terminating the function execution
      return;
    }

    // Displaying a SweetAlert loading spinner while the registration is in progress
    Swal.fire({
      title: 'Registering',
      text: 'Please wait...',
      icon: 'info',
      allowOutsideClick: false,
      showConfirmButton: false,
      willOpen: () => {
        Swal.showLoading();
      }
    });

    // Making the user registration API call
    this.loginServices.user_registrations(this.loginModel).subscribe(response => {
      console.log(response);

      // Hiding the SweetAlert loading spinner
      Swal.close();

      // Checking the response status code
      if (response.status === 404) {
        // Displaying an error message with SweetAlert when the user already exists
        Swal.fire({
          title: 'Error',
          text: 'User already exists',
          icon: 'error'
        });
      } else {
        // Displaying a success message with SweetAlert
        Swal.fire({
          title: 'Registration Successful',
          text: 'You have been registered as an admin',
          icon: 'success'
        }).then(() => {
          // Redirecting to the login page after the registration is successful
          this.router.navigate(['//nav-bar/login']);
        });
      }
    }, error => {
      console.log(error);

      // Hiding the SweetAlert loading spinner
      Swal.close();

      // Displaying an error message with SweetAlert for any other error
      Swal.fire({
        title: 'Error',
        text: 'User already exists',
        icon: 'error'
      });
    });
  }
}
