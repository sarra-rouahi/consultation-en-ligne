import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Appointment } from "../models/Appointment";

@Injectable({
    providedIn: 'root'
  })
  export class AddApp{
  
    constructor(private http: HttpClient) { }
    afficherendezvous(): Observable<any> {
        return this.http.get("http://localhost:8080/afficheAppointment");
      }
    
      afficherrvAvecid(id: any): Observable<any> {
        return this.http.get("http://localhost:8080/afficheAppointmentavecdate/" + id);
  }
  ajouterrendezvous(rv:Appointment):Observable<any>{
    return this.http.post("http://localhost:8080/ajouterAppointment",rv);
  }
supprimerendezvous(id: any):Observable<any>{
    return this.http.delete("http://localhost:8080/supprimedoAppointment/"+id);
  }
  modifierendezvoys(rv:Appointment):Observable<any>{
    return this.http.put("/http://localhost:8080//modifierappointment",rv);
  }
  requestAppointment(appointment: any): Observable<any> {
    return this.http.post(`http://localhost:8080/request`, appointment);
  }

  getRequestedAppointments(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/requested`);
  }

  acceptAppointment(id: number): Observable<any> {
    return this.http.post(`http://localhost:8080/accept/${id}`, {});
  }
  getAcceptedAppointments(): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/accepted`);
  }
  completeAppointment(id: number): Observable<Object> {
    return this.http.delete(`http://localhost:8080/complete/${id}`);
  }
}