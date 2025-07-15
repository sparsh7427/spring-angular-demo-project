import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyPipe } from '@angular/common';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee-detail',
    standalone: true, 
    imports: [CommonModule, CurrencyPipe],
  templateUrl: './employee-detail.component.html',
  styleUrl: './employee-detail.component.scss'
})
export class EmployeeDetailComponent implements OnInit {
  emp!: Employee;

  constructor(private route: ActivatedRoute, private empService: EmployeeService, private router: Router) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id')!;
    this.empService.getAll().subscribe(data => {
      this.emp = data.find(e => e.id === id)!;
    });
  }

  goBack() {
    this.router.navigate(['/']);
  }
}
