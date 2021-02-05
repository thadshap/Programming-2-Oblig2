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
    }

    @Test
    void registerBonusPoints() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        member.registerBonusPoints(10000);
        assertEquals(20000,member.getBonusPointsBalance());
    }

    @Test
    void getMembershipLevel() {
    }

    @Test
    void testToString() {
    }
}