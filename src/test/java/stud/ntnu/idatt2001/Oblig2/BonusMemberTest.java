package stud.ntnu.idatt2001.Oblig2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusMemberTest {

    @Test
    void getMemberNumber() {
    }

    @Test
    void getEnrolledDate() {
    }

    @Test
    void getBonusPointsBalance() {
    }

    @Test
    void getName() {
    }

    @Test
    void getEMailAddress() {
    }

    @Test
    void getMembership() {
    }

    @Test
    void checkPassword() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        assertTrue(member.checkPassword("abcdef123"));
        assertFalse(member.checkPassword("abcdefg234"));


    }

    @Test
    void registerBonusPoints() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        member.registerBonusPoints(10000);
        assertEquals(20000,member.getBonusPointsBalance());
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz","abcdef234");
        member.registerBonusPoints(-10000);
        assertEquals(5000,member.getBonusPointsBalance());
        assertNotEquals(15000,member.getBonusPointsBalance());
    }

    @Test
    void getMembershipLevel() {
    }

    @Test
    void testToString() {
    }
}