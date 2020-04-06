import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetDataService } from '../../services/get-data.service';

@Component({
  selector: 'app-watch-list',
  templateUrl: './watch-list.component.html',
  styleUrls: ['./watch-list.component.css']
})
export class WatchListComponent implements OnInit {

  constructor(private router: Router,private getDataservice: GetDataService) { }
  watchList;
  ngOnInit() {
    this.loadData();
  }  
  loadData()
  {
    this.getDataservice.getWatchList(sessionStorage.getItem('username'))
    .subscribe(
      data => {
          this.watchList = data;
      },
      error => {
          console.log(error)
      }
    )
  }
  removeFromWatchlist(companyId)
  {
    this.getDataservice.removeWatchList(sessionStorage.getItem('username'),companyId)
      .subscribe(
        data => {
            if(data.status=="success")
              this.loadData();
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
