import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeList } from './components/employee-list/employee-list';
import { EmployeeDetail } from './components/employee-detail/employee-detail';

const routes: Routes = [
  { path: '', component: EmployeeList },
  { path: 'employee/:id', component: EmployeeDetail },
  { path: 'employee', component: EmployeeDetail },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
