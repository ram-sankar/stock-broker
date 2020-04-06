import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MySharesComponent } from './my-shares.component';

describe('MySharesComponent', () => {
  let component: MySharesComponent;
  let fixture: ComponentFixture<MySharesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MySharesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MySharesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
