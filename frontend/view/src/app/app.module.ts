import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { VestuarioComponent } from './vestuario/vestuario.component';
import { VestuarioService } from './services/vestuario.service';

@NgModule({
  declarations: [
    AppComponent,
    VestuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [VestuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
