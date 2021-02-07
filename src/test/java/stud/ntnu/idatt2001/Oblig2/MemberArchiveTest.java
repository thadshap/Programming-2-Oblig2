package stud.ntnu.idatt2001.Oblig2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberArchiveTest {

    @Test
    void addMember() {
        MemberArchive memberArchive = new MemberArchive();
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef234");
        assertTrue(memberArchive.addMember(member));
        assertFalse(memberArchive.addMember(member));
    }

    @Test
    @DisplayName("register bonus points with positive points")
    void registerPointsPositive() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        member.registerBonusPoints(10000);
        assertEquals(20000,member.getBonusPointsBalance());
    }

    @Test
    @DisplayName("register bonus points with negative points")
    void registerPointsNegative() {
        BonusMember member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz", "abcdef234");
        member.registerBonusPoints(-10000);
        assertEquals(5000, member.getBonusPointsBalance());
        assertNotEquals(15000, member.getBonusPointsBalance());
    }
    @Test
    void listAllMembers() {
    }

    @Test
    void findPoints() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef123");
        MemberArchive m = new MemberArchive();
        m.addMember(member);
        assertEquals(10000,m.FindPoints(1,"abcdef123"));
        assertEquals(-1,m.FindPoints(1,"abcdef234"));
        assertEquals(-1,m.FindPoints(2,"abcdef123"));
    }
}