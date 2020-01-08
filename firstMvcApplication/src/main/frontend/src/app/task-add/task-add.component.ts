import { Component, OnInit } from '@angular/core';
import { TaskService } from '../tasks/task.service';
import { Task } from '../tasks/task.model';
import { MatTooltipModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.css']
})
export class TaskAddComponent implements OnInit {

  constructor(private taskService: TaskService) { }

  private task: Task;
  public showMyMessage = false;

  ngOnInit() {
  }

  ngOnClick(){
    var employeeInputValue = (<HTMLInputElement>document.getElementById('empInput')).value;
    var descriptionInputValue = (<HTMLInputElement>document.getElementById('descriptionInput')).value;
    var priorityInputValue = (<HTMLInputElement>document.getElementById('priorityInput')).value;
    this.taskService.postTask(Number(employeeInputValue), descriptionInputValue, Number(priorityInputValue), this.task).subscribe();
    this.showMyMessage = true;
  }

}
