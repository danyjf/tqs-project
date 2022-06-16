import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerStatisticsComponent } from './manager-statistics.component';

describe('ManagerStatisticsComponent', () => {
  let component: ManagerStatisticsComponent;
  let fixture: ComponentFixture<ManagerStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
