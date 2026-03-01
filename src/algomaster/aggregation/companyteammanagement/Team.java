package algomaster.aggregation.companyteammanagement;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Employee> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getMembers() {
        return members;
    }

    public void addMember(Employee employee){
        if(!members.contains(employee)){
            members.add(employee);
            employee.addTeam(this);
        } 
    }
    
    /**
     * Methods to dissolve the team
     */
    public void dissolve(){
        //Clear the team reference from each of the employee
        members.stream().forEach(member -> {
            member.removeTeam(this);
        });
        //Clear the members 
        members.clear();
    }

    public int getMemberCount() {
        return members.size();
    }



}
