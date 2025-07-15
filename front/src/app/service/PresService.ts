import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Press } from '../models/Press';

@Injectable({
  providedIn: 'root'
})
export class PresService {

  
  constructor(private httpClient: HttpClient) { }

    affichepress(): Observable<any> {
        return this.httpClient.get("http://localhost:8080/affichePres");
      }
    
      afficherrvpresAvecid(id: any): Observable<any> {
        return this.httpClient.get("http://localhost:8080/affichePresavecid/" + id);
  }
  ajouterpres(p:Press):Observable<any>{
    return this.httpClient.post("http://localhost:8080/ajouterPres",p);
  }
supprimepres(id: any):Observable<any>{
    return this.httpClient.delete("http://localhost:8080/supprimePres/"+id);
  }
  modifierpres(p:Press):Observable<any>{
    return this.httpClient.put("/http://localhost:8080/modifierPres",p);
  }
}