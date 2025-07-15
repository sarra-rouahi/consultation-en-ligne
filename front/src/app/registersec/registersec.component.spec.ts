import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistersecComponent } from './registersec.component';

describe('RegistersecComponent', () => {
  let component: RegistersecComponent;
  let fixture: ComponentFixture<RegistersecComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistersecComponent]
    });
    fixture = TestBed.createComponent(RegistersecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
