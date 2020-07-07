import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface UserResponse {  
  status: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService 
{
    baseUrl = "http://localhost:8080/";
    url="";
    constructor(private http : HttpClient) { }

    addNewUser(email, username, phone, password)
    {
        this.url = this.baseUrl + "register";
        return this.http.post(this.url, { "email":email, "name":username, "phone":phone, "password":password} );        
    }

    authenticate(mailid, password) 
    {    
        this.url = this.baseUrl + "signin";
        return this.http.post<UserResponse>(this.url, { "email":mailid,"password":password} );       
        //return this.http.post<UserResponse>(this.url, { "username":mailid,"password":password} );        
    }

    isUserLoggedIn() {
      let user = localStorage.getItem('username');
      return !(user === null)
    }

    logOut() {
      localStorage.removeItem('username')
    }
 
}
