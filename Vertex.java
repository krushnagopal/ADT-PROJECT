import java.awt.List;
import java.util.ArrayList;

 
public class Vertex {
  private String data;
  public int type;
  private ArrayList<Edge> edges;
  private ArrayList<Edge> edges2;
  private ArrayList<Edge> edgesOpposite;
  private ArrayList<Edge> edgesOpposite2;
  private ArrayList<Edge> greenDirectedEdges;
  
  private ArrayList<Edge> directededges;
  public Vertex(String inputData,int type) {
    this.data = inputData;
    this.type = type;
    this.edges = new ArrayList<Edge>();
    this.edges2 = new ArrayList<Edge>();
    this.edgesOpposite = new ArrayList<Edge>();
    this.edgesOpposite2 = new ArrayList<Edge>();
    this.directededges = new ArrayList<Edge>();
    this.greenDirectedEdges = new ArrayList<Edge>();
  }
  
 
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
  public void addOppositeEdge(Vertex endVertex) {
	  int c =0;
	  int k=0;
	  for(Edge a: edgesOpposite)
	  {
		  if(endVertex.type<a.getEndtype())
		  {
			  this.edgesOpposite.add(c,new Edge(this, endVertex));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {
		  
		  //System.out.println("adding at last"+ endVertex.type);
		  this.edgesOpposite.add(new Edge(this, endVertex));
		  //this.edgesOpposite2.add(new Edge(this, endVertex));
	  }
    
  }
  public void addOppositeEdge2(Vertex endVertex) {
	  int c =0;
	  int k=0;
	  for(Edge a: edgesOpposite2)
	  {
		  if(endVertex.type<a.getEndtype())
		  {
			  this.edgesOpposite2.add(c,new Edge(this, endVertex));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {
		  this.edgesOpposite2.add(new Edge(this, endVertex));
	  }
    
  }
  public void addEdge2(Vertex endVertex) {
	  int c =0;
	  int k=0;
	  for(Edge a: edges2)
	  {
		  if(endVertex.type<a.getEndtype())
		  {
			  //System.out.println("adding at "+c);
			  this.edges2.add(c,new Edge(this, endVertex));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {
		  
		  //System.out.println("adding at last"+ endVertex.type);
		  this.edges2.add(new Edge(this, endVertex));
	  }
    
  }
  //To add the edges into directed edges class
  public void adddEdge(Vertex endVertex) {
	  int c =0;
	  int k=0;
	  
	  for(Edge a: directededges)
	  {
		  if(endVertex.type<a.getEndtype())
		  {
			  //System.out.println(this.data+" adding at "+c);
			  this.directededges.add(c,new Edge(this, endVertex));
			  k=1;
			  break;
		  }
		  c++;
	  }
	  if(k==0)
	  {
		  
		 // System.out.println(this.data+"  adding at last"+ endVertex.getData());
		  this.directededges.add(new Edge(this, endVertex));
	  }
	  
  }
  public void removeEdge(Vertex endVertex) {
    this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    
  }
  public void removeEdge2(Vertex endVertex) {
	    this.edges2.removeIf(edge -> edge.getEnd().equals(endVertex));
	  }
  public void removeOppositeEdge(Vertex endVertex) {
	    this.edgesOpposite.removeIf(edge -> edge.getEnd().equals(endVertex));
	  }
  public void removeOppositeEdge2(Vertex endVertex) {
	    this.edgesOpposite2.removeIf(edge -> edge.getEnd().equals(endVertex));
	  }
  public void removedEdge(Vertex endVertex) {
	    this.edges.removeIf(directededges -> directededges.getEnd().equals(endVertex));
	  }
  public ArrayList<Edge> getEdges(){
    return this.edges;
  }
  public ArrayList<Edge> getDirectededges(){
	    return this.directededges;
	  }
  public ArrayList<Edge> getEdges2(){
	    return this.edges2;
	  }
  public ArrayList<Edge> getOppositeEdges(){
	    return this.edgesOpposite;
	  }

	  public ArrayList<Edge> getOppositeEdges2(){
		    return this.edgesOpposite2;
		  }
public String getData() {
	// TODO Auto-generated method stub
	return this.data;
}

}
