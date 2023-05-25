import { SalimComponent } from './pages/salim/salim.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './pages/nav/nav.component';
import { MamyComponent } from './pages/mamy/mamy.component';


const routes: Routes = [
  {path:'',component:NavComponent,children:[
    {path:'salim',component:SalimComponent},
    {path:'mamy',component:MamyComponent},
  ]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
