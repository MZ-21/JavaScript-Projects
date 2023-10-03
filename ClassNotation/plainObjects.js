function empInfo()
{
    console.log('Name: ' + this.empName + ' Tasks >>> ');
    for (let t of this.tasks)
        t.printTask();
}

function printTask()
{
    console.log('Description: '+ this.taskDec + ' Due Date: ' + this.dueDate);
}

let task1 = {taskDec:'prepare the budget', dueDate:'Jan-01', printTask};
let task2 = {taskDec:'Conduct interviews', dueDate:'March', printTask};
let task3 = {taskDec:'Write report', dueDate:'Jun', printTask};
let task4 = {taskDec:'Present report', dueDate:'July', printTask};


let emp1 = {empName: 'Alice', 
        salary: 1000, 
        tasks: [task1, task2],
        empInfo };

let emp2 = {empName: 'Bob', 
            salary: 2000, 
            tasks: [task3, task4],
            empInfo };

emp1.empInfo();
emp2.empInfo();

