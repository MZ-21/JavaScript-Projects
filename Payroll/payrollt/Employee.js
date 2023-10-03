class Employee
{
    constructor(firstName, lastName, salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        let __salary__;  
        
        this.setSalary = function(salary)
        {
            __salary__ = salary;
        }

        this.getSalary = function()
        {
           return __salary__;
        }
        
        this.setSalary(salary);
    }

    calcSalary()
    {
        let netSalary = this.getSalary() - (this.getSalary() * 0.10); //is in the protoype of class. If not in constructor then in protoype
        return netSalary;
    }

    get fullName()
    {
        return this.firstName + " " + this.lastName; //mimick attributes but rlly functions bc doesnt make sense to have first name lst name and different property for it
    }

    set fullName(full_name)
    {
        let splitName = full_name.split(" ");
        this.firstName = splitName[0];
        this.lastName = splitName[1];
    }
}

module.exports=Employee;
//need = bc whole exports object will hold whole class