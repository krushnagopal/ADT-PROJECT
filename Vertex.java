import java.awt.List;
import java.util.ArrayList;

/* Vertex class and its properties */
public class Vertex {
  private String data;
  public int type;
  private ArrayList<Edge> edges;

  private ArrayList<Edge> directededges;
  
  /* Vertex constructor */
  public Vertex(String inputData,int type) {
    this.data = inputData;
    this.type = type;
    this.edges = new ArrayList<Edge>();

    this.directededges = new ArrayList<Edge>();
  }
  
  /* Add Undirected edge */
  public void addEdge(Vertex endVertex) {
	  int c =0;
	  int k=0;
	  for(Edge a: edges)
	  {
		  if(endVertex.type<a.getEndtype())
		  {
			  //System.out.println("adding at "+c);
			  this.edges.add(c,new Edge(this, endVertex));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {
		  
		  //System.out.println("adding at last"+ endVertex.type);
		  this.edges.add(new Edge(this, endVertex));
		  
	  }
    
  }
  
  //To add the edges into directed edges class
  public void adddEdge(Vertex endVertex, String color) {
	  int c =0;
	  int k=0;
	  
	  for(Edge a: directededges)
	  {
		  if(endVertex.type<a.getEndtype())
		  {

			  this.directededges.add(c,new Edge(this, endVertex,color));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {

		  this.directededges.add(new Edge(this, endVertex,color));
	  }
	  
  }
  
  /* Remove Undirected edge */
  public void removeEdge(Vertex endVertex) {
    this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    
  }

  /* Remove directed edge */
  public void removedEdge(Vertex endVertex) {
	    this.edges.removeIf(directededges -> directededges.getEnd().equals(endVertex));
	  }
  
  /* get Undirected edge */
  public ArrayList<Edge> getEdges(){
    return this.edges;
  }
  
  /* get directed edge */
  public ArrayList<Edge> getDirectededges(){
	    return this.directededges;
	  }
  
  /* get data of vertex */
  public String getData() {
	// TODO Auto-generated method stub
	return this.data;
}

}
