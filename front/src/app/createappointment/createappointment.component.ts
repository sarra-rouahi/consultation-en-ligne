import { Component, OnInit } from '@angular/core';
import { AddApp } from '../service/addApp';
import { Router } from '@angular/router';
import { Appointment } from '../models/Appointment';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-createappointment',
  templateUrl: './createappointment.component.html',
  styleUrls: ['./createappointment.component.css']
})
export class CreateappointmentComponent implements OnInit {
  ngOnInit(): void {
  }
  appointment: Appointment = new Appointment();
  constructor(private appointmentService: AddApp,
    private router: Router) {  }
   /* requestAppointment() {
      this.appointmentService.requestAppointment(this.appointment).subscribe(response => {
        console.log('Rendez-vous demandé:', response);
      });
    }*/
  requestAppointment() {

    this.appointmentService.ajouterrendezvous(this.appointment).subscribe((data:any) => {
      console.log(data);
      this.goToAppointmentList();
      Swal.fire({
        icon: 'success',
        title: 'Yey...',
        text: 'Appointment Added!'
      });
    },
    (error:any)=> {console.log(error);
      Swal.fire({
        icon:'error',
        title:'oops...',
        text:'Please choose another date or time'
      })
      });
  }

  goToAppointmentList() {
    this.router.navigate(['/appointmentlist'])
  }

  /*onSubmit() {
    console.log(this.appointment);
    this.saveAppointment();
  }*/

}
