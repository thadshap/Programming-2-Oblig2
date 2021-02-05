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

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress) {
        setMemberNumber(memberNumber);
        setEnrolledDate(enrolledDate);
        setBonusPointsBalance(bonusPointsBalance);
        setName(name);
        setEMailAddress(eMailAddress);
        checkAndSetMembership();
    }

    private void setMemberNumber(int memberNumber){
        if (memberNumber<=0) {
            throw new IllegalArgumentException("You cant't write a negative memberNumber and you have to set a membernumber");
        }
        this.membership = membership;
    }

    private void setEnrolledDate(LocalDate enrolledDate){
        this.enrolledDate=enrolledDate;
    }

    private void setBonusPointsBalance(int bonusPointsBalance){
        this.bonusPointsBalance=bonusPointsBalance;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setEMailAddress(String eMailAddress){
        this.eMailAddress=eMailAddress;
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
            if (!(this.membership instanceof GoldMembership)) {
                membership = new GoldMembership();
            }
        } else if (bonusPointsBalance >= SILVER_LIMIT) {
            if (!(this.membership instanceof SilverMembership)) {
                membership = new SilverMembership();
            }
        } else {
            if (!(this.membership instanceof BasicMembership)) {
                membership = new BasicMembership();
            }
        }
    }

    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    @Override
    public String toString() {
        return  "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"))+
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", membershiplevel=" +getMembershipLevel()+
                ", name='" + name +
                ", eMailAddress='" + eMailAddress;
    }
}
