import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { CustomSidenavComponent } from "./components/custom-sidenav/custom-sidenav.component";
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterLink, RouterOutlet, CommonModule,
    MatToolbarModule, MatButtonModule, MatIconModule,
    MatSidenavModule, CustomSidenavComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  collapsed = false;
  sidenavWidth = '250px';

  ngOnInit() {
    // Inicialização sem lógica de tokens
  }

  toggleCollapsed() {
    this.collapsed = !this.collapsed;
    this.sidenavWidth = this.collapsed ? '65px' : '250px';
  }

}
