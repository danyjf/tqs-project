import { Component, OnInit } from '@angular/core';

import { AuthenticatorService } from '../authenticator.service';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
    constructor(private authenticatorService: AuthenticatorService) { }

    ngOnInit(): void {
    }

    isAuthenticated(): boolean {
        return this.authenticatorService.authenticated;
    }
}
