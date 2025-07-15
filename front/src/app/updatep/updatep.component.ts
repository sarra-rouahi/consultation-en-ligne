import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../models/Patient';
import { addPatient } from '../service/addPatient';

@Component({
  selector: 'app-updatep',
  templateUrl: './updatep.component.html',
  styleUrls: ['./updatep.component.css']
})
export class UpdatepComponent implements OnInit {
  patient: Patient = new Patient();
  id: any;
  errorMessage: string="";

  constructor(
    private patientService: addPatient,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Retrieve the user from sessionStorage
    const userString = sessionStorage.getItem('currentUser');
    
    // Check if userString is not null before parsing
    if (userString) {
      const user = JSON.parse(userString);
      if (user && user.id) {
        const userId = user.id;
        this.patientService.afficherPatientAvecid(userId).subscribe(
          data => {
            this.patient = data;
          },
          error => {
            console.log(error);
            this.errorMessage = 'Error fetching patient data';
          }
        );
      } else {
        this.errorMessage = 'User ID is not defined in session';
      }
    } else {
      this.errorMessage = 'User is not defined in session';
    }
  }

  onSubmit() {
    this.patientService.updatePatient(this.patient).subscribe(
      data => {
        this.goToPatientlist();
      },
      error => {
        console.log(error);
        this.errorMessage = 'Error updating patient';
      }
    );
  }

  goToPatientlist() {
    this.router.navigate(['home/homedoc']);
  }
}
