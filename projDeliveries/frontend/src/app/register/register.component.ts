import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { IRegisterResponse } from '../interfaces/register-response';

import { AuthService } from '../services/auth.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
    registerForm!: FormGroup;
    returnUrl!: string;
    registerResponse?: IRegisterResponse;
    message?: string;

    constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) { }

    ngOnInit(): void {
        this.registerForm = this.formBuilder.group({
            username: ['', Validators.required],
            email: ['', Validators.required],
            password: ['', Validators.required],
            phone: ['', Validators.required],
        });
        this.returnUrl = "/login";
        this.authService.logout();
    }

    get f() {
        return this.registerForm.controls;
    }

    register(): void {
        if(this.registerForm.invalid) {
            this.message = "Fill all fields";
            return;
        } else {
            this.authService.register(this.f["username"].value, this.f["email"].value, this.f["password"].value, this.f["phone"].value)
                .subscribe(registerResponse => this.registerResponse = registerResponse);

            if(this.registerResponse?.status == "success") {
                console.log("Registration successful");
                this.router.navigate([this.returnUrl]);
            } else {
                this.message = this.registerResponse?.message;
            }
        }
    }
}
