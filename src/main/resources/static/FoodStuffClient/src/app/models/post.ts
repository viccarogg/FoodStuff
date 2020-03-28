import { User } from './user';

export class Post {
    postId:number;
    content:string;
    title:string;
    userId: User;
    comments:Comment[]
}