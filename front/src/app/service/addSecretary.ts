import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class addSecretary{
    constructor(private http: HttpClient) { }
    ajouterSecretary(personne: any): Observable<any> {
        return this.http.post("http://localhost:8080/ajouterSecretary", personne);
      }
    
      afficherSecretaryAvecid(id: any): Observable<any> {
        return this.http.get("http://localhost:8080/afficheSecretaryavecid?id=" + id);
      }
  }