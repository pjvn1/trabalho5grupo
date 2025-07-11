import { ComponentFixture, TestBed } from '@angular/core/testing';

import {CatalogadorComponent } from './catalogador.component';
describe('CatalogadorComponent', () => {
  let component: CatalogadorComponent;
  let fixture: ComponentFixture<CatalogadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatalogadorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CatalogadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
