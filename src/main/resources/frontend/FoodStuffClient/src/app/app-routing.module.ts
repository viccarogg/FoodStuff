import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { ViewUserComponent } from './view-user/view-user.component';

const routes: Routes = [{path: '', redirectTo: 'add', pathMatch: 'full'},
{path: 'add', component: CreateUserComponent},
{ path: 'users', component: ViewUserComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {   }
