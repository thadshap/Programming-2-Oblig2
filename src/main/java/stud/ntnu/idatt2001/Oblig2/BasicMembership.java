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
     * register points to a member with bonus points balance and new points by the parameter {@code bonusPointBalance} and {@code newPoints}
     * @param bonusPointBalance the the balance the member has already
     * @param newPoints is the new points the member has earned and is going to be added to the bonus point balance
     * @return bonus point balance with the new points added
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    /**
     * @return "Basic" if your bonus point balance is lower than 25 000.
     */
    @Override
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

