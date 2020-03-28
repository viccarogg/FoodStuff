import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [{path: '', redirectTo: 'home', pathMatch: 'full'},
{path: 'home', component: HomepageComponent},
{path: 'add', component: CreateUserComponent},
{ path: 'users/:id', component: ViewUserComponent },
{path: 'login', component: LoginComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {   }
