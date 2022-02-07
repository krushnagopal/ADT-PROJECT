import java.io.*;
public class Case3main {
	public static void main(String[] args)
	{
		/*Graph g = new Graph(3);
		g.addVertex("z",0);
		g.addVertex("a",1);
		g.addVertex("b",1);
		g.addVertex("c",1);
		g.addVertex("d",1);
		g.addVertex("e",1);
		g.addVertex("f",1);
		
		
		//g.addVertex("i",2);
		g.addEdge(g.getVertexByValue("z"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("a"), g.getVertexByValue("b"));
		g.addEdge(g.getVertexByValue("b"), g.getVertexByValue("c"));
		g.addEdge(g.getVertexByValue("c"), g.getVertexByValue("d"));
		g.addEdge(g.getVertexByValue("d"), g.getVertexByValue("e"));
		g.addEdge(g.getVertexByValue("e"), g.getVertexByValue("f"));
		g.addEdge(g.getVertexByValue("f"), g.getVertexByValue("z"));*/
		
		
		/*g.addEdge(g.getVertexByValue("z"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("a"), g.getVertexByValue("b"));
		g.addEdge(g.getVertexByValue("b"), g.getVertexByValue("c"));
		g.addEdge(g.getVertexByValue("c"), g.getVertexByValue("d"));
		g.addEdge(g.getVertexByValue("d"), g.getVertexByValue("e"));
		g.addEdge(g.getVertexByValue("e"), g.getVertexByValue("f"));
		g.addEdge(g.getVertexByValue("f"), g.getVertexByValue("z"));*/
		
		
		
		//g.lablingForGreenPath();
		/*
		Graph g = new Graph(3);
		g.addVertex("z",0);
		g.addVertex("a",2);
		g.addVertex("b",2);
		g.addVertex("c",2);
		g.addVertex("d",2);
		g.addVertex("e",2);
		g.addVertex("f",2);
		g.addVertex("g",2);
		g.addVertex("h",2);
		g.addVertex("i",2);
		g.addVertex("j",2);
		g.addVertex("k",2);
		g.addVertex("l",2);
		g.addVertex("m",2);
		g.addVertex("n",2);
		g.addVertex("o",2);
		g.addVertex("x",5);
		
		
		
		//g.addVertex("i",2);
		g.addEdge(g.getVertexByValue("z"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("a"), g.getVertexByValue("b"));
		g.addEdge(g.getVertexByValue("b"), g.getVertexByValue("c"));
		g.addEdge(g.getVertexByValue("c"), g.getVertexByValue("d"));
		g.addEdge(g.getVertexByValue("d"), g.getVertexByValue("e"));
		g.addEdge(g.getVertexByValue("e"), g.getVertexByValue("f"));
		g.addEdge(g.getVertexByValue("f"), g.getVertexByValue("g"));
		g.addEdge(g.getVertexByValue("g"), g.getVertexByValue("h"));
		g.addEdge(g.getVertexByValue("h"), g.getVertexByValue("i"));
		g.addEdge(g.getVertexByValue("i"), g.getVertexByValue("j"));
		g.addEdge(g.getVertexByValue("j"), g.getVertexByValue("k"));
		g.addEdge(g.getVertexByValue("k"), g.getVertexByValue("l"));
		g.addEdge(g.getVertexByValue("l"), g.getVertexByValue("m"));
		g.addEdge(g.getVertexByValue("m"), g.getVertexByValue("n"));
		g.addEdge(g.getVertexByValue("n"), g.getVertexByValue("l"));
		g.addEdge(g.getVertexByValue("l"), g.getVertexByValue("o"));
		g.addEdge(g.getVertexByValue("o"), g.getVertexByValue("a"));
		g.addEdge(g.getVertexByValue("a"), g.getVertexByValue("x"));
		g.addEdge(g.getVertexByValue("x"), g.getVertexByValue("z"));
		
		
		
		
		
		for(Vertex v :g.vertices) {
			for(Edge e : v.getEdges()) {
				System.out.println(e.getStart().getData()+"  ---> "+e.getEnd().getData());
			}
			
		}
		
		System.out.println(g.lablecheckgreedy());
		
		g.lablinggreedy(7);*/
		for(int i=1;i<4;i++) {
		Graph g = new Graph();
		String entrance;
		
		BufferedReader l_reader;
		try {
			l_reader = new BufferedReader(new FileReader("C:/Users/Home/eclipse-workspace/AlgoProject/src/Input.txt"));
			String pointer;
			while ((pointer = l_reader.readLine()) != null) {

				if (pointer.equals("vertices")) {
					String value = l_reader.readLine();
					while(!value.equals("end")) {
						String v = value;
						//System.out.println("pointer "+v);
						int priority = 0;
						if(v.equalsIgnoreCase("Z")) {
							priority = 1;
							
						}
						else if (v.equalsIgnoreCase("X")) {
							priority = 5;
							
						}
						else{
							priority = 2;
						}
						g.addVertex(v,priority);
						value = l_reader.readLine();
					}
					pointer = value;
				}

				if(pointer.equalsIgnoreCase("edges")) {
					String value = l_reader.readLine();

					while(value!= null) {
						String e[] = value.split(",");
						//System.out.println(e[0]);
						g.addEdge(g.getVertexByValue(e[0]), g.getVertexByValue(e[1]));
						value = l_reader.readLine();
					}
				}


			}
			l_reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
			g.setCase(i);
			boolean result = g.lablecheckgreedy("Z");
			System.out.println("Output for Case "+i);
			if (result) {
				System.out.println("The graph represents a one-way street problem");
			}else {
				System.out.println("The graph does not represent a one-way street problem");
			}
			
			g.lablinggreedy(3,"Z");
		}
		
		
	}
}
