import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { JwtDecoderService } from '../jwt-decoder.service';

@Injectable({
  providedIn: 'root'
})
export class IsAdminService implements CanActivate {

  private decodedToken: any;

  constructor(
    private jwtDecoderService: JwtDecoderService,
    private router: Router
  ) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    const authTokenPresent = sessionStorage.getItem('accessToken');

    if (authTokenPresent) {
      this.decodedToken = this.jwtDecoderService.decodeToken(authTokenPresent);
      if (this.decodedToken.role === "COMPANY") {
        return true;
      } else {
        return this.router.parseUrl('/notPermission');
      }     
    } else {
      return this.router.parseUrl('/');
    }
  }
}
