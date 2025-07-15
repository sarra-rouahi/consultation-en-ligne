import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Appointment } from '../models/Appointment';
import { AddApp } from '../service/addApp';
import { Press } from '../models/Press';
import { PresService } from '../service/PresService';

@Component({
  selector: 'app-homesec',
  templateUrl: './homesec.component.html',
  styleUrls: ['./homesec.component.css']
})

export class HomesecComponent implements OnInit {
  appointments: Appointment[];
  medicines:Press[]=[];
  constructor(private appointmentService: AddApp,private ps:PresService,
    private router: Router) { this.appointments=[] }

  ngOnInit(): void {

    this.getAppointments();
    this.getpress();
  }

  private getAppointments() {
    this.appointmentService.afficherendezvous().subscribe((data:any) => {this.appointments = data;
      });
  }
  getpress(){
    this.ps.affichepress().subscribe((data:any)=>{this.medicines=data;})
  }
 deletept(id:number){
  this.ps.supprimepres(id).subscribe((data:any)=>{console.log(data);
    this.getpress();
  })
 }
  deleteAppointment(id: number){ 
    this.appointmentService.supprimerendezvous(id).subscribe( (data:any) => { 
      console.log(data);
      this.getAppointments();
    })

  
  }
  requestedAppointments: any[] = [];
  loadRequestedAppointments() {
    this.appointmentService.getRequestedAppointments().subscribe(appointments => {
      this.requestedAppointments = appointments;
    });
  }

  acceptAppointment(id: number) {
    this.appointmentService.acceptAppointment(id).subscribe(() => {
      this.loadRequestedAppointments();
    });
    console.log("accepted");
    this.getAppointments();
  }
  
 
}