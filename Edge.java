import java.util.Collections;
import java.util.Comparator;
// compartor class

/* Edge graph with its properties*/
public class Edge {
  private Vertex start;
  private Vertex end;
  public boolean block;
  public String color;
  
  /* Edge constructor */
  public Edge(Vertex startV, Vertex endV)  {
    this.start = startV;
    this.end = endV;
    
  }
  /* Edge constructor */
  public Edge(Vertex startV, Vertex endV, String color)  {
	    this.start = startV;
	    this.end = endV;
	    block = false;
	    this.color = color;
	  }
    
  /* Starting vertex */
  public Vertex getStart() {
    return this.start;
  }
  /* Ending vertex */
  public Vertex getEnd() {
    return this.end;
  }
  public int getEndtype() {
	    return this.end.type;
	  }


  

    
}
