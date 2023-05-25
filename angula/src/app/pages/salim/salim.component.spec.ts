import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalimComponent } from './salim.component';

describe('SalimComponent', () => {
  let component: SalimComponent;
  let fixture: ComponentFixture<SalimComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalimComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
