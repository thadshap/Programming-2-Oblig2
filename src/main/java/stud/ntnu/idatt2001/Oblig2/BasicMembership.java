package stud.ntnu.idatt2001.Oblig2;

public class BasicMembership extends Membership{

    public int registerPoints(int bonusPointBalance, int newPoints) {
        return bonusPointBalance + newPoints;
    }

    public String getMembershipName() {
        return "Basic";
    }
}
