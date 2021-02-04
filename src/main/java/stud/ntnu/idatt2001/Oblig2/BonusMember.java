package stud.ntnu.idatt2001.Oblig2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BonusMember {
    private int memberNumber;
    private LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String eMailAddress;
    private String password;
    private Membership membership;
    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    String formattedDate = enrolledDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolledDate;
        this.bonusPointsBalance = bonusPointsBalance;
        this.name = name;
        this.eMailAddress = eMailAddress;
        membership = new BasicMembership();
        checkAndSetMembership();
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public String getName() {
        return name;
    }

    public String getEMailAddress() {
        return eMailAddress;
    }

    public String getPassword() {
        return password;
    }

    public Membership getMembership() {
        return membership;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void registerBonusPoints(int newPoints){
        int bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance,newPoints);
        checkAndSetMembership();
    }

    private void checkAndSetMembership() {
        if (bonusPointsBalance >= GOLD_LIMIT) {
            membership = new GoldMembership();
        } else if (bonusPointsBalance >= SILVER_LIMIT) {
            membership = new SilverMembership();
        } else {
            membership = new BasicMembership();
        }
    }

    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    @Override
    public String toString() {
        return  "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate +
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", name='" + name +
                ", eMailAddress='" + eMailAddress;
    }
}
