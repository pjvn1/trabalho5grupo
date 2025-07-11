import { TestBed } from '@angular/core/testing';

import { FamiliaService } from './familia.service';

describe('Familia', () => {
  let service: ClasseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FamiliaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
