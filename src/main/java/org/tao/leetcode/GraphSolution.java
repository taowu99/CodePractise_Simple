package org.tao.leetcode;

import java.util.*;

/**
 * Created by zkdu8y8 on 8/24/2016.
 */

//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class GraphSolution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> newNodes = new HashMap();
        return cloneGraph(node, newNodes);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> newNodes) {
        if (node==null)
            return null;
        if (newNodes.containsKey(node.label))
            return newNodes.get(node.label);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        newNodes.put(newNode.label, newNode);
        for (UndirectedGraphNode nbr : node.neighbors) {
            UndirectedGraphNode newNbr;
            if (newNodes.containsKey(nbr.label))
                newNbr = newNodes.get(nbr.label);
            else
                newNbr = cloneGraph(nbr, newNodes);

            newNode.neighbors.add(newNbr);
        }

        return newNode;
    }
}
