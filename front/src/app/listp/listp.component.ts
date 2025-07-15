import { Component, OnInit } from '@angular/core';
import { PresService } from '../service/PresService';
import { Router } from '@angular/router';
import { Press } from '../models/Press';

@Component({
  selector: 'app-listp',
  templateUrl: './listp.component.html',
  styleUrls: ['./listp.component.css']
})
export class ListpComponent implements OnInit {
  pres: Press[]=[];

  constructor(private medicineService: PresService,
    private router: Router) { }

  ngOnInit(): void {

    this.getMedicines();

  }

  private getMedicines(){
    this.medicineService.affichepress().subscribe(data => {this.pres = data;
    });

}

updateMedicine(id: number){

  this.router.navigate(['/home/up', id]);

}

deleteMedicine(id: number){
  this.medicineService.supprimepres(id).subscribe( data => { 
    console.log(data);
    this.getMedicines();
  })
}
}
