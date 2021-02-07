package stud.ntnu.idatt2001.Oblig2;

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

    public String getMembershipName() {
        return "Basic";
    }

    @Override
    public String toString(){
    return getMembershipName();
    }

}

