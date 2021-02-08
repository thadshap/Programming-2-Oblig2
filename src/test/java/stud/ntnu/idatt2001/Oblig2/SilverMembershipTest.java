package stud.ntnu.idatt2001.Oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SilverMembershipTest {

    @Test
    @DisplayName("register bonus points with positive points")
    void registerPointsPositive() {
        SilverMembership silverMembership = new SilverMembership();
        assertEquals(36000,silverMembership.registerPoints(30000,5000));
    }

    @Test
    @DisplayName("register bonus points with negative points")
    void registerPointsNegative() {
        SilverMembership silverMembership = new SilverMembership();
        assertEquals(25000,silverMembership.registerPoints(30000,-5000));
    }

    @Test
    void getMembershipName() {
    }

    @Test
    void testToString() {
    }
}