package TreesAndGraphs;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumGeneticMutation {

    /* Task: A gene string can be represented by an 8-character long string, with choices from
     'A', 'C', 'G', and 'T'. Suppose we need to investigate a mutation from a gene string startGene
      to a gene string endGene where one mutation is defined as one single character changed in the
      gene string. For example, "AACCGGTT" --> "AACCGGTA" is one mutation. There is also a gene bank
      that records all the valid gene mutations. A gene must be in bank to make it a valid gene
      string. Given the two gene strings startGene and endGene and the gene bank, return the
      minimum number of mutations needed to mutate from startGene to endGene. If there is no such a
      mutation, return -1. Note that the starting point is assumed to be valid, so it might not be
      included in the bank. */

    /* Solution: Create a visited set, a mutations queue, and a queue for bfs. Add the startGene to
    the bfs queue and the number 0 to the mutations queue. Then - until the bfs queue is empty - remove
    from it (saving the value in a temporary variable), identify all of the possible non-visited
    mutations for the gene in the bank, and add them to the bfs queue (at the same time, add each
    gene's number of mutations from the original startGene to the mutations queue). Upon finding the
    endGene from a bfs removal, return the corresponding removal from the mutations queue. If the
    queue becomes empty before finding the endGene, return -1.*/

    public int minMutation(String startGene, String endGene, String[] bank) {

        Set<String> visited = new HashSet<>();
        Queue<String> bfs = new LinkedList<>();
        bfs.offer(startGene);
        Queue<Integer> muts = new LinkedList<>();
        muts.offer(0);
        while (!bfs.isEmpty()) {
            String temp = bfs.poll();
            int mutations = muts.poll();
            if (temp.equals(endGene)) {
                return mutations;
            }
            for (String gene: bank) {
                int diff = 0;
                for (int i = 0; i < gene.length(); i++) {
                    if (!gene.substring(i, i+1).equals(temp.substring(i, i+1))) {
                        diff++;
                    }
                }
                if (diff == 1 && !visited.contains(gene)){
                    visited.add(gene);
                    bfs.offer(gene);
                    muts.offer(mutations+1);
                }
            }
        }

        return -1;

    }

}
