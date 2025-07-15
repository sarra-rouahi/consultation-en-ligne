import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choice',
  templateUrl: './choice.component.html',
  styleUrls: ['./choice.component.css']
})
export class ChoiceComponent {
  constructor(private router:Router){}
  f1(){
    this.router.navigate(['home/comptep'])
  } 
  f2(){
    this.router.navigate(['home/compted'])
  } 
  f3(){
    this.router.navigate(['home/comptes'])
  }
}
