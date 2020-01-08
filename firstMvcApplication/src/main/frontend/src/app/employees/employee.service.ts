import {Http} from '@angular/http';
import {Injectable} from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable()
export class EmployeeService{

constructor(private http: Http){
    }

    getEmployees(){
        return this.http.get('/employees/getEmployees').pipe(map(response => response.json()));
    }

    addEmployee(name: string, surname: string, employee){
        return this.http.post('/employees/addEmployee/'+name+'/'+surname, employee);
    }

    removeEmployees(empId: number){
        return this.http.delete('/employees/removeEmployee/'+empId.toString());
    }
}
