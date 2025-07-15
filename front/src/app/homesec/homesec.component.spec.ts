import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomesecComponent } from './homesec.component';

describe('HomesecComponent', () => {
  let component: HomesecComponent;
  let fixture: ComponentFixture<HomesecComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomesecComponent]
    });
    fixture = TestBed.createComponent(HomesecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
