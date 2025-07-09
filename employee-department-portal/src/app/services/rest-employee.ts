import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RouteUrls } from './routeUrl';

@Injectable({
  providedIn: 'root'
})
export class RestEmployee {

  constructor(private http: HttpClient) { }

  getEmployeeByDepartmentId(data: any) {
    return this.http.get(RouteUrls.GET_EMPLOYEE + '/' + data);
  }

  getByDepartment(deptId: string) {
    return this.http.get(RouteUrls.GET_EMPLOYEE_BY_DEPT + '/' + deptId);
  }

  update(employee: any): Observable<any> {
    console.log(employee);
    return this.http.post(RouteUrls.UPDATE_EMPLOYEE, employee);
  }

  delete(id: string): Observable<void> {
    return this.http.delete<void>(RouteUrls.DELETE_EMPLOYEE + '/' + id);
  }
}
