import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClasseAddEditComponent } from './classe-add-edit.component';

describe('ClasseAddEditComponent', () => {
  let component: ClasseAddEditComponent;
  let fixture: ComponentFixture<ClasseAddEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClasseAddEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClasseAddEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
