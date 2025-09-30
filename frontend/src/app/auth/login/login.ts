import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  nome: string = '';
  password: string = '';

  onSubmit() {
    console.log('Email:', this.nome);
    console.log('Senha:', this.password);
    alert('Login enviado! (Ainda sem API)');
  }
}
