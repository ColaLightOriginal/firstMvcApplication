import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employees/employee.service';
import { Employee } from '../employees/employee.model';


@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {

  constructor(private employeeService: EmployeeService) { }

  private employee: Employee;
  public showMyMessage = false;

  ngOnInit() {
  }

  ngOnClick(){
    var nameInputValue = (<HTMLInputElement>document.getElementById('nameInput')).value;
    var surnameInputValue = (<HTMLInputElement>document.getElementById('surnameInput')).value;
    this.employeeService.addEmployee(nameInputValue, surnameInputValue, this.employee).subscribe();
    this.showMyMessage = true;
  }
}
