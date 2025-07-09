import { Component } from '@angular/core';
import { RestEmployee } from '../../services/rest-employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  standalone: false,
  templateUrl: './employee-list.html',
  styleUrl: './employee-list.css'
})
export class EmployeeList {

  departmentId = '';
  employees: any[] = [];

  constructor(private service: RestEmployee, private router: Router) { }
  ngOnInit(): void { }
  searchEmployees() {
    if (this.departmentId) {
      this.service.getByDepartment(this.departmentId).subscribe((data: any) => {
        this.employees = data;
      });
    }
  }

  viewEmployee(id: string) {
    this.router.navigate(['/employee', id]);
  }
}
