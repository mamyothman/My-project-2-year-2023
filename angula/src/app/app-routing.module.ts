import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavBarComponent } from './default/nav-bar/nav-bar.component';
import { LoginComponent } from './pages/login/login.component';
import { MainComponent } from './default/main/main.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';



const routes: Routes = [
{path:'',redirectTo:'/nav-bar' ,pathMatch:"full"},
{path:'nav-bar',component:NavBarComponent,children:[
  {path:'',component:MainComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
]},
{path:'home',component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
