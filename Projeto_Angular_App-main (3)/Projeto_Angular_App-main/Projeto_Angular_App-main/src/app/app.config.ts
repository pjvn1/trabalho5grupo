import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations'
import { provideToastr } from 'ngx-toastr';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideClientHydration } from '@angular/platform-browser';
import { customInterceptor } from './custom.interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), provideHttpClient(withInterceptors([customInterceptor])),
    provideAnimations(),
    provideToastr(),
    provideHttpClient(withFetch()), provideAnimationsAsync(),provideClientHydration(), provideAnimationsAsync(), provideHttpClient(withFetch())
  ]
};
