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

You can run this as a [jbang](https://www.jbang.dev) script as follows: `jbang javadsl.java`

You can also run this directly from github without creating this file locally:

```
jbang https://github.com/ptrthomas/karate-showcase/blob/main/javadsl.java
```

```java
///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.intuit.karate:karate-core:0.9.9.RC2

import com.intuit.karate.*;
import com.intuit.karate.match.Match;
import java.util.List;

public class javadsl {

    public static void main(String[] args) {
        List users = Http.forUrl("https://jsonplaceholder.typicode.com/users")
                .get().json().asList();
        Match.that(users.get(0)).contains("{ name: 'Leanne Graham' }").isTrue();
        String city = Json.of(users).get("$[0].address.city");
        Match.that("Gwenborough").isEqualTo(city).isTrue();
    }

}
```