import { Component, OnInit } from '@angular/core';
import {Employee} from './employee.model';
import {EmployeeService} from './employee.service';
import {Task} from '../tasks/task.model';
import { TaskService } from '../tasks/task.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {

  employees: Employee[] = [];
  tasks: Task[] = [];

  constructor(private employeeService: EmployeeService, private taskService: TaskService) { }

 ngOnInit() {
    return this.employeeService.getEmployees()
        .subscribe(
          (employees: any[]) => { this.employees = employees},
          (error) => console.log(error)
        );
  }

  removeEmployee(id: number) {
    this.employees = this.employees.filter(employees => employees.id !== id);
    this.employeeService.removeEmployees(id).subscribe();
  }

  showEmployeeTasks(id: number){
    return this.taskService.getTasksWithId(id)
        .subscribe(
          (tasks: any[]) => { this.tasks= tasks},
          (error) => console.log(error)
        );
  }
}
