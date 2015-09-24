package diesisteinprojekt;

import java.util.ArrayList;

public class Group {
	private String name;
	private Integer groupID;
	private ArrayList members;
	// ToDo bnlabla
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getGroupID() {
		return groupID;
	}
	
	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}
	
	public ArrayList getGroup() {
		return members;
	}
	
	public void setGroup(ArrayList members) {
		this.members = members;
	}

}
