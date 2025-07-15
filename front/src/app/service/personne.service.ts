import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {
  

  constructor(private http: HttpClient) { }

  ajouterpersonne(personne: any): Observable<any> {
    return this.http.post("http://localhost:8080/ajouterUser", personne);
  }

  consulterpersonneavecid(id: any): Observable<any> {
    return this.http.get("http://localhost:8080/afficheUseravecid/" + id);
  }

  signin(value: any): Observable<any> {
    return this.http.post("http://localhost:8080/signin", value, { responseType: 'text' });
}

}
