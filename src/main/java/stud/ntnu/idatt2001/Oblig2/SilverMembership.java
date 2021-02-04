package stud.ntnu.idatt2001.Oblig2;

public class SilverMembership extends Membership{
    private final float POINTS_SCALING_FACTOR = 1.2f;

    public int registerPoints(int bonusPointBalance,int newPoints){
        int silverBounus = (int) Math.round(POINTS_SCALING_FACTOR);
        return bonusPointBalance+(newPoints*silverBounus);
    }

    public String getMembershipName(){
        return "Silver";
    }
}
