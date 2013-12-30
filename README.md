# TopShelf #

## So what the heck is going on here?

This project is an attempt on my part to figure out an agreeable way to do the following things:

1. Do persistent (db-backed) CRUD operations in Scalatra in a way that is pleasingly DRY and/or doesn't drive me bananas.
2. Hook the whole works to a Backbone.js frontend...
3. ...that runs on Heroku...
4. ...and uses a sensical, modern JS stack (Grunt, Bower, Require.js)...
5. ...in a way that doesn't make me feel like I just set my hair on fire.

To get this done, I've executed a pretty standard-issue code-project scoping trick: I'm making something that helps me with a need. I like classic cocktails; I have a large liquor collection. This app will, ideally, eventually, help me manage my collection. Welcome to the Top Shelf.

## A Big Honking List of Frameworks, Packages, Bits, and Bobs

- The Server Side
-- Scalatra
-- Squeryl
-- JacksonJson
-- Grizzled-SLF4J
-- PostgreSQL
-- C3P0
- The Client
-- ...has mostly not been written yet, but will probably include:
-- Grunt
-- Bower
-- Require
-- Backbone

All served up on Heroku -- which means using a Heroku build pack. Somehow.

## Build & Run ##

```sh
$ cd TopShelf
$ ./sbt
> container:start
> browse
```
