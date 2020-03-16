package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryHandlerTest {
    QueryHandler queryHandler = new QueryHandler("sadfsdf");

    @Test
    void getContinents() {
        assertEquals(queryHandler.getContinents().get(0), "North America");
    }

    @Test
    void nRegionCountryPop() {
        assertEquals(5, 5);
    }
}