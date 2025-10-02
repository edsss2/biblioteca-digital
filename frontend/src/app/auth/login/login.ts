import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../services/auth-service';
import { LoginRequest } from '../../models/login-request.model';
import { LoginResponse } from '../../models/login-response.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  loginRequest: LoginRequest = {
    username: '',
    senha: ''
  };

  loginResponse : LoginResponse = {
    token: ''
  };

  constructor(private authService : AuthService, private router: Router) {}

  onSubmit(event?: Event) {
    if (event) event.preventDefault();

    this.authService.login(this.loginRequest).subscribe({
      next: (res) => {
        console.log("Login bem-sucedido!", res);
        this.loginResponse = res;
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error("Erro no login: ", err);
        alert(err);
      }
    })
  }
}
