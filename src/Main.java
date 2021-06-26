import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Set<List<Platoon>> lostCache = new HashSet<>();

    public static void main(String[] args) throws IOException {

/* Sample input - Winning chance
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
*/
/* Sample input - No chance
Spearmen#1;Militia#1;FootArcher#1;LightCavalry#1;HeavyCavalry#1
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Platoon> ownListOfPlatoons = getListOfPlatoons(br.readLine().split(";"));
        List<Platoon> opponentListOfPlatoons = getListOfPlatoons(br.readLine().split(";"));

        List<Platoon> winningListOfPlatoons = getWinningListOfPlatoonsInOrder(ownListOfPlatoons, opponentListOfPlatoons);
        if (null != winningListOfPlatoons)
            System.out.println(winningListOfPlatoons.stream().map(platoon -> platoon.getSoldierClass() + "#" + platoon.getSoldierCount()).collect(Collectors.joining(";")));
        else
            System.out.println("There is no chance of winning");
    }

    private static List<Platoon> getWinningListOfPlatoonsInOrder(List<Platoon> ownListOfPlatoons, List<Platoon> opponentListOfPlatoons) {
        if (lostCache.contains(ownListOfPlatoons)) {
            getNextOrder(ownListOfPlatoons);
            getWinningListOfPlatoonsInOrder(ownListOfPlatoons, opponentListOfPlatoons);
        }

        lostCache.add(ownListOfPlatoons);
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if ((ownListOfPlatoons.get(i).compareTo(opponentListOfPlatoons.get(i)) > 0)
                    && (opponentListOfPlatoons.get(i).compareTo(ownListOfPlatoons.get(i)) <= 0)) {
                count++;
            }
        }
        if (count >= 3) {
            return ownListOfPlatoons;
        } else {
            if (lostCache.size() < 120) {
                return getWinningListOfPlatoonsInOrder(ownListOfPlatoons, opponentListOfPlatoons);
            } else {
                return null;
            }
        }

    }

    private static void getNextOrder(List<Platoon> ownListOfPlatoons) {
        //TODO Can be modified to return proper permutation
        Collections.shuffle(ownListOfPlatoons);
    }

    private static List<Platoon> getListOfPlatoons(String[] soldierStringArray) {
        List<Platoon> platoons = new ArrayList<>();
        for (int i = 0; i < soldierStringArray.length; i++) {
            String[] data = soldierStringArray[i].split("#");
            platoons.add(new Platoon(data[0], Integer.parseInt(data[1])));
        }
        return platoons;
    }

}
