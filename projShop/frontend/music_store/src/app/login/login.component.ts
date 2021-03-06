import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms'
import { NavigationExtras, ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { SHOP_API_URL, DELIVERIES_API_URL } from '../globals';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide: boolean = true;

  constructor(private fb: FormBuilder, private httpClient: HttpClient, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    sessionStorage.setItem("user_id", "-1");
  }

  loginForm: FormGroup = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  })


  onLogin() {
    if (!this.loginForm.valid) {
      return;
    }
    const email = this.loginForm.value['email'];
    const password = this.loginForm.value['password'];

    const userId = -1

    this.httpClient.get(SHOP_API_URL+"/api/v1/login/"+email+"/"+password, {}).toPromise().then((response: any) => {console.log(response); 
    if (response !== null){
      const userId = response.id;
      sessionStorage.setItem("user_id", userId.toString());
      if (userId !== -1) {
        this.router.navigate(['/home']);
      } else {
        const params: NavigationExtras = {
          queryParams: { userId: userId },
        }
        sessionStorage.setItem("user_id", userId.toString());
        this.router.navigate(['/login']);
      }
    }
  });
  }

}