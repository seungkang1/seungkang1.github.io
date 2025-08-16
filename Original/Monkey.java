
public class Monkey extends RescueAnimal {
	
	private double tailLength;
	private double height;
	private double bodyLength;
	private String species;
	private String status;
	private String inServiceCountry;
	
	public Monkey(String name, String age, String breed, String trainingStatus, double tailLength, double height, double bodyLength, String species, String gender, String status, String inServiceCountry) {
		super();
		
		this.setName(name);
        this.setAge(age);
        this.setTrainingStatus(trainingStatus);
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
        this.species = species;
        this.setGender(gender);
        this.setStatus(status);
        this.setInServiceCountry(inServiceCountry);
        
		
	}
	
	public double getTailLength() {
		return tailLength;
		
	}
	public double getHeight() {
		return height;
	}
	public double getBodyLength() {
		return bodyLength;
	}
	public String getSpecies() {
		return species;
	}
	public String getStatus() {
		return status;
	}
	public void setTailLength(double tailLength) {
		this.tailLength = tailLength;		
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setBodyLength(double bodyLength) {
		this.bodyLength = bodyLength;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}
	

	@Override
	public String toString() {
		return super.toString() + String.format(", Tail Length: %.2f, Height: %.2f, Body Length: %.2f, Species: %s", tailLength, height, bodyLength, species, status, inServiceCountry);
	            
	}

}
