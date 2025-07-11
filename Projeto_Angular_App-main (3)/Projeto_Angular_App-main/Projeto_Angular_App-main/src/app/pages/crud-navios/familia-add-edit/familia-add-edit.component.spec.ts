import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatalogadorAddEditComponent } from './catalogador-add-edit.component';

describe('CatalogadorAddEditComponent', () => {
  let component: CatalogadorAddEditComponent;
  let fixture: ComponentFixture<CatalogadorAddEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatalogadorAddEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CatalogadorAddEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
