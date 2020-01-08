import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Chart} from 'chart.js';
import { EmployeeService } from '../employees/employee.service';
import { TaskService } from '../tasks/task.service';
import { Employee } from '../employees/employee.model';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements AfterViewInit, OnInit {

  chart = [];
  tasksCount = null;
  employeesCount;
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService, private taskService: TaskService) {
  }

  countEmp(){
    this.employeeService.getEmployees().pipe(map(res => {
        return res;
    }));
  }

  countTasks(){
  }

  ngOnInit(){
    }

  ngAfterViewInit() {
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Employees", "Tasks"],
        datasets: [{
            label: 'Count:',
            data: [2,10],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
  }
}

