package testteam;

import java.util.ArrayList;
import java.util.List;

public class TestTeam {

    public static void main(String[] args) {
        // Create players
        Player player1 = new Player() {
            {
                setFirstName("John");
                setLastName("Doe");
                setPosition("Forward");
                setStatus(0);
            }
        };

        Player player2 = new Player() {
            {
                setFirstName("Jane");
                setLastName("Smith");
                setPosition("Guard");
                setStatus(1);
            }
        };

        Player player3 = new Player(){
            {
                setFirstName("Lionel");
                setLastName("Messi");
                setPosition("Delantero");
                setStatus(0);
            }
        };

        Player player4 = new Player(){
            {
                setFirstName("Cristiano");
                setLastName("Ronaldo");
                setPosition("Delantero");
                setStatus(0);
            }
        };

        // Create a list of players and add the players to the list
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        List<Player> playersSoccer = new ArrayList<>();
        playersSoccer.add(player3);
        playersSoccer.add(player4);

        // Create a team and set its properties
        Team team1 = new Team();
        team1.setPlayers(players);
        team1.setName("Warriors");
        team1.setCity("San Francisco");

        Team team2 = new Team();
        team2.setPlayers(playersSoccer);
        team2.setCity("CDMX");
        team2.setName("America");

        // Display team information
        System.out.println("Team Full Name: " + team1.getFullName());
        System.out.println("Players:");

        for (Player player : team1.getPlayers()) {
            System.out.println(player.playerString() + " - Status: " + player.playerStatus());
        }


        System.out.println("Team Full Name: " + team2.getFullName());
        System.out.println("Players:");

        for (Player player : team2.getPlayers()) {
            System.out.println(player.playerString() + " - Status: " + player.playerStatus());
        }
    }
}
