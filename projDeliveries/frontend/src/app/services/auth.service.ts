import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { IRegisterResponse } from '../interfaces/register-response';
import { IUser } from '../interfaces/user';
import { DELIVERIES_API_URL } from '../globals';


@Injectable({
    providedIn: 'root'
})
export class AuthService {
    constructor(private http: HttpClient) { }

    logout(): void {
        localStorage.setItem("isLoggedIn", "false");
        localStorage.removeItem("userType");
        localStorage.removeItem("userPhone");
        localStorage.removeItem("token");
        localStorage.removeItem("delivery");
    }

    authenticate(username: string, password: string): Observable<IUser> {
        return this.http.get<IUser>(`${DELIVERIES_API_URL}/users/${username}/${password}`);
    }

    register(username: string, email: string, password: string, phone: string): Observable<IRegisterResponse> {
        const user: IUser = {
            username: username,
            email: email,
            password: password,
            phone: phone,
            userType: "user"
        }

        return this.http.post<IRegisterResponse>(`${DELIVERIES_API_URL}/users`, user);
    }

    isLoggedIn(): boolean {
        let status = false;
        
        if(localStorage.getItem("isLoggedIn") == "true") {
            status = true;
        }

        return status;
    }

    isManager(): boolean {
        let status = false;

        if(localStorage.getItem("userType") == "manager") {
            status = true;
        }

        return status;
    }

    isDoingDelivery(): boolean {
        let status = false;

        if(localStorage.getItem("delivery")) {
            status = true;
        }

        return status;
    }
}
