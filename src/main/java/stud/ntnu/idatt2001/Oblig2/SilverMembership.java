package stud.ntnu.idatt2001.Oblig2;

/**
 * The silver membership is a subclass of membership. The silver membership class provides
 * functionality for registering new bonuspoints and getting the membership name.
 *
 * @version 11.02.2021
 * @author Thadshajini
 */
public class SilverMembership extends Membership{
    private final float POINTS_SCALING_FACTOR = 1.2f;

    /**
     * register points to a member with bounus points balance and new points by the parameter {@code bonusPointBalance} and {@code newPoints}
     * @param bonusPointBalance the the balance the member has allready
     * @param newPoints is the new points the member has earned and is going to be POINTS_SCALING_FACTOR and added to the bounus point balance
     * @return bonus point balance added with the new points POINTS_SCALING_FACTOR.
     */
    public int registerPoints(int bonusPointBalance,int newPoints){
        int silverBounus = (int) Math.round(POINTS_SCALING_FACTOR);
        return bonusPointBalance+(newPoints*silverBounus);
    }

    /**
     * @return "Silver" if your bonus point balance is greater than 25 000 and lower than 75 000.
     */
    public String getMembershipName(){
        return "Silver";
    }

    /**
     * @return "Basic"
     */
    @Override
    public String toString(){
        return getMembershipName();
    }
}
