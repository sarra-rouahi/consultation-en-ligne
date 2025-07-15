import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-des',
  templateUrl: './des.component.html',
  styleUrls: ['./des.component.css']
})
export class DesComponent {
  constructor(private router:Router){}
  f1(){
    this.router.navigate(['home/choix'])
  }
}
