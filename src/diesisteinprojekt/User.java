package diesisteinprojekt;

public class User {
	private String name;
	private String givenName;
	private int age;
	
	private Group group;
	//private boolean hasGroup;
	//private Integer groupID;
	    
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
    
    public Group getGroup() {
    	return group;
    }
    
    public void setGroup(Group group) {
    	this.group = group;
    }

}
