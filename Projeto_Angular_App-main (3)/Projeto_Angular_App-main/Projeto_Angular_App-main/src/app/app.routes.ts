import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignUpComponent } from './pages/signup/signup.component';
import { UserComponent } from './pages/user/user.component';
import { AuthGuardService } from './services/auth-guard.service';
import { CatalogadorComponent } from './pages/crud-navios/navios/catalogador.component';
import { CatalogoComponent } from './pages/crud-navios/catalogos/catalogo.component';
import { ClasseComponent } from './pages/crud-navios/classes/classe.component';
import { FamiliaComponent } from './pages/crud-navios/familias/familia.component';
import { IsAdminService } from './services/is-admin.service';

export const routes: Routes = [
    {
        path: "",
        component: LoginComponent,
        //canActivate:[NAOESTARLOGADO]
    },
    {
        path: "signup",
        component: SignUpComponent
        //canActivate:[NAOESTARLOGADO]
    },
    {
        path: "user",
        component: UserComponent,
    },
    {
        path:'catalogador',
        component: CatalogadorComponent,

    },
    {
        path:'catalogo',
        component: CatalogoComponent,

    },
    {
            path:'classe',
            component: ClasseComponent,

        },
        {
                    path:'familia',
                    component: FamiliaComponent,

                },
];
