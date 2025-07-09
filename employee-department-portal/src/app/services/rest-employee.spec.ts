import { TestBed } from '@angular/core/testing';

import { RestEmployee } from './rest-employee';

describe('RestEmployee', () => {
  let service: RestEmployee;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestEmployee);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
