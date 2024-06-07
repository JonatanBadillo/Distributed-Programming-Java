// Java Bean es un estandar que hace referencia a la definición de clases de
// negocio con unos requisitos concretos .

// Java Bean e Implementar Serializable
import java.io.Serializable;
// Para que una clase se considere un Bean debe implementar el interface Serializable.

public class Team implements Serializable {
    private String name;
    private String city;
    private String stadium;
    private String coach;

    // Debe tener un constructor publico sin parámetros y que sea publico.
    public Team() {

    }

    // Propiedades privadas con métodos getters y Setters .
    // Esa es una de los primeros requerimientos todas las propiedades son privadas
    // y se accede a través de Getters y Setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    // Métodos adicionales como toString() para representación de texto, si se desea
    @Override
    public String toString() {
        return "Team [city=" + city + ", coach=" + coach + ", name=" + name + ", stadium=" + stadium + "]";

    }

    public static void main(String[] args) {
        Team team = new Team();
        team.setName("Real Madrid");
        team.setCity("Madrid");
        team.setStadium("Santiago Bernabeu");
        team.setCoach("Zinedine Zidane");

        System.out.println(team);
    }
}