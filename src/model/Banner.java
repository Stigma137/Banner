package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Banner {
	private Viewer root;
	private Participant first;
	private Participant last;
	
	public Banner() {
		root = null;
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
    public Viewer searchViewer(String id) throws Exception {
    	return searchV(id, root);
    }
    public Viewer searchV(String id, Viewer aux) throws Exception {
    	if (root == null) {
    		throw new Exception("Error. The three is empty");
    	} else if (aux.getId().compareTo(id) == 0) {
    		return aux;
    	} else if (aux.getId().compareTo(id) > 0) {
    		return searchV(id, aux.getLeft());
    	} else {
    		return searchV(id, aux.getRight());
    	}  
    }
}
