package stud.ntnu.idatt2001.Oblig2;

public class GoldMembership extends Membership{
    private final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

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

    public String getMembershipName() {
        return "Gold";
    }

}
