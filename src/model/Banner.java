package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Banner {
	private Viewer root;
	private Participant first;
	private Participant last;
	
	public Banner() {
		root = null;
	}
	public Participant getFirst() {
		return first;
	}
	public void setFirst(Participant first) {
		this.first = first;
	}
	public Participant getLast() {
		return last;
	}
	public void setLast(Participant last) {
		this.last = last;
	}
	public void loadThree(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null) {
			String[] input = line.split(",");
			String id = input[0];
			String firstName = input[1];
			String lastName = input[2];
			String email = input[3];
			String gender = input[4];
			String ip = input[5];
			String country = input[6];
			String avatar = input[7];
			String birthday = input[8];
			Viewer viewer = new Viewer(id, firstName, lastName, email, avatar, gender, ip, country, birthday);
			try {
				add(viewer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			line = br.readLine();
		}
		selectViewers();
		br.close();
		fr.close();
	}
    public Viewer getRoot() {
		return root;
	}
	public void setRoot(Viewer root) {
		this.root = root;
	}
	public boolean isEmpty(){
        return (root == null);
    }
    
    public void add(Viewer v) throws Exception{
    	root = addViewer(root, v);
    }
    public Viewer addViewer(Viewer aux, Viewer v) throws Exception {
    	if(aux == null) {
    		aux = v;
    	} else if(v.getId().compareTo(aux.getId()) < 0) {
    		Viewer left = addViewer(aux.getLeft(), v);
    		aux.setLeft(left);
    	}else if (v.getId().compareTo(aux.getId()) > 0) {
    		Viewer right = addViewer(aux.getRight(), v);
    		aux.setRight(right);
    	}else {
    		throw new Exception("Existing Viewer with that Id");
    	}
    	return aux;
    }
    
    	
    public int getWeight(Viewer root) {
    	if (root == null) {
    		return 0;
    	} 
    	int counter = 1;
    	if (root.getRight() != null) {
    		counter += getWeight(root.getRight());
    	}
    	if (root.getLeft() != null) {
    		counter += getWeight(root.getLeft());
    	}
    	return counter;
    }
    public Viewer searchViewer(String id) throws Exception {
    	return searchV(id, root);
    }
    public Viewer searchV(String id, Viewer aux) throws Exception {	
    	if (root == null) {
    		throw new Exception("Error. The three is empty");
    	} else if (aux.getId().compareTo(id) == 0) {
    		return aux;
    	} else if(aux.getRight() == null && aux.getLeft() == null) {
    		return null;
    	} else if (aux.getId().compareTo(id) > 0) {
    		return searchV(id, aux.getLeft());
    	} else {
    		return searchV(id, aux.getRight());
    	}
    }
    public Participant searchParticipant(String id) throws Exception {
    	if (first == null) {
    		throw new Exception("Error. The linked list is empty");
    	} Participant aux = first;
    	while(aux != null) {
    	if(aux.getId().compareTo(id) == 0) {
			return aux;
    	} 
    		aux = aux.getNext();
		} 
		return null;
    }
    public void inOrder(Viewer root) {
    	if(root != null) {
    		inOrder(root.getLeft());
    		System.out.print(root.getId() + ", ");
    		inOrder(root.getRight());
    	}
    }
    public void selectViewers() {
		selectViewers(root, getWeight(root)/2 - 1);
	}
	
	private void selectViewers(Viewer current, int limit) {
		if(limit > 0) {
			if(current != null) {
				Random r = new Random();
				if(r.nextBoolean()) {
					addCompetitor(Participant.cast(current));
					delete(root, current);
					limit--;
				}
				selectViewers(current.getLeft(), limit);
				selectViewers(current.getRight(), limit);
			}
		}
	}
	
	public Viewer delete(Viewer current, Viewer esp) {
		if (current == null) {
			return null;
		} else if (current.compareTo(esp) > 0) { // find the node
			current.setLeft(delete(current.getLeft(), esp));
		} else if (current.compareTo(esp) < 0) {
			current.setRight(delete(current.getRight(), esp));
		} else {            
			if (current.getRight() == null) {
				return current.getLeft();    //replace with left child
			} else if (current.getLeft() == null) {
				return current.getRight();   // replace with right child
			} else {                // replace with min from right subtree
				current.replaceData(getMin(current.getRight()));
				current.setRight(delete(current.getRight(), current));
			}
		}
		return current; 
	}
	private Viewer getMin(Viewer current) {
		if(current.getLeft() != null) {
			return getMin(current.getLeft());
		}
		return current;
	}
	public void addCompetitor(Participant c) {
		addCompetitor(c, first);
	}
	
	private void addCompetitor(Participant c, Participant current) {
		if(first == null) {
			first = c;
		} else {
			if(current.getNext() == null) {
				current.setNext(c);
				c.setPrevious(current);
			} else {
				addCompetitor(c, current.getNext());
			}
		}
	}
}
