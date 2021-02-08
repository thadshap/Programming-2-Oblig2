package stud.ntnu.idatt2001.Oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoldMembershipTest {

    @Test
    @DisplayName("register bonus points with bonus point balance lower than 90 000")
    void registerPointsLowerThan90000() {
        GoldMembership goldMembership = new GoldMembership();
        assertEquals(81500,goldMembership.registerPoints(75000,5000));
    }

    @Test
    @DisplayName("register bonus points with bonus point balance greater than 90 000")
    void registerPointsGreaterThan90000() {
        GoldMembership goldMembership = new GoldMembership();
        assertEquals(107500,goldMembership.registerPoints(100000,5000));
    }

    @Test
    @DisplayName("register bonus points with new points = 5999 to see how it rounds up")
    void registerPointsWithNewPoints5999() {
        GoldMembership goldMembership = new GoldMembership();
        assertEquals(108999, goldMembership.registerPoints(100000, 5999));
        assertNotEquals(109000, goldMembership.registerPoints(100000, 5999));
    }

    @Test
    @DisplayName("register bonus points with negative points")
    void registerPointsNegative() {
        GoldMembership goldMembership = new GoldMembership();
        assertEquals(85000,goldMembership.registerPoints(90000,-5000));
    }

    @Test
    void getMembershipName() {
    }

    @Test
    void testToString() {
    }
}