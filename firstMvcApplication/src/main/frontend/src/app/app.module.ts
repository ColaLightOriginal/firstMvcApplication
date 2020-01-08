import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { MatTooltipModule } from '@angular/material/tooltip';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { TasksListComponent } from './tasks/tasks-list/tasks-list.component';
import { TaskService} from './tasks/task.service';
import { EmployeesComponent } from './employees/employees.component';
import { EmployeeService } from './employees/employee.service';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ChartComponent } from './chart/chart.component';
import { AppRoutingModule } from './app-routing.module';
import { PopUpComponent } from './pop-up/pop-up.component';
import { DeleteButtonComponent } from './delete-button/delete-button.component';
import { ShowTasksButtonComponent } from './show-tasks-button/show-tasks-button.component';
import { EmployeeAddComponent } from './employee-add/employee-add.component';
import { TaskAddComponent } from './task-add/task-add.component';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TasksListComponent,
    EmployeesComponent,
    SidebarComponent,
    ChartComponent,
    PopUpComponent,
    DeleteButtonComponent,
    ShowTasksButtonComponent,
    EmployeeAddComponent,
    TaskAddComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    MatTooltipModule,
    BrowserAnimationsModule
  ],
  providers: [TaskService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
