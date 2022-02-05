import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args)
	{
		Graph g = new Graph(1);
		g.addVertex("a",0);
		g.addVertex("b",1);
		g.addVertex("c",1);
		g.addVertex("d",0);
		g.addVertex("e",2);
		g.addVertex("f",2);
		g.addVertex("g",2);
		g.addVertex("h",2);
		
		g.addEdge(g.getVertexByValue("a"), g.getVertexByValue("b"));
		g.addEdge(g.getVertexByValue("b"), g.getVertexByValue("c"));
		g.addEdge(g.getVertexByValue("c"), g.getVertexByValue("d"));
		g.addEdge(g.getVertexByValue("d"), g.getVertexByValue("e"));
		g.addEdge(g.getVertexByValue("e"), g.getVertexByValue("f"));
		g.addEdge(g.getVertexByValue("f"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("g"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("g"), g.getVertexByValue("h"));
		g.addEdge(g.getVertexByValue("h"), g.getVertexByValue("d"));
		
		System.out.println(g.lablecheckgreedy());
		g.lablinggreedy(1);
		
		Graph g1 = new Graph(2);
		g1.addVertex("a",0);
		g1.addVertex("b",1);
		g1.addVertex("c",1);
		g1.addVertex("d",0);
		g1.addVertex("e",2);
		g1.addVertex("f",2);
		g1.addVertex("g",2);
		g1.addVertex("h",2);
		
		g1.addEdge(g1.getVertexByValue("a"), g1.getVertexByValue("b"));
		g1.addEdge(g1.getVertexByValue("b"), g1.getVertexByValue("c"));
		g1.addEdge(g1.getVertexByValue("c"), g1.getVertexByValue("d"));
		g1.addEdge(g1.getVertexByValue("d"), g1.getVertexByValue("e"));
		g1.addEdge(g1.getVertexByValue("e"), g1.getVertexByValue("f"));
		g1.addEdge(g1.getVertexByValue("f"), g1.getVertexByValue("a"));
		g1.addEdge(g1.getVertexByValue("g"), g1.getVertexByValue("a"));
		g1.addEdge(g1.getVertexByValue("g"), g1.getVertexByValue("h"));
		g1.addEdge(g1.getVertexByValue("h"), g1.getVertexByValue("d"));
		System.out.println(g1.lablecheckgreedy());
		g1.lablinggreedy(2);
		
		
		}
	
	
}
