package javadsl;

import com.intuit.karate.Http;
import com.intuit.karate.Json;
import com.intuit.karate.match.Match;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author pthomas3
 */
class JavaDslTest {
    
    @Test
    void testRestApi() {        
        List users = Http.forUrl("https://jsonplaceholder.typicode.com/users")
                .get().json().asList();
        Match.that(users.get(0)).contains("{ name: 'Leanne Graham' }").isTrue();
        String city = Json.of(users).get("$[0].address.city");
        assertEquals("Gwenborough", city);
        System.out.println("\n*** second user: " + Json.of(users.get(1)).toString());
    }
    
}
