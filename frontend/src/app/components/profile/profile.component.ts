import { Component, OnInit } from '@angular/core';
import { GetDataService } from '../../services/get-data.service';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private getDataservice: GetDataService) { }
  userDetails;
  ngOnInit() {
    this.getDataservice.getUserDeatils(localStorage.getItem('username'))
    .subscribe(
      data => {
          this.userDetails = data;
      },
      error => { }
    )
  }

}
