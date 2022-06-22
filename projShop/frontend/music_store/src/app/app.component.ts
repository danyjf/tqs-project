import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'music_store';
  saveLoggedIn(id: number){
    sessionStorage.setItem("user_id", id.toString());
  }
}
class User{
  id!: number;
  username!: string;
  name!: string;
  email!: string;
  password!: string;
}
export class loggedIn {
  static user: User = new User();
}
