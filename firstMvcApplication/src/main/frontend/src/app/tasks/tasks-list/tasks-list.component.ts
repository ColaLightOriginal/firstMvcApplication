import { Component, OnInit, Input } from '@angular/core';
import {Task} from '../task.model';
import {TaskService} from '../task.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.css']
})

export class TasksListComponent implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService) {}

  @Input('employeeTasks') employeeTasks: Task[];
  @Input('employeeId') employeeId: number;

  ngOnInit() {
    return this.taskService.getTasks().subscribe(
        (tasks: any[]) => { this.tasks = tasks},
        (error) => console.log(error)
    );
  }

  ngGetById(){
    return this.taskService.getTasksWithId(this.employeeId).subscribe(
        (tasks: any[]) => { this.tasks = tasks},
        (error) => console.log(error)
    );
  }

}
