import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { USERS } from '../interfaces/mock-users';
import { IUser } from '../interfaces/user';


@Injectable({
    providedIn: 'root'
})
export class AuthService {
    constructor() { }

    logout(): void {
        localStorage.setItem("isLoggedIn", "false");
        localStorage.removeItem("userType");
        localStorage.removeItem("token");
    }

    authenticate(username: string, password: string): Observable<IUser> {
        const user = USERS.find(u => u.username === username && u.password === password)!;
        
        return of(user);
    }

    isLoggedIn(): boolean {
        let status = false;
        
        if(localStorage.getItem("isLoggedIn") == "true") {
            status = true;
        } else {
            status = false;
        }

        return status;
    }

    isManager(): boolean {
        let status = false;

        if(localStorage.getItem("userType") == "manager") {
            status = true;
        } else {
            status = false;
        }

        return status;
    }
}
