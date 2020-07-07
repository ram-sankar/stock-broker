import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

    username = '';
    password = '';
    mailid = '';
    phone = '';
    invalidLogin = false;
    invalidUser = false;
    switchToLoginPage = true;
    errorMessage = '';

    constructor(private router: Router,private loginservice: AuthenticationService) {  }

    checkValidLogin(mail,pass)
    {
        if(mail.errors || pass.errors)
            return true;
        else
            return false;
    }

    checkValidUser(mail,user,ph,pass)
    {
        if(mail.errors || user.errors || ph.errors || pass.errors)
            return true;
        else
            return false;
    }



    checkLogin(mail,pass) 
    {
        if(mail.errors || pass.errors){
            return;
        }
        
        this.loginservice.authenticate(this.mailid, this.password) 
        .subscribe( 
            data  => { 
                        if(data.status==='success')
                        {          
                            localStorage.setItem('username', this.mailid);
                            this.invalidLogin = false;
                            this.router.navigate([''])
                        }
                        else
                        {
                            this.errorMessage = "Invalid Credentials";
                            this.invalidLogin = true
                        }
                    },
            error => { 
                        if(error.error.message==="Incorrect credentials" || error.error.message==="User doesn't exist")
                            this.errorMessage = error.error.message;
                        this.invalidLogin = true
                    }
            );     
    }

    registerNewUser()
    { 
        this.loginservice.addNewUser(this.mailid,this.username,this.phone,this.password)
        .subscribe( 
            data  => { 
                        this.switchToLoginPage = true;
                        this.password = '';
                        this.invalidUser = false;
                        this.invalidLogin = false;
                        },
            error  => { console.log(error);
                        if(error.error.message==="User already exists, please check email.")
                            this.errorMessage = "email already exists";
                        else if(error.error.message==="User already exists, please check phone number.")
                            this.errorMessage = "Phone number already exists";

                        this.invalidUser = true;
                    }
            );
    }

    switchToRegister(){
    this.switchToLoginPage = false;
    }

    switchToLogin(){
    this.switchToLoginPage = true;
    }

}