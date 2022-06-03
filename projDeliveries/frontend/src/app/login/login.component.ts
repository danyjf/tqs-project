import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from '../services/auth.service';
import { IUser } from '../interfaces/user';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm!: FormGroup;
    message?: string;
    returnUrl!: string;
    user?: IUser;

    constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
        this.returnUrl = "/deliveries";
        this.authService.logout();
    }

    get f() {
        return this.loginForm.controls;
    }

    login(): void {
        if(this.loginForm.invalid) {
            return;
        } else {
            this.authService.authenticate(this.f["username"].value, this.f["password"].value)
                .subscribe(user => this.user = user);
            
            if(this.user) {
                console.log("Login successful");
                localStorage.setItem("isLoggedIn", "true");
                localStorage.setItem("userType", this.user.type);
                localStorage.setItem("token", this.f["username"].value);
                this.router.navigate([this.returnUrl]);
            } else {
                this.message = "Please check your username and password";
            }
        }
    }
}
