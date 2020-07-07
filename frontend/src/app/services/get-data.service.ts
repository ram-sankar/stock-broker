import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface MyShareResponse {  
  length: number;
}

interface responseStatus {  
  status:String;
}

@Injectable({
  providedIn: 'root'
})
export class GetDataService {

  baseUrl = "http://localhost:8080/";
  url="";
  constructor(private http : HttpClient) { }

  getAllCompany()
  {
      this.url = this.baseUrl + "get-all";
      return this.http.get(this.url);       
  }

  getWatchList(email)
  {
      this.url = this.baseUrl + "watch-list?email=" + email;
      return this.http.get<MyShareResponse>(this.url);       
  }

  getOneCompany(id)
  {
      this.url = this.baseUrl + "get-one?id=" + id;
      return this.http.get(this.url);       
  }

  getMyShares(email)
  {
    this.url = this.baseUrl + "my-share/?email=" + email;
    return this.http.get<MyShareResponse>(this.url);     
  }

  getUserDeatils(email)
  {
    this.url = this.baseUrl + "get-user/?email=" + email;
    return this.http.get<MyShareResponse>(this.url);     
  }
  
  addWatchList(email,id)
  {
    this.url = this.baseUrl + "add-watchlist/?email=" + email + "&id=" + id;
    return this.http.get<responseStatus>(this.url);     
  }

  removeWatchList(email,id)
  {
    this.url = this.baseUrl + "remove-watchlist/?email=" + email + "&id=" + id;
    return this.http.get<responseStatus>(this.url);     
  }

  buyShare(email,id,quantity)
  {
    this.url = this.baseUrl + "buy";
    return this.http.post<responseStatus>(this.url, { "email":email, "companyId":id, "quantity":quantity} );               
  }

  sellShare(email,id,quantity)
  {
    this.url = this.baseUrl + "sell";
    return this.http.post<responseStatus>(this.url, { "email":email, "companyId":id, "quantity":quantity} );               
  }
}
