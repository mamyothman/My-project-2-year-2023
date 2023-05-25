import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MamyComponent } from './mamy.component';

describe('MamyComponent', () => {
  let component: MamyComponent;
  let fixture: ComponentFixture<MamyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MamyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MamyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
