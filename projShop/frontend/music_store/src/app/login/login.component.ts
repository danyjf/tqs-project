import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide: boolean = true;

  constructor(private fb: FormBuilder, private httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  })


  onLogin() {
    if (!this.loginForm.valid) {
      return;
    }
    const email = this.loginForm.value['email'];
    const password = this.loginForm.value['password'];

    this.httpClient.post("http://localhost:7070/api/v1/login/"+email+"/"+password, {}).toPromise().then((response: any) => {console.log(response);});

  }

}