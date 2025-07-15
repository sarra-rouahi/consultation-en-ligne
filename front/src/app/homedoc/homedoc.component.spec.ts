import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomedocComponent } from './homedoc.component';

describe('HomedocComponent', () => {
  let component: HomedocComponent;
  let fixture: ComponentFixture<HomedocComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomedocComponent]
    });
    fixture = TestBed.createComponent(HomedocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
