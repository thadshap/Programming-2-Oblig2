package stud.ntnu.idatt2001.Oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BasicMembershipTest {

    @Test
    @DisplayName("register bonus points with positive points")
    void registerPointsPositive() {
        BasicMembership basicMembership = new BasicMembership();
        assertEquals(20000,basicMembership.registerPoints(15000,5000));
    }

    @Test
    @DisplayName("register bonus points with negative points")
    void registerPointsNegative() {
        BasicMembership basicMembership = new BasicMembership();
        assertEquals(10000,basicMembership.registerPoints(15000,-5000));
    }

    @Test
    @DisplayName("check the membership level with expected membership level.")
    void getMembershipNameExpected() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        assertEquals("Basic",member.getMembershipLevel());
    }

    @Test
    @DisplayName("check the membership level with not expected membership level.")
    void getMembershipNameUnexpected() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 24999, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        assertNotEquals("Silver",member.getMembershipLevel());
        assertNotEquals("Gold",member.getMembershipLevel());
    }

    @Test
    void testToString() {
    }
}