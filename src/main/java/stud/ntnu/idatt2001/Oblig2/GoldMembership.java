package stud.ntnu.idatt2001.Oblig2;

/**
 * The gold membership is a subclass of membership. The gold membership class provides
 * functionality for registering new bonuspoints and getting the membership name.
 *
 * @version 11.02.2021
 * @author Thadshajini
 */
public class GoldMembership extends Membership{
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    /**
     * register points to a member with bounus points balance and new points by the parameter {@code bonusPointBalance} and {@code newPoints}
     * @param bonusPointBalance the the balance the member has allready
     * @param newPoints is the new points the member has earned
     * @return bonus point balance added with the new points multiplied with POINTS_SCALING_FACTOR1 if the
     * bounus point balance of the member is less that 90 000, or if the balance is greater that 90 000
     * the new points will be miltiplied with POINTS_SCALING_FACTOR2.
     */
    public int registerPoints(int bonusPointBalance, int newPoints) {
        if(bonusPointBalance<90000){
            int silverBounus1 = (int) Math.round(POINTS_SCALING_FACTOR_LEVEL_1);
            return bonusPointBalance+(newPoints*silverBounus1);
        }
        else{
            int silverBounus2 = (int) Math.round(POINTS_SCALING_FACTOR_LEVEL_2);
            return bonusPointBalance + (newPoints * silverBounus2);
        }
    }

    /**
     * @return "Gold" if your bonus point balance is lower than 25 000.
     */
    public String getMembershipName() {
        return "Gold";
    }

    /**
     * @return "Gold"
     */
    @Override
    public String toString(){
        return getMembershipName();
    }

}
