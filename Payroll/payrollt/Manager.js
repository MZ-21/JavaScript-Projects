
let Employee = require('./Employee');

class Manager extends Employee{
    constructor(firstName, lastName, salary, bonus)
    {
        super(firstName, lastName, salary);
        this.bonus = bonus;
    }

    calcSalary()
    {
        return super.calcSalary() + this.bonus;
    }

}
module.exports=Manager;