import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  
  constructor(private http: HttpClient) { }

  /*authenticate(email: string, password: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/signin`, { email, password })
      .pipe(
        map(response => {
          // Assuming the response contains a token
          if (response && response.token) {
            sessionStorage.setItem('token', response.token);
            sessionStorage.setItem('email', email);
          }
          return response;
        }),
        catchError(this.handleError)
      );
  }

  isUserLoggedIn(): boolean {
    return !!sessionStorage.getItem('token');
  }

  logOut(): void {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('email');
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }*/
 
  private loginUrl = 'http://localhost:8080/signin'; 

  

  authenticate(email: string, password: string): Observable<any> {
    return this.http.post(this.loginUrl, { email, password });
  }

  isUserLoggedIn(): boolean {
    const user = sessionStorage.getItem('email');
    return !!user;
  }

  logOut(): void {
    sessionStorage.removeItem('email');
  }
  
   
  }



