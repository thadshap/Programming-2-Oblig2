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

    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress, String password) {
        setMemberNumber(memberNumber);
        setEnrolledDate(enrolledDate);
        setBonusPointsBalance(bonusPointsBalance);
        setName(name);
        setEMailAddress(eMailAddress);
        setPassword(password);
        checkAndSetMembership();
    }

    private void setMemberNumber(int memberNumber){
        if (memberNumber<=0) {
            throw new IllegalArgumentException("You cant't write a negative memberNumber and you have to set a membernumber");
        }
        this.memberNumber = memberNumber;
    }

    private void setEnrolledDate(LocalDate enrolledDate){
        this.enrolledDate=enrolledDate;
    }

    private void setBonusPointsBalance(int bonusPointsBalance){
        if (bonusPointsBalance == 0){
            throw new IllegalArgumentException("You have to register bonuspoints.");
        }
        this.bonusPointsBalance=bonusPointsBalance;
    }

    private void setName(String name){
        if (name == null || name == ""){
            throw new IllegalArgumentException("You have to write the name of the member.");
        }
        this.name = name;
    }

    private void setEMailAddress(String eMailAddress){
        if (eMailAddress == null || eMailAddress == ""){
            throw new IllegalArgumentException("You have to write the member's emailaddress.");
        }
        this.eMailAddress=eMailAddress;
    }

    private void setPassword (String password) {
        if (password == null || password == ""){
            throw new IllegalArgumentException("You have to write a password for your own safety precautions.");
        }
        this.password=password;
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
        this.bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance,newPoints);
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
                ", membershiplevel=" +getMembership()+
                ", name='" + name +
                ", eMailAddress='" + eMailAddress;
    }


}
