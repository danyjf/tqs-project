import { Injectable } from '@angular/core';

import { USERS } from './models/mock-users';

@Injectable({
    providedIn: 'root'
})
export class AuthenticatorService {
    authenticated: boolean = false;

    constructor() { }

    authenticate(credentials: any, callback: any) {
        const user = USERS.find(u => u.username === credentials.username && u.password === credentials.password)!;
        
        if(user) {
            this.authenticated = true;
            return callback && callback();
        }else {
            this.authenticated = false;
        }
    }
}
