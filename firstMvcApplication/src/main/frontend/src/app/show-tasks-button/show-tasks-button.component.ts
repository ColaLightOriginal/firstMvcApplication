import { Component, OnInit, Input, Output } from '@angular/core';
import { TaskService } from '../tasks/task.service';
import { Task } from '../tasks/task.model';

@Component({
  selector: 'app-show-tasks-button',
  templateUrl: './show-tasks-button.component.html',
  styleUrls: ['./show-tasks-button.component.css']
})
export class ShowTasksButtonComponent implements OnInit {

  constructor(private taskService: TaskService) { }

  @Input() id: number;
  @Output() tasks: Task[];

  ngOnInit(){
  }

  ngOnClick() {
  }

}
