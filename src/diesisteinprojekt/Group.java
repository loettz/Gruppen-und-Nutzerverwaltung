package diesisteinprojekt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable{
	
	//ToDo Interface Serializable
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int size;
	private ArrayList<User> members;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	
	public ArrayList<User> getGroupList() {
		return members;
	}
	
	public void setGroupList(ArrayList<User> members) {
		this.members = members;
	}
	
	/*public static void saveGroup() {
		Group g = new Group();
		
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/group.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(g);
	         out.close();
	         fileOut.close();
		}catch(IOException i) {
			i.printStackTrace();
		}
	}*/

}
