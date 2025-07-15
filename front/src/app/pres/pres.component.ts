import { Component, OnInit } from '@angular/core';
import { Press } from '../models/Press';
import { PresService } from '../service/PresService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pres',
  templateUrl: './pres.component.html',
  styleUrls: ['./pres.component.css']
})
export class PresComponent implements OnInit {
  pres: Press = new Press();
  constructor(private presService: PresService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMedicine() {
    this.presService.ajouterpres(this.pres).subscribe(data => {
      console.log(data);
      this.goTopresList();
    }, 
    error => console.log(error));
  }

  goTopresList() {

    this.router.navigate(['/home/homedoc']);

  }

  onSubmit() {
    
    console.log(this.pres);
    this.saveMedicine();
  }
}
