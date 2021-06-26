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

    public Platoon(String soldierClass, int soldierCount) {
        this.soldierClass = soldierClass;
        this.soldierCount = soldierCount;
    }

    public String getSoldierClass() {
        return soldierClass;
    }

    public Integer getSoldierCount() {
        return soldierCount;
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

}
