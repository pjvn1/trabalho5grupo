import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatalogoAddEditComponent } from './catalogo-add-edit.component';

describe('CatalogoAddEditComponent', () => {
  let component: CatalogoAddEditComponent;
  let fixture: ComponentFixture<CatalogoAddEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatalogoAddEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CatalogoAddEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
