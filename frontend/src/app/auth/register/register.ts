import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Usuario } from '../../models/usuario.model';
import { Role } from '../../models/role';
import { AuthService } from '../../services/auth-service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  usuario: Usuario = {
    username: '',
    senha: '',
    nome: '',
    role: Role.USUARIO_COMUM
  };
  isBibliotecario: boolean = false;

  constructor(private authService : AuthService, private router: Router) {}

  onRoleChange(isBibliotecario: boolean) {
    this.usuario.role = isBibliotecario ? Role.BIBLIOTECARIO : Role.USUARIO_COMUM;
  }

  onSubmit(event?: Event) {
    if (event) event.preventDefault();
    
    this.authService.register(this.usuario).subscribe({
    next: (res) => {
      console.log("Registro bem-sucedido!", res);
      this.router.navigate(['/login'])
    },
    error: (err) => {
      console.error("Erro no registro:", err);
    }
  });
  }
}
