import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetDataService } from '../../services/get-data.service';

@Component({
  selector: 'app-my-shares',
  templateUrl: './my-shares.component.html',
  styleUrls: ['./my-shares.component.css']
})
export class MySharesComponent implements OnInit {

  constructor(private router: Router,private getDataservice: GetDataService) { }
  myShares;
  ngOnInit() {
    this.getDataservice.getMyShares(localStorage.getItem('username'))
    .subscribe(
      data => {
        if(data.length)
          this.myShares = data;
      },
      error => {
          console.log(error)
      }
    )
  }
  goToSellPage(companyId)
  {
    this.router.navigate(['sell',companyId])
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
