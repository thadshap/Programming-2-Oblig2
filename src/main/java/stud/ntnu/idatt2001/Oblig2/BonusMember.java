package stud.ntnu.idatt2001.Oblig2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The bonus member registers all the members. It provides
 * functionality to access some information to a member, register new points, check and set membership level and check password.
 *
 * @version 11.02.2021
 * @author Thadshajini
 */
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

    /**
     * Constructor
     * @param memberNumber an unique number which only one member has
     * @param enrolledDate the date when the member get registered
     * @param bonusPointsBalance the bonus points balance to a member
     * @param name the name of the member
     * @param eMailAddress of a member to send any information
     * @param password to secure the membership account and double check if it is the member with that member number
     */
    public BonusMember(int memberNumber, LocalDate enrolledDate, int bonusPointsBalance, String name, String eMailAddress, String password) {
        setMemberNumber(memberNumber);
        setEnrolledDate(enrolledDate);
        setBonusPointsBalance(bonusPointsBalance);
        setName(name);
        setEMailAddress(eMailAddress);
        setPassword(password);
        checkAndSetMembership();
    }

    /**
     * set in the member number of a member and it has to be greater than 0
     * @param memberNumber an unique number which only one member has
     */
    private void setMemberNumber(int memberNumber){
        if (memberNumber<=0) {
            throw new IllegalArgumentException("You can't write a negative memberNumber and you have to set a member number");
        }
        this.memberNumber = memberNumber;
    }

    /**
     * @param enrolledDate the date when the member get registered
     */
    private void setEnrolledDate(LocalDate enrolledDate){
        this.enrolledDate=enrolledDate;
    }

    /**
     * set in the bonus points balance of a member and it has to be greater than 0
     * @param bonusPointsBalance
     */
    private void setBonusPointsBalance(int bonusPointsBalance){
        if (bonusPointsBalance == 0){
            throw new IllegalArgumentException("You have to register bonus points.");
        }
        this.bonusPointsBalance=bonusPointsBalance;
    }

    /**
     * set in name of the member and it can not write anything
     * @param name the name of the member
     */
    private void setName(String name){
        if (name == null || name == ""){
            throw new IllegalArgumentException("You have to write the name of the member.");
        }
        this.name = name;
    }

    /**
     * set in e-mail address of the member and it can not write anything
     * @param eMailAddress of a member to send any information
     */
    private void setEMailAddress(String eMailAddress){
        if (eMailAddress == null || eMailAddress == ""){
            throw new IllegalArgumentException("You have to write the member's emailaddress.");
        }
        this.eMailAddress=eMailAddress;
    }

    /**
     * set in password to access the membership account to the member with the unique member number and it can not write anything
     * @param password to secure the membership account and double check if it is the member with that member number
     */
    private void setPassword (String password) {
        if (password == null || password == ""){
            throw new IllegalArgumentException("You have to write a password for your own safety precautions.");
        }
        this.password=password;
    }

    /**
     * access the member number to athemember
     * @return member number
     */
    public int getMemberNumber() {
        return memberNumber;
    }

    /**
     * access the date of when the member got registered
     * @return date
     */
    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    /**
     * ccess the bonus points balance to the member
     * @return bonus points balance
     */
    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    /**
     * access the name of the member
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * access the e-mail address of the member
     * @return e-mail address
     */
    public String getEMailAddress() {
        return eMailAddress;
    }

    /**
     * access the membership of the member
     * @return membership
     */
    public Membership getMembership() {
        return membership;
    }

    /**
     * A help methode to check if the entered password in the parameter exists/same as the unique members password.
     * @param password to a unique member that is going to be checked
     * @return {@code true} if the password is the same as the password to the unique member,
     *         {@code false} if not
     */
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
    /**
     * register points to a member with bonus points balance and new points by the parameter {@code newPoints}
     * @param newPoints is the new points the member has earned
     * @return bonus point balance with the new points added, but the new points is going to be added differently with
     * bonus point balance based on which membership level the member is
     */
    public void registerBonusPoints(int newPoints){
        this.bonusPointsBalance = membership.registerPoints(this.bonusPointsBalance,newPoints);
        checkAndSetMembership();
    }

    /**
     * A help methode to check and set membership level to a member based on their bonus points balance
     */
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

    /**
     * membership level based on the member's bonus points balance. It is three levels: basic, silver and gold
     * @return membership level
     */
    public String getMembershipLevel(){
        return membership.getMembershipName();
    }

    /**
     * toString methode for the created object of the class.
     * @return memberNumber=(memberNumber), enrolledDate=(enrolledDate), bonusPointsBalance=(bonusPointsBalance),
     *         membership level=(membership level), name=(name), eMailAddress=(eMailAddress)
     */
    @Override
    public String toString() {
        return  "memberNumber=" + memberNumber +
                ", enrolledDate=" + enrolledDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"))+
                ", bonusPointsBalance=" + bonusPointsBalance +
                ", membership level=" +getMembership()+
                ", name='" + name +
                ", eMailAddress='" + eMailAddress;
    }


}
