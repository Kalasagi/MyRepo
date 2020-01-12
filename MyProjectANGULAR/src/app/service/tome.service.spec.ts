import { TestBed } from '@angular/core/testing';

import { TomeService } from './tome.service';

describe('TomeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TomeService = TestBed.get(TomeService);
    expect(service).toBeTruthy();
  });
});
