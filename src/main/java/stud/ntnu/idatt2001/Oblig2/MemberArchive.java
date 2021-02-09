package stud.ntnu.idatt2001.Oblig2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @version 11.02.2021
 * @author Thadshajini
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        boolean success = false;
        if(!members.containsValue(bonusMember)){
            members.put(bonusMember.getMemberNumber(),bonusMember);
            success = true;
        }
        return success;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        boolean success = false;
        BonusMember member = members.get(memberNumber);
        if (member == null){
            return success;
        }
        member.registerBonusPoints(bonusPoints);
        success = true;

        return success;
    }

    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        for (Map.Entry<Integer,BonusMember> entry : members.entrySet()){
            System.out.print(entry.getValue()+"\n");
        }
    }

    /**
     * Find points to a member with the member number given by the parameter {@code memberNumber}
     * and password given by the parameter @code password}. If no member in the register
     * matches the provided member number or password, {@code false} is returned.
     * @param memberNumber member number to identify the spesific member's points you want to find
     * @param password password checks if it is the member with that membernumber who wants to find their points
     * @return points of the member with the entered membernumber or if the membernumber does not exist or the password is wrong returnes -1
     */
    public int FindPoints(int memberNumber, String password){
        if (members.containsKey(memberNumber)){
            if (members.get(memberNumber).checkPassword(password) == true){
                return members.get(memberNumber).getBonusPointsBalance();
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz", "abcdef234");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz","abcdef234");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no","abcdef234");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org","abcdef234");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com","abcdef234");
        this.members.put(member.getMemberNumber(), member);

    }


}
