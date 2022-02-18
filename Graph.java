
import java.util.*;

/* Graph class with properties of class */
public class Graph {
  public ArrayList<Vertex> vertices;
  ArrayList<Edge> bridges = new ArrayList<Edge>();
  
  /* */
  public int casee;
  
  
  /* Graph constructor */
  public Graph() {
    this.vertices = new ArrayList<Vertex>();
  }

  /* set case 1 or 2 or 3  */
  public void setCase(int caseNumber) {
	  casee = caseNumber;
  }
  
  /* add vertex to the graph */
  public Vertex addVertex(String data,int type) {
    Vertex newVertex = new Vertex(data,type);
    this.vertices.add(newVertex);
    return newVertex;
  }
 
  /* add Undirected edge */
  public void addEdge(Vertex vertex1, Vertex vertex2) {

    vertex1.addEdge(vertex2);
    vertex2.addEdge(vertex1);

  }
  
  /* add directed edge */
  public void adddEdge(Vertex vertex1, Vertex vertex2,String color) {
	    vertex1.adddEdge(vertex2,color);
	  }
  
  /* add remove directed edge */
  public void removedEdge(Vertex vertex1, Vertex vertex2) {
	    vertex1.removedEdge(vertex2);
	  }
  
  /* add remove Undirected edge */
  public void removeEdge(Vertex vertex1, Vertex vertex2) {
    vertex1.removeEdge(vertex2);
    vertex2.removeEdge(vertex1);

  }

  /* Remove vertex from the graph*/
  public void removeVertex(Vertex vertex) {
    this.vertices.remove(vertex);
  }
 

  /* get vertex with the help of its data */
  public Vertex getVertexByValue(String value) {
	  
    for(Vertex v: this.vertices) { 
    	
      if (v.getData().equals(value)) {
        return v;
      }
    }
 
    return null;
  }
  
  /* Check if graph has any edges which are bridges and store them in list bridge */
  public void checkforbridges()
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
		    	  bridges.add(e);
		      }
		      
		      av.clear();
		      stack.clear();
		      e.block = false;
		  }
	  }
	  
  }
  
  
  
  /*Label your graph according to case number */
  public void lablinggreedy(String entrance) 

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
  
  
  /*check if graph is connected or not for case 2 and if graph has bridges or not for case 1 and 3*/
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
