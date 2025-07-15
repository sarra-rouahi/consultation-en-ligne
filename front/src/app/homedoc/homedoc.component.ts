import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../models/Patient';
import { addPatient } from '../service/addPatient';
import { AddApp } from '../service/addApp';

@Component({
  selector: 'app-homedoc',
  templateUrl: './homedoc.component.html',
  styleUrls: ['./homedoc.component.css']
})
export class HomedocComponent {
  searchText: string | undefined;
  patients: Patient[] | undefined; 

  constructor(private patientService: addPatient,private appointmentService:AddApp,
    private router: Router) { }
    acceptedAppointments: any[] = [];
  ngOnInit(): void {
    this.getPatients();
    this.loadAcceptedAppointments();
    
  }
  
  private getPatients(){
    this.patientService.afficherpa().subscribe((data: Patient[] | undefined) => { this.patients = data; 
    });
  }
  loadAcceptedAppointments() {
    this.appointmentService.getAcceptedAppointments().subscribe(appointments => {
      this.acceptedAppointments = appointments;
    });
  }

  completeAppointment(id: number) {
    this.appointmentService.completeAppointment(id).subscribe(() => {
      this.loadAcceptedAppointments();
    });
  }
  viewPatient(id:number) {

    this.router.navigate(['home/viewp',id]);

  }
  updatePatient(id: number) {

    this.router.navigate(['home/updatep', id]);

  }

  deletePatient(id: number) {
    this.patientService.supprimepatient(id).subscribe((data: any) => {
      console.log(data);
      this.getPatients();
    } ); 
  }
f1(){
  this.router.navigate(['home/comptep']);
}
f2(){
  this.router.navigate(['home/cp']);
}
f3(){
  this.router.navigate(['home/lp']);
}
f4(){
  this.router.navigate(['home/up']);
}
}
