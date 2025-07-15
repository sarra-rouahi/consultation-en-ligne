import { DatePipe } from '@angular/common';

export class Appointment {
  idapp: number;
  idpatient: number;
  iddoctor: number;
  date: Date;
  formattedDate: string;
   statut:string;
  constructor(idapp?: number, idpatient?: number, iddoctor?: number, date?: Date,statut?:string) {
    this.idapp = idapp || -1;
    this.idpatient = idpatient || -1;
    this.iddoctor = iddoctor || -1;
    this.date = date || new Date();
    this.formattedDate = Appointment.formatDate(this.date);
    this.statut=statut||'';
  }

  private static formatDate(date: Date): string {
    const datePipe = new DatePipe('en-US');
    return datePipe.transform(date, 'short') || 'lr';
  }
}
