import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class addDoctor{
    constructor(private http: HttpClient) { }
    ajouterDoctor(personne: any): Observable<any> {
        return this.http.post("http://localhost:8080/ajouterDoctor", personne);
      }
    
      afficherDoctorAvecid(id: any): Observable<any> {
        return this.http.get("http://localhost:8080/afficheDoctoravecid?id=" + id);
      }
  }