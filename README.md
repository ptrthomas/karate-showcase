# karate-showcase
Demos of advanced or experimental features that don't fit within the official documentation.

## Java DSL
Yes, Karate has a "strongly typed" option, complete with JsonPath and JSON assertion support.

Here is an [example](src/test/java/javadsl/JavaDslTest.java):

```java
List users = Http.forUrl("https://jsonplaceholder.typicode.com/users")
        .get().json().asList();
Match.that(users.get(0)).contains("{ name: 'Leanne Graham' }").isTrue();
String city = Json.of(users).get("$[0].address.city");
assertEquals("Gwenborough", city);
```