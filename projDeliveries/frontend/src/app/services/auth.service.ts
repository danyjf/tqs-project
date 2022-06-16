import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { USERS } from '../interfaces/mock-users';
import { IRegisterResponse } from '../interfaces/register-response';
import { IUser } from '../interfaces/user';


@Injectable({
    providedIn: 'root'
})
export class AuthService {
    constructor(private http: HttpClient) { }

    logout(): void {
        localStorage.setItem("isLoggedIn", "false");
        localStorage.removeItem("userType");
        localStorage.removeItem("token");
    }

    authenticate(username: string, password: string): Observable<IUser> {
        // const user = USERS.find(u => u.username === username && u.password === password)!;
        
        // return of(user);
        return this.http.get<IUser>(`http://localhost:8000/users/${username}/${password}`);
    }

    register(username: string, email: string, password: string, phone: string): Observable<IRegisterResponse> {
        let usernames = USERS.map(s => s.username);
        let emails = USERS.map(s => s.email);
        let passwords = USERS.map(s => s.password);
        let phones = USERS.map(s => s.phone);

        if(usernames.includes(username)) {
            return of({status: "fail", message: "Username already in use"});
        }
        if(emails.includes(email)) {
            return of({status: "fail", message: "Email already in use"});
        }
        if(passwords.includes(password)) {
            return of({status: "fail", message: "Password already in use"});
        }
        if(phones.includes(phone)) {
            return of({status: "fail", message: "Phone already in use"});
        }

        return of({status: "success", message: "Successfully registered"});
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
