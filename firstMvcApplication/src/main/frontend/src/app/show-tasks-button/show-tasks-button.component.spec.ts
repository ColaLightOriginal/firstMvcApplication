import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowTasksButtonComponent } from './show-tasks-button.component';

describe('ShowTasksButtonComponent', () => {
  let component: ShowTasksButtonComponent;
  let fixture: ComponentFixture<ShowTasksButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowTasksButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowTasksButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
