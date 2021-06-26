import java.util.Objects;

public class Platoon implements Comparable<Platoon> {
    public static final String MILITIA = "Militia";
    public static final String SPEARMEN = "Spearmen";
    public static final String LIGHT_CAVALRY = "LightCavalry";
    public static final String HEAVY_CAVALRY = "HeavyCavalry";
    public static final String CAVALRY_ARCHER = "CavalryArcher";
    public static final String FOOT_ARCHER = "FootArcher";

    private String soldierClass;
    private Integer soldierCount;
    private Integer battleNo;

    public Platoon(String soldierClass, int soldierCount, int battleNo) {
        this.soldierClass = soldierClass;
        this.soldierCount = soldierCount;
        this.battleNo = battleNo;
    }

    public String getSoldierClass() {
        return soldierClass;
    }

    public void setSoldierClass(String soldierClass) {
        this.soldierClass = soldierClass;
    }

    public Integer getSoldierCount() {
        return soldierCount;
    }

    public void setSoldierCount(Integer soldierCount) {
        this.soldierCount = soldierCount;
    }

    public Integer getBattleNo() {
        return battleNo;
    }

    public void setBattleNo(Integer battleNo) {
        this.battleNo = battleNo;
    }

    @Override
    public int compareTo(Platoon opponent) {
        if (MILITIA.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(SPEARMEN)
                || opponent.getSoldierClass().equalsIgnoreCase(LIGHT_CAVALRY))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        if (SPEARMEN.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(LIGHT_CAVALRY)
                || opponent.getSoldierClass().equalsIgnoreCase(HEAVY_CAVALRY))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        if (LIGHT_CAVALRY.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(FOOT_ARCHER)
                || opponent.getSoldierClass().equalsIgnoreCase(CAVALRY_ARCHER))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        if (HEAVY_CAVALRY.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(MILITIA)
                || opponent.getSoldierClass().equalsIgnoreCase(FOOT_ARCHER)
                || opponent.getSoldierClass().equalsIgnoreCase(LIGHT_CAVALRY))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        if (CAVALRY_ARCHER.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(SPEARMEN)
                || opponent.getSoldierClass().equalsIgnoreCase(HEAVY_CAVALRY))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        if (FOOT_ARCHER.equalsIgnoreCase(this.soldierClass)
                && (opponent.getSoldierClass().equalsIgnoreCase(MILITIA)
                || opponent.getSoldierClass().equalsIgnoreCase(CAVALRY_ARCHER))) {
            return Integer.compare(this.soldierCount * 2, opponent.getSoldierCount());
        }
        return Integer.compare(this.soldierCount, opponent.getSoldierCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Platoon platoon = (Platoon) o;
        return Objects.equals(soldierClass, platoon.soldierClass) && Objects.equals(soldierCount, platoon.soldierCount) && Objects.equals(battleNo, platoon.battleNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soldierClass, soldierCount, battleNo);
    }

    @Override
    public String toString() {
        return "Platoon{" +
                "soldierClass='" + soldierClass + '\'' +
                ", soldierCount=" + soldierCount +
                ", battleNo=" + battleNo +
                '}';
    }
}
