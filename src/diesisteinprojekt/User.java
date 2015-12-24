package diesisteinprojekt;

public class User {
	private String name;
	private String givenName;
	private Date birthDate;
	
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
    
    public Date getAge() {
    	return birthDate;
    }
    
    public void setAge(Date birthDate) {
    	this.birthDate = birthDate;
    }
    
    public Group getGroup() {
    	return group;
    }
    
    public void setGroup(Group group) {
    	this.group = group;
    }

}
