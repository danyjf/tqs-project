import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthService } from '../services/auth.service';

@Injectable({
    providedIn: 'root'
})
export class ManagerGuard implements CanActivate {
    constructor(private router: Router, private authService: AuthService) { }

    /**
     * Allow only authenticated manager users to open the page.
     * If the user is logged in as a manager then allow him to access
     * the page.
     * Else redirect the user to the deliveries page, which in the
     * case where the user is not logged in will in turn be redirected
     * to the login page.
     */
    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        if(this.authService.isLoggedIn() && this.authService.isManager()) {
            return true;
        }
        this.router.navigate(['/deliveries']);
        return false;
    }
}
