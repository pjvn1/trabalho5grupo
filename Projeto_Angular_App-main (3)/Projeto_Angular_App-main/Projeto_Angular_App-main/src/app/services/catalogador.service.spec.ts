import { TestBed } from '@angular/core/testing';

import { CatalogadorService } from './catalogador.service';

describe('CatalogadorService', () => {
  let service: CatalogadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CatalogadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
