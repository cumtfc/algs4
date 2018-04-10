package Graph;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.KosarajuSharirSCC;

public class TEST {
    public static void main(String[] args) {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(0,1);
        digraph.addEdge(1,0);
        digraph.addEdge(2,3);
        digraph.addEdge(3,2);
        digraph.addEdge(1,3);
        KosarajuSharirSCC sharirSC = new KosarajuSharirSCC(digraph);
        System.out.println(sharirSC.count());
    }
}
