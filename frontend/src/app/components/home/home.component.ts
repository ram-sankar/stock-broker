import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetDataService } from '../../services/get-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  companyDetails;
  constructor(private router: Router,private getDataservice: GetDataService) { }

  ngOnInit() {
    this.getDataservice.getAllCompany()
    .subscribe(
      data => {
          this.companyDetails = data;
      },
      error => {
          console.log(error)
      }
    )
  }

  addToWatchlist(companyId)
  {
    this.getDataservice.addWatchList(sessionStorage.getItem('username'),companyId)
    .subscribe(
      data => {
          console.log(data);
      },
      error => {
          console.log(error)
      }
    )
  }

  goToBuyPage(companyId)
  {    
    this.router.navigate(['buy',companyId])
  }
  goToDetailedView(companyId)
  {    
    this.router.navigate(['view',companyId])
  }
}
