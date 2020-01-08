import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import { map } from 'rxjs/operators';
import { Task } from './task.model';

@Injectable()
export class TaskService{

    constructor(private http: Http){
    }

    getTasks(){
        return this.http.get('/tasks/getTasks').pipe(map(response => response.json()));
    }

    getTasksWithId(empId: number){
        return this.http.get('/tasks/findById/'+empId.toString()).pipe(map(response => response.json()));
    }

    postTask(empId: number, description: string, priority: number, task: Task){
        return this.http.post('/tasks/addTask/'+empId+'/'+description+'/'+priority, task);
    }
}
