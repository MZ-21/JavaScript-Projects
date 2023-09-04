
//let Employee = require('./Employee'); //use const cant override
//let Manager = require('./Manager');
const EmployeeManager= require('./EmployeeManager');


let e1 = new EmployeeManager.Employee('Alice', 'Wonder', 1000); //points to employee class so can now create an object of it
console.log(e1.calcSalary());

console.log(e1.fullName);
e1.fullName = 'Bob Smith';
console.log(e1.fullName);



let m = new EmployeeManager.Manager('John', 'Smith', 2000, 500); //same here as above ^
console.log(m.fullName);
console.log(m.calcSalary());