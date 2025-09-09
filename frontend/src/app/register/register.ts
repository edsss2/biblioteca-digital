import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  nome: string = '';
  email: string = '';
  password: string = '';

  onSubmit() {
    console.log('Nome:', this.nome);
    console.log('Email:', this.email);
    console.log('Senha:', this.password);
    alert('Registro enviado! (Ainda sem API)');
  }
}
