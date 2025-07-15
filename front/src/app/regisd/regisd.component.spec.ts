import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisdComponent } from './regisd.component';

describe('RegisdComponent', () => {
  let component: RegisdComponent;
  let fixture: ComponentFixture<RegisdComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisdComponent]
    });
    fixture = TestBed.createComponent(RegisdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
