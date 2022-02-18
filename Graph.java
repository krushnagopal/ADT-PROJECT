
import java.util.*;
 
public class Graph {
  public ArrayList<Vertex> vertices;
  ArrayList<Edge> bridges = new ArrayList<Edge>();
  
  public int casee;
  //public String DIFFENTRANCE EXIT
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
  public void adddEdge(Vertex vertex1, Vertex vertex2,String color) {
	    vertex1.adddEdge(vertex2,color);
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
  
  public void removeVertex(Vertex vertex) {
    this.vertices.remove(vertex);
  }
 
  public ArrayList<Vertex> getVertices() {
    return this.vertices;
  }
 
  public Vertex getVertexByValue(String value) {
	  
    for(Vertex v: this.vertices) { 
    	
      if (v.getData().equals(value)) {
        return v;
      }
    }
 
    return null;
  }
    public void checkforbridges()
  {
	  //ArrayList<Edge> elist = new ArrayList<Edge>();
	  for(Vertex v : vertices)
	  {
		  
		  for(Edge e : v.getEdges())
		  {
			  
			  e.block = true;
			  Stack<Vertex> stack = new Stack<>();
		       ArrayList<Vertex> av = new ArrayList<Vertex>();

		      stack.push(vertices.get(0));
		      Vertex s= vertices.get(0);
		      while(stack.empty() == false)
		      {

		          s = stack.peek();
		          stack.pop();
		          

		          if(!av.contains(s))
		          {
		        	  
		              av.add(s);
		              
		          }
		          
		          for(Edge e1 : s.getEdges())
		          {
		        	  if(!av.contains(e1.getEnd()) && !e1.block)
		        	  {
		        		  stack.push(e1.getEnd());
		        	  }
		          }
		          
		           
		      }
		      
		      if(!av.containsAll(vertices))
		      {
		    	  bridges.add(e);
		      }
		      
		      av.clear();
		      stack.clear();
		      e.block = false;
		  }
	  }
	  
  }
  
  
  
  
  public void lablinggreedy(int lanes,String entrance) 

  {
	  
	  ArrayList<Vertex> av = new ArrayList<Vertex>();
	  ArrayList<Vertex> av2 = new ArrayList<Vertex>();
	  
			  
				  
				  av.add(this.getVertexByValue(entrance));
					 Vertex current = av.get(av.size()-1);
					 checkforbridges();
					 
					 while(!av.containsAll(vertices))
					 {
						
						 while(!current.getEdges().isEmpty())
						 {
							 Edge e = current.getEdges().get(0);
							 
							 current.adddEdge(current.getEdges().get(0).getEnd(),"GREEN");							 
							 if(casee == 3)
							 {
								 av2.add(0,current.getEdges().get(0).getEnd());
								 current.getEdges().get(0).getEnd().adddEdge(current,"RED");
							 }
							 
							 if(casee == 2 && bridges.contains(e))
							 {
								 
								 e.getEnd().adddEdge(current,"GREEN");
								 
							 }
							 
							 removeEdge(current, current.getEdges().get(0).getEnd());
							 av.add(e.getEnd());
							 if(casee == 2 && bridges.contains(e))
							 {
								 
								av.add(e.getStart());
								 
							 }
							 
							 current = av.get(av.size()-1);
							 if(current.getEdges().isEmpty() && !av.containsAll(vertices))
							 {
								 int c=av.size()-1;
								 for( int i = c;i>0;i--)
								 {
									 
									 Vertex v = av.get(i);
									 if(!v.getEdges().isEmpty())
									 {
										current = v;
										av.add(new Vertex(current.getData(),-1));
										av2.add(0,new Vertex(current.getData(),-1));
										break;
									 }
									 if(av.containsAll(vertices))
									 {
										 break;
									 }
								 }
							 }else if(current.getEdges().isEmpty() )
							 {
								 break;
							 }
							 
						 }

					 }
					 if(casee==3 || casee == 2)
					 {
						 av2.add(this.getVertexByValue(entrance));
					 }
					 System.out.println("\nGREEN PATH ");
					 for(Vertex v : av)
					 {
						
						 if(v.type != -1)
						 {
						 System.out.print(v.getData() + "  ---->  ");
						 }else
						 {
							System.out.println(" PATH ALREADY SET");
							System.out.print(v.getData()+"  ====>  ");
						 }
					 }
					 System.out.println();
					
					 
					 if(casee==3)
					 {
						 System.out.println("\nRED PATH");
						 for(Vertex v : av2)
						 {
							 if(v.type != -1)
							 {
							 System.out.print(v.getData() + "  ====>  ");
							 }else
							 {
								 System.out.print(v.getData()+"  ====>  ");
								 System.out.println(" PATH ALREADY SET");
							 }
						 }
					 }
					 
					 System.out.println();
					 System.out.println("Printing Directed edges for every vertex.. ");
					 for(Vertex ve : vertices) {
						 System.out.print(ve.getData()+"---->");
						 for(Edge ed : ve.getDirectededges()) {
							 System.out.print(ed.getEnd().getData()+"("+ed.color+" edge)"+", ");
						 }
						 System.out.println();
					 }
}
  public boolean dfscheck(String value)
  {
	  
	  if(casee==2)
	  {
		  Stack<Vertex> stack = new Stack<>();
	       ArrayList<Vertex> av = new ArrayList<Vertex>();

	      stack.push(vertices.get(0));
	      Vertex s= vertices.get(0);
	      while(stack.empty() == false)
	      {

	          s = stack.peek();
	          stack.pop();
	          

	          if(!av.contains(s))
	          {

	              av.add(s);
	              
	          }
	           

	          for(Edge e1 : s.getEdges())
	          {
	        	  if(!av.contains(e1.getEnd()) && !e1.block)
	        	  {
	        		  stack.push(e1.getEnd());
	        	  }
	          }
	          
	           
	      }
	      
	      if(!av.containsAll(vertices))
	      {
	    	  return false;
	      }
	      
	      av.clear();
	      stack.clear();
	  }else
	  {
		  for(Vertex v : vertices)
		  {
			  
			  for(Edge e : v.getEdges())
			  {
				  
				  e.block = true;
				  Stack<Vertex> stack = new Stack<>();
			       ArrayList<Vertex> av = new ArrayList<Vertex>();

			      stack.push(vertices.get(0));
			      Vertex s= vertices.get(0);
			      while(stack.empty() == false)
			      {

			          s = stack.peek();
			          stack.pop();
			          

			          if(!av.contains(s))
			          {

			              av.add(s);
			              
			          }
			           

			          for(Edge e1 : s.getEdges())
			          {
			        	  if(!av.contains(e1.getEnd()) && !e1.block)
			        	  {
			        		  stack.push(e1.getEnd());
			        	  }
			          }
			          
			           
			      }
			      
			      if(!av.containsAll(vertices))
			      {
			    	  return false;
			      }
			      
			      av.clear();
			      stack.clear();
			      e.block = false;
			  }
		  }
		  
	  }
	  return true;
	  
  }
}
