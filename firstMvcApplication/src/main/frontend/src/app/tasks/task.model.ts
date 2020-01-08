export class Task{
    public id: number;
    public description: string;
    public priority: number;
    public empId: number;

    constructor(id: number,description: string, priority: number, empId:number ){
        this.id=id;
        this.description=description;
        this.priority=priority;
        this.empId=empId;
    }
}
