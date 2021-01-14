///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.intuit.karate:karate-core:0.9.9.RC3
//FILES logback.xml

import com.intuit.karate.*;
import java.util.List;

public class javadsl {

    public static void main(String[] args) {
        List users = Http.to("https://jsonplaceholder.typicode.com/users")
                .get().json().asList();
        Match.that(users.get(0)).contains("{ name: 'Leanne Graham' }");
        String city = Json.of(users).get("$[0].address.city");
        Match.that("Gwenborough").isEqualTo(city);
        System.out.println("\n*** second user: " + Json.of(users.get(1)).toString());
    }

}