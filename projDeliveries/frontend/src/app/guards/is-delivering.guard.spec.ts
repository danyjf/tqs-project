import { TestBed } from '@angular/core/testing';

import { IsDeliveringGuard } from './is-delivering.guard';

describe('IsDeliveringGuard', () => {
  let guard: IsDeliveringGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsDeliveringGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
