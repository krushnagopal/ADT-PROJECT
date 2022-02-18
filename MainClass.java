import java.io.*;

/* Main class*/
public class MainClass {
	public static void main(String[] args)
	{
		for(int k=1;k<3;k++) {
			System.out.println("\n========Results for Graph "+k+"========");
		for(int i=1;i<4;i++) {
			Graph g = new Graph();
			String entrance;
			BufferedReader l_reader;
			try {
				if(i==2) {
					l_reader = new BufferedReader(new FileReader("C:/Users/Home/eclipse-workspace/ProjectADT/src/Graph"+k+"Case2.txt"));
				}
				else {
					l_reader = new BufferedReader(new FileReader("C:/Users/Home/eclipse-workspace/ProjectADT/src/Graph"+k+".txt"));
				}
				String pointer;
				while ((pointer = l_reader.readLine()) != null) {

					if (pointer.equals("vertices")) {
						String value = l_reader.readLine();
						while(!value.equals("end")) {
							String v = value;
							
							int priority = 0;
							if(v.equalsIgnoreCase("Z")) {
								priority = 1;
								
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
				
				boolean result = g.dfscheck("Z");
				System.out.println("---------------------------------------------------------------------------------------------------");
				System.out.println("Output for Case "+i);
				System.out.println(result);
				if (result) {
					System.out.println("Labelling exists");
				}else {
					System.out.println("Labelling does not exist");
				}
				g.lablinggreedy("Z");
			}
	}
	}
}
