import { Component } from '@angular/core';
import { addSecretary } from '../service/addSecretary';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registersec',
  templateUrl: './registersec.component.html',
  styleUrls: ['./registersec.component.css']
})
export class RegistersecComponent {
  constructor(private ps:addSecretary,private router:Router ){ }
  ajoutersec(form:any){
      this.ps.ajouterSecretary(form.value).subscribe({
        next: (data: any) => {
          console.log(data);
          this.router.navigate(['/home/homesec']);
          /*Swal.fire({
            icon: 'success',
            title: 'Yey...',
            text: 'Secretary Added!'
          });*/
        },
        error: () => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Something went wrong adding a secretary!'
          });
        }
      });
     
}
    
}
