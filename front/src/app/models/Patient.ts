import { User } from "./User";

export class Patient extends User{
    birthdayDate:Date;
    address:String;
    role:String;
    constructor(id?: number, firstname?: string, lastname?: string, email?: string, password?: string, number?: string, gender?: string, birthdayDate?: Date, address?: string, role?: string) {
        super(id, firstname, lastname, email, password, number, gender); // Call the constructor of the superclass (User)
        this.birthdayDate = birthdayDate || new Date() ;
        this.address = address  || "";
        this.role = role  || "";
    }
   
}