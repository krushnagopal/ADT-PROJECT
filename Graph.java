import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Graph {
  public ArrayList<Vertex> vertices;
  
  public int casee;
 
  public Graph() {
    this.vertices = new ArrayList<Vertex>();
    
  }

  public void setCase(int caseNumber) {
	  casee = caseNumber;
  }
  public Vertex addVertex(String data,int type) {
    Vertex newVertex = new Vertex(data,type);
    this.vertices.add(newVertex);
    return newVertex;
  }
 
  public void addEdge(Vertex vertex1, Vertex vertex2) {
	  // Calling addEdge in vertex class
    vertex1.addEdge(vertex2);
    vertex2.addEdge(vertex1);
    //vertex2.addOppositeEdge(vertex1);
  }
  public void addEdge2(Vertex vertex1, Vertex vertex2) {

	    vertex1.addEdge2(vertex2);
	    vertex2.addEdge2(vertex1);
	    
	  }
  public void removeEdge2(Vertex vertex1, Vertex vertex2) {
	    vertex1.removeEdge2(vertex2);
	    vertex2.removeEdge2(vertex1);
	  }
  public void adddEdge(Vertex vertex1, Vertex vertex2) {
	    vertex1.adddEdge(vertex2);
	  }
  public void removedEdge(Vertex vertex1, Vertex vertex2) {
	    vertex1.removedEdge(vertex2);
	  }
  public void removeEdge(Vertex vertex1, Vertex vertex2) {
    vertex1.removeEdge(vertex2);
 

     vertex2.removeEdge(vertex1);

  }
  public void removeOppositeEdge(Vertex vertex1, Vertex vertex2) {
	    
	 

	     vertex2.removeEdge(vertex1);

	  }
  public void removeOppositeEdge2(Vertex vertex1, Vertex vertex2) {
	    vertex1.removeOppositeEdge2(vertex2);
	 vertex2.removeOppositeEdge2(vertex1);

	  }
  public void removeVertex(Vertex vertex) {
    this.vertices.remove(vertex);
  }
 
  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }
 


  public Vertex getVertexByValue(String value) {
	  
    for(Vertex v: this.vertices) { 
    	
      if (v.getData().equals(value)) {
    	  //System.out.println(v.getData());
        return v;
      }
    }
 
    return null;
  }
  public boolean lablecheckgreedy(String entrance)
  {
	  
	  for(Vertex v: vertices)
	  {
		  
		  v.getEdges2().clear();
	  }
	  if(this.casee == 2)
	  {
		  return true;
	  }else if(this.casee == 3 || this.casee == 1)
	  {
		  
		 /*int count =0;
		 for(Vertex v : vertices)
		 {
			 if(v.getEdges().size()%2!=0)
			 {
				 count++;
			 }
			 
		 }
		 if(count ==0 || count ==2)
		 {
			 return true;
		 }else
		 {
			 return false;
		 }*/
		 
		  
		  
		  //new code
		  ArrayList<Vertex> av = new ArrayList<Vertex>();
			 av.add(this.getVertexByValue(entrance));
			 
			 int index =0;
			 while(!av.containsAll(vertices))
			 {
				// System.out.println("hereeee "+av.get(index).getData());
				 Vertex current = av.get(index);
				// System.out.println("here444 "+current.getData());
				 while(!current.getEdges().isEmpty())
				 {
					 Edge e = current.getEdges().get(0);
					 current.addEdge2(current.getEdges().get(0).getEnd());
					 removeEdge(current, current.getEdges().get(0).getEnd());
					 
					 av.add(e.getEnd());
					 //System.out.println("here in "+e.getEnd().getData());
					 
					 index++;
					 current = av.get(index);
						 //System.out.println("cuu "+current.getData());
					 
				 }
				 if(current.getEdges().isEmpty())
				 {
					 break;
				 }
				 index++;
				 
			 }
			 //System.out.println("here is av");
			 
			 //System.out.println();
			 //System.out.println("last "+av.lastIndexOf(av.get(0)));
			for(Vertex v : av.subList(0, av.lastIndexOf(av.get(0))))
			//this is a loop through all vertices inside a certain path 
			{
				
				if(av.get(av.size()-1).equals(av.get(0)) || av.get(av.size()-1).equals(v))
				{
					correctedges();
					return true;
					
				}
			 } 
			
		//For green path 
			
			
	  }  
	  else if(this.casee == 1)
	  {
		  ArrayList<Vertex> av = new ArrayList<Vertex>();
			 av.add(this.getVertexByValue(entrance));
			 int index =0;
			 while(!av.containsAll(vertices))
			 {
				 
				 Vertex current = av.get(index);
				 
				 while(!current.getEdges().isEmpty())
				 {
					 Edge e = current.getEdges().get(0);
					 current.addEdge2(current.getEdges().get(0).getEnd());
					 removeEdge(current, current.getEdges().get(0).getEnd());
					 av.add(e.getEnd());
					 index++;
					 current = av.get(index);
					 
				 }
				 index++;
				 
			 }
			 
			for(Vertex v : av.subList(0, av.lastIndexOf(av.get(0))))
			//this is a loop through all vertices inside a certain path 
			{
				if(av.get(av.size()-1).equals(av.get(0)) || av.get(av.size()-1).equals(v))
				{
					correctedges();
					return true;
					
				}
			 } 
	  }
	  correctedges();
	  
	return false;
	  
  }
  public void correctedges()
  //This method is to move edges from Edges2 to Edges list
  {
	  for(Vertex v: vertices)
	  {
		  
		  for(Edge e: v.getEdges2())
		  {
			  v.addEdge(e.getEnd());
			  //v.removeEdge2(e.getEnd());
		  }
	  }
  }
  public void lablinggreedy(int lanes,String entrance) 
  // This method is to label and print all the vertices along with edges
  {
	  ArrayList<Edge> dummy = new ArrayList<Edge>();
	  ArrayList<Vertex> av = new ArrayList<Vertex>();
	  ArrayList<Vertex> av2 = new ArrayList<Vertex>();
	  	if(casee == 2)
		 {
			  int greenoneside = lanes/2;
			  int greenotherside = lanes - greenoneside;
			  for(Vertex v: vertices)
			  {
				  for(Edge e : v.getEdges())
				  {
					  if(!dummy.contains(e))
					  {
					  int c=0;
					  
					  while(c<greenoneside)
					  {
					  
					  v.adddEdge(e.getEnd());
					  c++;
					  }
					  c=0;
					  while(c<greenotherside)
					  {
					  e.getEnd().adddEdge(v);
					  c++;
					  }
					  }
					  
				  }
				  for(Edge e : v.getEdges())
				  {
					  removeOppositeEdge(v, e.getEnd());
					  
				  }
				  
				  
			  }
			  
			  for(Vertex v: vertices)
			  {
				  System.out.print(v.getDirectededges().size()+" "+v.getData() + " ----> ");
				  
				  for(Edge e : v.getDirectededges())
				  {
					  
					  System.out.print(e.getEnd().getData() +", ");
					  
				  }
				  System.out.println();
			  }
			  
			  
			  for(Vertex v : av)
				 {
					 System.out.print(v.getData() + "  ---->  ");
				 }
			  for(Vertex v : av2)
				 {
					 System.out.print(v.getData() + "  ---->  ");
				 }
		 }
			  else
			  {
					 av.add(this.getVertexByValue(entrance));
					 int index =0;
					 while(!av.containsAll(vertices))
					 {
						 Vertex current = av.get(index);
						 while(!current.getEdges().isEmpty())
						 {
							 Edge e = current.getEdges().get(0);
							 current.adddEdge(current.getEdges().get(0).getEnd());
							 
							 if(casee == 3)
							 {
								 av2.add(0,current.getEdges().get(0).getEnd());
								 current.getEdges().get(0).getEnd().adddEdge(current);
							 }
							 removeEdge(current, current.getEdges().get(0).getEnd());
							 av.add(e.getEnd());
							 index++;
							 current = av.get(index);
							 
						 }
						 if(current.getEdges().isEmpty())
						 {
							 break;
						 }
						 index++;
						 //System.out.println(current.getData() +" yu"+ index);
					 }
					 if(casee==3)
					 {
						 av2.add(this.getVertexByValue(entrance));
					 }
					 for(Vertex v : av)
					 {
						 System.out.print(v.getData() + "  ---->  ");
					 }
					 System.out.println();
					
					 
					 if(casee==3)
					 {
						 
						 for(Vertex v : av2)
						 {
							 System.out.print(v.getData() + "  ====>  ");
						 }
					 }
					 
					 System.out.println();
					 if(casee ==3) {
						 for(Vertex v : vertices)
						 {
							 
							 for(Edge e : v.getOppositeEdges()) {
								 System.out.print(e.getStart().getData() +"  ====>  "+e.getEnd().getData());
							 }
							 
						 }
						 System.out.println();
					 }
					 
						  
					  
			  }
			  
			  
	 
	
  
}
}
