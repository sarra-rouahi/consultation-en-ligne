export class Press{
    id:number;
    id_p:number;
    id_d:number;
    text:String;
    constructor(id?: number,id_p?:number,id_d?:number,text?:String){
        this.id=id ||-1; 
        this.id_d=id_d ||-1;
        this.id_p=id_p||-1;
        this.text=text||"";

    }
}