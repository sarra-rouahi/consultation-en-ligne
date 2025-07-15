import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/AuthentificationService'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string="";
  password: string="";
  errorMessage: string="";
  role: string="";
  constructor(private authService: AuthenticationService, private router: Router) {}

  // Method to handle login on button click
  login() {
    // Debug logs to check email and password values
    console.log('Email:', this.email);
    console.log('Password:', this.password);
    console.log('Password:', this.role);

    // Check if both email and password are provided
    if (this.email && this.password) {
      // Authenticate the user using the authService
      this.authService.authenticate(this.email, this.password).subscribe({
        // Handle successful response
        next: (response: any) => {
          if (response) {
            console.log(response);

            // Store email in session storage
            sessionStorage.setItem('email', this.email);
            // Navigate to different home routes based on the role
            const role = response.role;
            console.log('le');
            console.log(`Role: ${role}`); // Debug log for role
            switch (role) {
              case 'secretary':
                console.log('Navigating to /home/homesec');
                this.router.navigate(['home/homesec']);
                break;
              case 'doctor':
                console.log('Navigating to /home/homedoc');
                this.router.navigate(['home/homedoc']);
                break;
              default:
                console.log('Navigating to /home/homep');
                this.router.navigate(['home/homep']);
                break;
            }
          } else {
            // Set error message for invalid credentials
            this.errorMessage = 'Invalid email or password';
            this.router.navigate(['home/description']);
          }
        },
        // Handle error during the authentication process
        error: (error) => {
          this.errorMessage = 'Error during login: ' + error.message;
        },
        // Log completion of the login request
        complete: () => {
          console.log('Login request completed');
        }
      });
    } else {
      // Prompt user to fill in both email and password
      this.errorMessage = 'Please fill in both email and password';
    }
  }
}
