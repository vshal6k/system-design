package algomaster.aggregation.companyteammanagement;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Team> teams = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Team> getTeams() {
        return teams;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void dissolveTeam(Team team){
        //Clear out the Employee and Team references
        team.dissolve();
        //Delete the team from company
        this.teams.remove(team);
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void addTeam(Team team) {
        teams.add(team);
    }
    public int getTeamCount() {
        return this.teams.size();
    }
    public int getEmployeeCount() {
        return this.employees.size();
    }

}
