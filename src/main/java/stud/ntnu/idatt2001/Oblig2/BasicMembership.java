package stud.ntnu.idatt2001.Oblig2;

/**
 * The basic membership is a subclass of membership. The basic membership class provides
 * functionality for registering new bonuspoints and getting the membership name.
 *
 * @version 11.02.2021
 * @author Thadshajini
 */
public class BasicMembership extends Membership{

    /**
     * register points to a member with bounus points balance and new points by the parameter {@code bonusPointBalance} and {@code newPoints}
     * @param bonusPointBalance the the balance the member has allready
     * @param newPoints is the new points the member has earned and is going to be added to the bounus point balance
     * @return bonus point balance with the new points added
     */
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * @return "Basic" if your bonus point balance is lower than 25 000.
     */
    public String getMembershipName() {
        return "Basic";
    }

    /**
     * @return "Basic"
     */
    @Override
    public String toString(){
    return getMembershipName();
    }

}

