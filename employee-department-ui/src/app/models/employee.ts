export interface Department {
    id: string;
    name: string;
    location: string;
  }
  
  export interface Employee {
    id: string;
    name: string;
    email: string;
    position: string;
    salary: number;
    department?: Department;
  }
  