import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { PersonneService } from '../service/personne.service';
import { addDoctor } from '../service/addDoctor';


import { Router } from '@angular/router';
import { addPatient } from '../service/addPatient';
import { addSecretary } from '../service/addSecretary';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private ps:addPatient,private router:Router ){ }
  ajouterpersonne(form:any){
      this.ps.ajouterPatient(form.value).subscribe({
        next: (data: any) => {
          console.log(data);
          this.router.navigate(['/home/homep']);
          /*Swal.fire({
            icon: 'success',
            title: 'Yey...',
            text: 'Patient Added!'
          });*/
        },
        error: () => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong adding a patient!'
          });
        }
      });
     
}
    
    }


