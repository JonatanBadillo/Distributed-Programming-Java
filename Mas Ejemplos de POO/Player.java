
public abstract class Player {
    private String firstName;
    private String lastName;
    private String position;
    private int status = -1;
    
    public Player(){
        
    }
    
    public Player(String position, int status){
        this.position = position;
        this.status = status;
    }
    
    protected String playerStatus(){
        String returnValue = null;
        
        switch(getStatus()){
                case 0:
                        returnValue = "ACTIVE";
                case 1:
                        returnValue = "INACTIVE";
                case 2:
                        returnValue = "INJURY";
                default:
                        returnValue = "ON_BENCH";
        }
        
        return returnValue;
    }
    
    public String playerString(){
        return getFirstName() + " " + getLastName() + " - " + getPosition();
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if (firstName.length() > 30){
            this.firstName = firstName.substring(0, 29);
        } else {
            this.firstName = firstName;
        }
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }


    // Java Bean es un estandar que hace referencia a la definición de clases de negocio con unos requisitos concretos .

    public class  Team {
        private String name;
        private String city;
        private String stadium;
        private String coach;


        // Debe tener un constructor publico sin parámetros y que sea publico.
        public Team(){
            
        }

        // Propiedades privadas con métodos getters y Setters .
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

    }

    public static void main(String[] args) {
        
    }
}
