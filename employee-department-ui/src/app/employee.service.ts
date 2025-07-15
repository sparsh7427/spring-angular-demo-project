import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './models/employee';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  private apiUrl = 'http://localhost:8080/employees';

  constructor(private http: HttpClient) {}

  getByDepartment(deptId: string): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiUrl}/department/${deptId}`);
  }

  getAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl);
  }

  delete(id: string) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
