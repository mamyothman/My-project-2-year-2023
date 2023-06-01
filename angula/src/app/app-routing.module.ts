import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavBarComponent } from './default/nav-bar/nav-bar.component';
import { LoginComponent } from './pages/login/login.component';
import { MainComponent } from './default/main/main.component';
import { RegisterComponent } from './pages/register/register.component';



const routes: Routes = [
{path:'',redirectTo:'/nav-bar' ,pathMatch:"full"},
{path:'nav-bar',component:NavBarComponent,children:[
  {path:'',component:MainComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
