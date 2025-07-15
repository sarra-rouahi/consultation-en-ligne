import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestnComponent } from './testn.component';

describe('TestnComponent', () => {
  let component: TestnComponent;
  let fixture: ComponentFixture<TestnComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TestnComponent]
    });
    fixture = TestBed.createComponent(TestnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
