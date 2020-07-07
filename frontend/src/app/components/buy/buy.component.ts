import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { GetDataService } from '../../services/get-data.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {

  companyId = '';
  quantity = '';
  companyDetails;
  constructor(private router: Router, 
              private getDataservice: GetDataService, 
              private _Activatedroute:ActivatedRoute,
              private toastr: ToastrService) {   }

  ngOnInit() {
    this._Activatedroute.paramMap.subscribe(params => { 
      this.companyId = params.get('id'); 
      });

      this.getDataservice.getOneCompany(this.companyId)
      .subscribe(
        data => {
            this.companyDetails = data;
        },
        error => {
            console.log(error)
        }
      )
  }

  buyItem() 
  {
    this.getDataservice.buyShare( localStorage.getItem('username'), this.companyId, this.quantity)
      .subscribe(
        data => {console.log(data)
          if(data.status=="success")
            this.router.navigate(['my-shares'])          
          else if(data.status=="insufficient balance")
            this.toastr.error("",'Insufficient balance in your account',{positionClass:"toast-bottom-center"});
        },
        error => {
            console.log(error)
        }
      )
  }
  checkQuantity(qty)
  {
    if(isNaN(Number(qty.value)) || Number(qty.value) === 0)
      return false;
    else
      return true;
  }
}

