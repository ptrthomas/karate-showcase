package jbang;

import com.intuit.karate.*;
import com.intuit.karate.match.Match;
import java.util.List;

/**
 *
 * @author pthomas3
 */
public class JavaDsl {

    public static void main(String[] args) {
        List users = Http.forUrl("https://jsonplaceholder.typicode.com/users")
                .get().json().asList();
        Match.that(users.get(0)).contains("{ name: 'Leanne Graham' }").isTrue();
        String city = Json.of(users).get("$[0].address.city");
        Match.that("Gwenborough").isEqualTo(city).isTrue();
    }

}
