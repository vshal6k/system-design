package algomaster.aggregation.companyteammanagement;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Employee alice = new Employee("Alice", "Engineer");
        Employee bob = new Employee("Bob", "Designer");
        Employee charlie = new Employee("Charlie", "Engineer");

        company.addEmployee(alice);
        company.addEmployee(bob);
        company.addEmployee(charlie);

        Team backend = new Team("Backend");
        Team frontend = new Team("Frontend");

        company.addTeam(backend);
        company.addTeam(frontend);

        // Alice is on both teams
        backend.addMember(alice);
        backend.addMember(charlie);
        frontend.addMember(alice);
        frontend.addMember(bob);

        System.out.println("Before dissolving:");
        System.out.println("  " + alice.getName() + "'s teams: " + alice.getTeamNames());
        System.out.println("  Backend has " + backend.getMemberCount() + " members");
        System.out.println("  Company has " + company.getTeamCount() + " teams, "
                + company.getEmployeeCount() + " employees");

        company.dissolveTeam(backend);

        System.out.println("\nAfter dissolving Backend:");
        System.out.println("  " + alice.getName() + "'s teams: " + alice.getTeamNames());
        System.out.println("  " + charlie.getName() + "'s teams: " + charlie.getTeamNames());
        System.out.println("  Company has " + company.getTeamCount() + " teams, "
                + company.getEmployeeCount() + " employees");
        System.out.println("  " + alice.getName() + " still exists: " + alice.getRole());
    }
}
