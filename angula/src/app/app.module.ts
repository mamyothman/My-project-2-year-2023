import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './pages/nav/nav.component';
import { MamyComponent } from './pages/mamy/mamy.component';
import { SalimComponent } from './pages/salim/salim.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MamyComponent,
    SalimComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
