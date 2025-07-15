import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListpComponent } from './listp.component';

describe('ListpComponent', () => {
  let component: ListpComponent;
  let fixture: ComponentFixture<ListpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListpComponent]
    });
    fixture = TestBed.createComponent(ListpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
