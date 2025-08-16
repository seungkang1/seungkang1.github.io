public class Monkey extends RescueAnimal {

    private double tailLength;
    private double height;
    private double bodyLength;
    private String species;
    private String status;

    // Constructor
    public Monkey(String name, String species, String gender, String age,
                  String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry) {
        super();
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setStatus("in service"); 
    }

    // Getters and setters
    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
