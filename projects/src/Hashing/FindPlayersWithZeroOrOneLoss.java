package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPlayersWithZeroOrOneLoss {

    /* Task: You are given an integer array matches where matches[i] = [winneri, loseri] indicates
     that the player winneri defeated player loseri in a match. Return a list answer of size 2
     where:
     answer[0] is a list of all players that have not lost any matches.
     answer[1] is a list of all players that have lost exactly one match.
     The values in the two lists should be returned in increasing order. */

    /* Solution: Create three sets: one for players who haven't lost any matches, one for players
    who have lost exactly one match, and one for players who have lost two or more matches. Iterate
    through the 2D array, and for each 1D array, if the winner of a match isn't already a loser, add
    them to the undefeated set. If the loser hasn't already lost one or more matches, add them to the
    one loss set (and remove them from the undefeated set if they won a match before). If the loser has
    already lost a match, add them to the multiple loss set. Move the contents of the undefeated and
    one loss sets to lists. Sort them, create a list of lists that includes the two structures, and return it.
    */


    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> winnersAndLosers = new ArrayList<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Set<Integer> bigLosers = new HashSet<>();
        for (int[] match: matches) {
            if (!losers.contains(match[0]) && !bigLosers.contains(match[0])) {
                winners.add(match[0]);
            }
            if (!losers.contains(match[1]) && !bigLosers.contains(match[1])) {
                losers.add(match[1]);
                if (winners.contains(match[1])) {
                    winners.remove(match[1]);
                }
            }
            else{
                losers.remove(match[1]);
                bigLosers.add(match[1]);

            }
        }

        List<Integer> winList = new ArrayList<>();
        for (int winner: winners) {
            winList.add(winner);
        }

        List<Integer> loserList = new ArrayList<>();
        for (int loser: losers) {
            loserList.add(loser);
        }

        Collections.sort(winList);
        Collections.sort(loserList);

        winnersAndLosers.add(winList);
        winnersAndLosers.add(loserList);

        return winnersAndLosers;

    }

}
