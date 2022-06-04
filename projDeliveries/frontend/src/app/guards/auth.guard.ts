import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthService } from '../services/auth.service';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {
    constructor(private router: Router, private authService: AuthService) { }

    /**
     * Allow only authenticated regular users to open the page.
     * If the user is not logged in then redirect him to the login page.
     * If the user is logged in as manager then redirect him to the 
     * manager statistics page.
     * If the user is logged in and is not a manager then allow him to 
     * visit the page.
     */
    canActivate(
        route: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
        if(!this.authService.isLoggedIn()) {
            this.router.navigate(["/login"]);
            return false;
        } 
        
        if(this.authService.isManager()) {
            this.router.navigate(["/manager/statistics"]);
            return false;
        }

        return true;
    }
}
