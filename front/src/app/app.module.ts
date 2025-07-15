import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { NabvarComponent } from './nabvar/nabvar.component';
import { FooterComponent } from './footer/footer.component';
import { DesComponent } from './des/des.component';
import { ServiceComponent } from './service/service.component';
import { RegistersecComponent } from './registersec/registersec.component';
import { ChoiceComponent } from './choice/choice.component';
import { RegisdComponent } from './regisd/regisd.component';
import { HomesecComponent } from './homesec/homesec.component';
import { CreateappointmentComponent } from './createappointment/createappointment.component';
import { HomedocComponent } from './homedoc/homedoc.component';
import { HomepComponent } from './homep/homep.component';
import { UpdatepComponent } from './updatep/updatep.component';
import { ViewpComponent } from './viewp/viewp.component';
import { AuthComponent } from './auth/auth.component';
import { PresComponent } from './pres/pres.component';
import { ListpComponent } from './listp/listp.component';
import { UpComponent } from './up/up.component';
import { NotifComponent } from './notif/notif.component';
import { TestnComponent } from './testn/testn.component';
import { VidComponent } from './vid/vid.component';

@NgModule({
  declarations: [
    AppComponent,
   
    LoginComponent,
        RegisterComponent,
        HomeComponent,
        NabvarComponent,
        FooterComponent,
        DesComponent,
        ServiceComponent,
        
        RegistersecComponent,
        ChoiceComponent,
        RegisdComponent,
        HomesecComponent,
        CreateappointmentComponent,
        HomedocComponent,
        HomepComponent,
        UpdatepComponent,
        ViewpComponent,
        AuthComponent,
        PresComponent,
        ListpComponent,
        UpComponent,
        NotifComponent,
        TestnComponent,
        VidComponent,
       
       
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
