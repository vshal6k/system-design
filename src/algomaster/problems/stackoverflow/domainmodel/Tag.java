package algomaster.problems.stackoverflow.domainmodel;

public class Tag {
    private final String name;
    
    public Tag(String name) {
        this.name = name;
    }

    public String getContent(){
        return name;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Tag tag && tag.name.equals(this.name)){
            return true;
        }else return false;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    public String getName() {
        return name;
    }

}
