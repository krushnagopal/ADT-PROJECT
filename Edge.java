import java.util.Collections;
import java.util.Comparator;
// compartor class


public class Edge {
  private Vertex start;
  private Vertex end;
  public boolean block;
  public String color;
  
  public Edge(Vertex startV, Vertex endV)  {
    this.start = startV;
    this.end = endV;
    
  }
  public Edge(Vertex startV, Vertex endV, String color)  {
	    this.start = startV;
	    this.end = endV;
	    block = false;
	    this.color = color;
	  }
    
  public Vertex getStart() {
    return this.start;
  }
    
  public Vertex getEnd() {
    return this.end;
  }
  public int getEndtype() {
	    return this.end.type;
	  }


  

    
}
