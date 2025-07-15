import { Component, OnInit } from '@angular/core';
import { Press } from '../models/Press';
import { PresService } from '../service/PresService';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-up',
  templateUrl: './up.component.html',
  styleUrls: ['./up.component.css']
})
export class UpComponent implements OnInit {
  id: number | undefined;
  pres: Press = new Press();
  constructor(private medicineService: PresService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.medicineService. afficherrvpresAvecid(this.id).subscribe(data => {
      this.pres = data;
    } 
    , error => console.log(error));
  }

  onSubmit() {
    this.medicineService.modifierpres(this.pres).subscribe(data => { 
      this.goToMedicineList();
    } 
    , error => console.log(error));

  }

  goToMedicineList() {
    this.router.navigate(['/home/lp']);
  }
}
