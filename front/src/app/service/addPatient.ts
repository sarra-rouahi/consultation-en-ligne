import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Patient } from "../models/Patient";

@Injectable({
    providedIn: 'root'
  })
  export class addPatient{
    constructor(private http: HttpClient) { }
    ajouterPatient(personne: any): Observable<any> {
        return this.http.post("http://localhost:8080/ajouterPatient", personne);
      }
    
      afficherPatientAvecid(id: any): Observable<any> {
        return this.http.get("http://localhost:8080/affichePatientavecid/${id}" );
      }
     
      updatePatient(personne :any): Observable<any>
      {
        return this.http.put("http://localhost:8080/modifierpatient", personne);
      }
      afficherpa():Observable<any>{
        return this.http.get("http://localhost:8080/affichePatient");
      }
      supprimepatient(id: any):Observable<any>{
        return this.http.delete("http://localhost:8080/supprimepatient"+id);
      }

  }