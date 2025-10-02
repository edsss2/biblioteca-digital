import { inject, Injectable } from '@angular/core';
import { LocalStorageToken } from '../auth/tokens/local-storage';

@Injectable({
  providedIn: 'root'
})
export class AuthTokenStorage {

  localStorageToken = inject(LocalStorageToken);
  
  private readonly key: string = 'auth-token';

  set(token: string) {
    this.localStorageToken.setItem(this.key, token);
  }
}
