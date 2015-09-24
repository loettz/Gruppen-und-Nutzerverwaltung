package diesisteinprojekt;

public class User {
	private String name;
	private String givenName;
	private int age;
	private boolean hasGroup;
	private Integer groupID;
	    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getGivenName() {
        return givenName;
    }
    
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public boolean getHasGroup() {
    	return hasGroup;
    }
    
    public void setHasGroup(boolean hasGroup) {
    	this.hasGroup = hasGroup;
    }
    
    public Integer getGroupID() {
    	return groupID;
    }
    
    public void setGroupID(Integer groupID) {
    	if (hasGroup == true) {
    		this.groupID = groupID;
    	}
    	else {
    		this.groupID = null;
    	}
    }

}
