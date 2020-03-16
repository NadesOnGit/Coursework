import com.napier.sem.QueryHandler;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class QueryHandlerIntegrationTest {
    static QueryHandler handler;

    @BeforeAll
    static void init()
    {
        handler = new QueryHandler("localhost:33060");
    }

    @Test
    void testGetContinents()
    {
        ArrayList<String> continents = new ArrayList<String>();
        continents = handler.getContinents();
        assertEquals("North America", "North America");
    }
}