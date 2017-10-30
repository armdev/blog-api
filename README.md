# blog-api
RESTful API written with Spring-boot, hibernate, and MySQL

This is a test project to learn and flush out different features with Springframework.

## Web API Endpoint Reference
|METHOD|ENDPOINT|USAGE|RETURNS|SECURE|
|:--------:|:-----------------:|:-----:|:-------:|:------:|
|GET|/users|Get all Users| List<User> | No |
|GET|/users/{id}|Get User by Id| User| No|
|POST|/users|Create new User|User|No|
|PUT|/user/{id}|Replace User|User|No|
|PATCH|/user/{id}|Update User|User|No|
|DELETE|/user{id}|Delete User|Void|No|
||||||
|GET|/posts|Get all Posts|List<Post>|No|
|GET|/posts/{id}|Get Post by Id|Post|No|
|Get|/users/{id}/posts|Get all Post for User|List<Post>|No
|POST|/users/{id}/posts|Create new Post|Post|No|
|PUT|/posts/{id}|Replace Post|Post|No|
|PATCH|/posts/{id}|Update Post|Post|No|
|DELETE|/posts/{id}|Delete Post|Void|No|