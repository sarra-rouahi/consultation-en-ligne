import { User } from "./User";

export class Doctor extends User {
   
   speciality:String;
   department:String;
   role:String;
   constructor(id: number, firstname: string, lastname: string, email: string, password: string, number: string, gender: string, speciality: string, department: string, role: string) {
      super(id, firstname, lastname, email, password, number, gender); // Call the constructor of the superclass (User)
      this.speciality = speciality;
      this.department = department;
      this.role = role;
  }
  Doctor(){}
}