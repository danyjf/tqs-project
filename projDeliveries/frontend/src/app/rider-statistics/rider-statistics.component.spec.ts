import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RiderStatisticsComponent } from './rider-statistics.component';

describe('RiderStatisticsComponent', () => {
  let component: RiderStatisticsComponent;
  let fixture: ComponentFixture<RiderStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RiderStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RiderStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
