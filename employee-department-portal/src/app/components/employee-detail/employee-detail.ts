import { Component } from '@angular/core';
import { RestEmployee } from '../../services/rest-employee';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-detail',
  standalone: false,
  templateUrl: './employee-detail.html',
  styleUrl: './employee-detail.css'
})

export class EmployeeDetail {
  emp!: any;
  constructor(private route: ActivatedRoute, private service: RestEmployee, private router: Router) {

  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id')!;
    this.service.getEmployeeByDepartmentId(id).subscribe((res: any) => {
      this.emp = res.data;
    });
  }

  updateEmployee() {
    this.service.update(this.emp).subscribe(() => alert('Updated successfully!'));
    this.router.navigate(['/']);
  }

  deleteEmployee() {
    if (confirm('Are you sure to delete?')) {
      this.service.delete(this.emp.id).subscribe(() => this.router.navigate(['/']));
    }
  }

}
