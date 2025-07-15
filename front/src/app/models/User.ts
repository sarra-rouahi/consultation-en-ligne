export class User{
    
    id:number;
    firstname:String;
    lastname:String;
    email:String;
    password:String;
    number:String;
    gender:String;
    constructor(id?: number, firstname?: string, lastname?: string, email?: string, password?: string, number?: string, gender?: string) {
        this.id = id ||-1;
        this.firstname = firstname || "";
        this.lastname = lastname  || "";
        this.email = email  || "";
        this.password = password  || "";
        this.number = number  || "";
        this.gender = gender  || "";
    }
    
}