package algomaster.aggregation.companyteammanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private String role;
    private List<Team> teams = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void addTeam(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
            team.addMember(this);
        }
    }

    public void removeTeam(Team team) {
        if (teams.contains(team)) {
            teams.remove(team);
        }
    }

    public String getTeamNames() {
        return teams.stream().map(team -> team.getName()).collect(Collectors.joining(","));
    }
}
