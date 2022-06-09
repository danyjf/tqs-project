import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  
    hide: boolean = true;
  
    constructor(private fb: FormBuilder) {
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
      
      console.log(this.loginForm.value);
    }
  
  }
