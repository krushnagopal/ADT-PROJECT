import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
public class Graph {
  public ArrayList<Vertex> vertices;
  
  public int casee;
 
  public Graph(int casee) {
    this.vertices = new ArrayList<Vertex>();
    this.casee = casee;
  }

  public Vertex addVertex(String data,int type) {
    Vertex newVertex = new Vertex(data,type);
    this.vertices.add(newVertex);
    return newVertex;
  }
 
  public void addEdge(Vertex vertex1, Vertex vertex2) {

    vertex1.addEdge(vertex2);
    vertex2.addEdge(vertex1);
    
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
 
  public void removeVertex(Vertex vertex) {
    this.vertices.remove(vertex);
  }
 
  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }
 


  public Vertex getVertexByValue(String value) {
    for(Vertex v: this.vertices) { 
      if (v.getData() == value) {
        return v;
      }
    }
 
    return null;
  }
  public boolean lablecheckgreedy()
  {
	  
	  for(Vertex v: vertices)
	  {
		  
		  v.getEdges2().clear();
	  }
	  if(this.casee == 2)
	  {
		  return true;
	  }else if(this.casee == 3)
	  {
		  
		 int count =0;
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
		 }
	  }else if(this.casee == 1)
	  {
		  ArrayList<Vertex> av = new ArrayList<Vertex>();
			 av.add(this.getVertexByValue("a"));
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
  public void lablinggreedy()
  {
	  ArrayList<Vertex> av = new ArrayList<Vertex>();
		 av.add(this.getVertexByValue("a"));
		 int index =0;
		 while(!av.containsAll(vertices))
		 {
			 
			 Vertex current = av.get(index);
			 while(!current.getEdges().isEmpty())
			 {
				 Edge e = current.getEdges().get(0);
				 current.adddEdge(current.getEdges().get(0).getEnd());
				 removeEdge(current, current.getEdges().get(0).getEnd());
				 av.add(e.getEnd());
				 index++;
				 current = av.get(index);
			 }
			 index++;
		 }
		 for(Vertex v : av)
		 {
			 System.out.print(v.getData() + "  ---->  ");
		 }
  }
}