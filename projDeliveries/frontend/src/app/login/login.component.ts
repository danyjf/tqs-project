import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticatorService } from '../authenticator.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    credentials = { username: "", password: "" };

    constructor(private authenticatorService: AuthenticatorService, private router: Router) { }

    ngOnInit(): void {
    }

    login(): void {
        this.authenticatorService.authenticate(this.credentials, () => {
            this.router.navigateByUrl('/');
        });
    }
}
