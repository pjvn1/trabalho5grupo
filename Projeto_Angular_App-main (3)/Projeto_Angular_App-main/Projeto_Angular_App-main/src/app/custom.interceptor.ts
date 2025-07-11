import { HttpInterceptorFn } from '@angular/common/http';

export const customInterceptor: HttpInterceptorFn = (req, next) => {
  const myToken = sessionStorage.getItem('accessToken');
  if (myToken){
    const clonedRequest = req.clone({
      setHeaders: {
        Authorization: `Bearer ${myToken}`
      }
    });
    return next(clonedRequest);
  }
  return next(req);
};
