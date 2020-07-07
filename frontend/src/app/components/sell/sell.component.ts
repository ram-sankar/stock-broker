import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { GetDataService } from '../../services/get-data.service';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {

  quantity = '';
  companyDetails;
  companyId;
  constructor(private router: Router, private getDataservice: GetDataService, private _Activatedroute:ActivatedRoute) {   }


  ngOnInit() {
    this._Activatedroute.paramMap.subscribe(params => { 
      this.companyId = params.get('id'); 
      });

      this.getDataservice.getMyShares(localStorage.getItem('username'))
      .subscribe(
        data => {
            for(let i=0;i<data.length;i++)
            {
              if(data[i].company_id==this.companyId)
              {
                this.companyDetails = data[i];
              }
            }
            
        },
        error => {
            console.log(error)
        }
      )
  }
  sellItem()
  {
    this.getDataservice.sellShare(localStorage.getItem('username'), this.companyId, this.quantity)
      .subscribe(
        data => {
            if(data.status=="success")
              this.router.navigate(['my-shares'])
        },
        error => {
            console.log(error)
        }
      )
  }
  checkQuantity(qty,availableQty)
  {
    if(isNaN(Number(qty.value)) || Number(qty.value) === 0 || Number(qty.value) > availableQty)
      return false;
    else
      return true;
  }
}
