import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { ViewUserComponent } from './view-user/view-user.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { ListUsersComponent} from "./list-users/list-users.component";
import { NgbdModalConfig } from './create-post/create-post.component';
import { SearchPostsComponent} from './search-posts/search-posts.component';



const routes: Routes = [{path: '', redirectTo: 'home', pathMatch: 'full'},
{path: 'home', component: HomepageComponent},
{path: 'register', component: CreateUserComponent},
{ path: 'users/:id', component: ViewUserComponent },
{ path: 'allusers', component: ListUsersComponent },
{ path: 'search/:search', component: SearchPostsComponent },
{path: 'login', component: LoginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule {   }
