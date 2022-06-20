import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { loggedIn } from '../app.component';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
    hide: boolean = true;
  
    constructor(private fb: FormBuilder, private httpClient: HttpClient, private router: Router, private route: ActivatedRoute) {
    }
  
    ngOnInit() {
    }
  
    loginForm: FormGroup = this.fb.group({
      username: ['', [Validators.required, Validators.maxLength(16)]],
      name: ['', [Validators.required, Validators.maxLength(24)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    })
  
  
    onSignUp() {
      if (!this.loginForm.valid) {
        return;
      }
      const email = this.loginForm.value['email'];
      const password = this.loginForm.value['password'];
      const username = this.loginForm.value['username'];
      const name = this.loginForm.value['name'];
      
      this.httpClient.post("http://localhost:7070/api/v1/user", {
        "username": username,
        "fullname": name,
        "email": email,
        "password": password
      }).toPromise().then((response: any) => { 
        sessionStorage.setItem("user_id", response.id.toString()); ;
        console.log(response);});
      
      this.router.navigate(['/home']);
    }
  
  }
