import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { addPatient } from '../service/addPatient';
import { Patient } from '../models/Patient';
import { AddApp } from '../service/addApp';

@Component({
  selector: 'app-viewp',
  templateUrl: './viewp.component.html',
  styleUrls: ['./viewp.component.css']
})
export class ViewpComponent implements OnInit {

  id: number | undefined;
  patient: Patient = new Patient();
  appointments: any[] = [];
  constructor(private route: ActivatedRoute, private patientService: addPatient,private appointmentService:AddApp) { }

  ngOnInit(): void {
    // Extract the patient ID from the route parameters
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.id);
    if (!isNaN(this.id) && this.id > 0) {
      console.log("Fetching patient data for ID:", this.id);

      // Fetch patient data by ID
      this.patientService.afficherPatientAvecid(this.id).subscribe(
        data => {
          this.patient = data;
          console.log('Patient data fetched successfully', this.patient);
        },
        error => {
          console.error('Error fetching patient data', error);
        }
      );
    } else {
      console.error('Invalid or undefined patient ID:', this.id);
    }
  }
  loadAppointments() {
    console.log(this.id);
    this.appointmentService.afficherrvAvecid(this.id).subscribe(appointments => {
      this.appointments = appointments;
    });
  }
  
  
}
