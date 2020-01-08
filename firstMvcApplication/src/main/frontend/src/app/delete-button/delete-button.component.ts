import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { EmployeeService } from '../employees/employee.service';
import { Employee } from '../employees/employee.model';

@Component({
  selector: 'app-delete-button',
  templateUrl: './delete-button.component.html',
  styleUrls: ['./delete-button.component.css']
})

export class DeleteButtonComponent implements OnInit {


  constructor() { }

  ngOnInit() {
  }

  ngOnClick(){
  }

}
