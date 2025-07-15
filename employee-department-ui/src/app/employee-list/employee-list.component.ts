import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Employee } from '../models/employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.scss'
})
export class EmployeeListComponent {
  deptId = '';
  employees: Employee[] = [];

  constructor(private empService: EmployeeService, private router: Router) {}

  fetch() {
    this.empService.getByDepartment(this.deptId).subscribe(data => this.employees = data);
  }

  view(emp: Employee) {
    this.router.navigate(['/detail', emp.id]);
  }

  delete(id: string) {
    this.empService.delete(id).subscribe(() => this.fetch());
  }
}
