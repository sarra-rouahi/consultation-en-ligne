import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { addDoctor } from '../service/addDoctor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-regisd',
  templateUrl: './regisd.component.html',
  styleUrls: ['./regisd.component.css']
})
export class RegisdComponent {
  constructor(private pd:addDoctor,private router:Router ){ }

  ajouterpersonne(form:any){
    this.pd.ajouterDoctor(form.value).subscribe({
      next: (data: any) => {
        console.log(data);
        
       /* Swal.fire({
          icon: 'success',
          title: 'Yey...',
          text: 'Doctor Added!'
        });*/
        this.router.navigate(['/home/homedoc']);
      },
      error: () => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Something went wrong adding a patient!'
        });
        console.log(Error);
      }
    });
}}
