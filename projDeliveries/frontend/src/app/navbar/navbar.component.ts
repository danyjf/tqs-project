import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
    constructor(private authService: AuthService, private router: Router) { }

    ngOnInit(): void {
    }

    isAuthenticated(): boolean {
        return this.authService.isLoggedIn();
    }

    isManager(): boolean {
        return this.authService.isManager();
    }

    logout(): void {
        console.log("logout");
        this.authService.logout();
        this.router.navigate(["/login"]);
    }
}
