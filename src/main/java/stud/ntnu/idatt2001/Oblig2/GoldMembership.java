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
     * register points to a member with bonus points balance and new points by the parameter {@code bonusPointBalance} and {@code newPoints}
     * @param bonusPointBalance the the balance the member has already
     * @param newPoints is the new points the member has earned
     * @return bonus point balance added with the new points multiplied with POINTS_SCALING_FACTOR1 if the
     * bonus point balance of the member is less that 90 000, or if the balance is greater that 90 000
     * the new points will be multiplied with POINTS_SCALING_FACTOR2.
     */
    @Override
    public int registerPoints(int bonusPointBalance, int newPoints) {
        if(bonusPointBalance<90000 && newPoints>0){
            return bonusPointBalance + (int) Math.round(newPoints*POINTS_SCALING_FACTOR_LEVEL_1);
        }
        else if(bonusPointBalance>90000 && newPoints>0){
            return bonusPointBalance + (int) Math.round(newPoints*POINTS_SCALING_FACTOR_LEVEL_2);
        }
        else {
            return bonusPointBalance + newPoints;
        }
    }

    /**
     * @return "Gold" if your bonus point balance is lower than 25 000.
     */
    @Override
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
