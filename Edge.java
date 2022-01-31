import java.util.Collections;
import java.util.Comparator;
// compartor class


public class Edge {
  private Vertex start;
  private Vertex end;
  
  
  public Edge(Vertex startV, Vertex endV)  {
    this.start = startV;
    this.end = endV;
    
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