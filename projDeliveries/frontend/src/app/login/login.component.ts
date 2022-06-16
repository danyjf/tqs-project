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
            email: ['', Validators.required],
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
            this.message = "Fill all fields";
            return;
        } else {
            this.authService.authenticate(this.f["email"].value, this.f["password"].value).subscribe(user => {
                this.user = user;

                if(this.user) {
                    console.log("Login successful");
                    localStorage.setItem("isLoggedIn", "true");
                    localStorage.setItem("userType", this.user.userType);
                    localStorage.setItem("token", this.f["email"].value);
                    this.router.navigate([this.returnUrl]);
                } else {
                    this.message = "Please check your email and password";
                }
            });
        }
    }
}
