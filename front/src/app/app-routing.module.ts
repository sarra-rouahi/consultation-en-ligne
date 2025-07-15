import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DesComponent } from './des/des.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ChoiceComponent } from './choice/choice.component';
import { RegistersecComponent } from './registersec/registersec.component';
import { HomesecComponent } from './homesec/homesec.component';
import { RegisdComponent } from './regisd/regisd.component';
import { CreateappointmentComponent } from './createappointment/createappointment.component';
import { HomedocComponent } from './homedoc/homedoc.component';
import { HomepComponent } from './homep/homep.component';
import { UpdatepComponent } from './updatep/updatep.component';
import { ViewpComponent } from './viewp/viewp.component';
import { AuthGaurdService } from './service/authh';
import { ListpComponent } from './listp/listp.component';
import { PresComponent } from './pres/pres.component';
import { UpComponent } from './up/up.component';
import { NotifComponent } from './notif/notif.component';
import { TestnComponent } from './testn/testn.component';
import { VidComponent } from './vid/vid.component';
const routes: Routes = [
  {path:"home",component:HomeComponent ,children:[
    {path:"description",component:DesComponent},
    {path:"login",component: LoginComponent},
    {path:"choix",component: ChoiceComponent},
    {path:"comptes",component: RegistersecComponent},
    {path:"compted",component: RegisdComponent},
    {path:"comptep",component: RegisterComponent},
    {path:"update",component: UpdatepComponent},
    {path:"viewp/:id",component: ViewpComponent},
   {path:"appointmentlist",component:HomesecComponent , canActivate: [AuthGaurdService]},
   {path:"createappointment",component: CreateappointmentComponent , canActivate: [AuthGaurdService]},
   {path:"homesec",component: HomesecComponent , canActivate: [AuthGaurdService]},
   {path:"homedoc",component: HomedocComponent , canActivate: [AuthGaurdService]},
   {path:"homep",component: HomepComponent , canActivate: [AuthGaurdService]},
   {path:"cp",component: PresComponent , canActivate: [AuthGaurdService]},
   {path:"lp",component: ListpComponent , canActivate: [AuthGaurdService]},
   {path:"up/:id",component: UpComponent , canActivate: [AuthGaurdService]},
   {path:"v",component:VidComponent , canActivate: [AuthGaurdService]},
   {path:"n",component:TestnComponent , canActivate: [AuthGaurdService]}


    
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
