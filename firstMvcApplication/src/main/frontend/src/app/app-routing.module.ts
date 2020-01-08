import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { EmployeesComponent } from './employees/employees.component';
import { TasksListComponent } from './tasks/tasks-list/tasks-list.component';
import { ChartComponent } from './chart/chart.component';
import { EmployeeAddComponent } from './employee-add/employee-add.component';
import { TaskAddComponent } from './task-add/task-add.component';

const routes: Routes = [
    {
        path: '',
        component: ChartComponent
    },
    {
        path: 'employees',
        component: EmployeesComponent
    },
    {
        path: 'tasks-list',
        component: TasksListComponent
    },
    {
        path: 'employee-add',
        component: EmployeeAddComponent
    },
    {
        path: 'task-add',
        component: TaskAddComponent
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}
