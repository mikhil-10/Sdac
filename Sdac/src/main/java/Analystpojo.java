public class Analystpojo {
    private String name;
    private String functionality;
    private String performance;
    private String usability;
    private String cost;
    private String value;
    private String environmentalEffect;

    public Analystpojo() {
    }

    public Analystpojo(String name, String functionality, String performance, String usability, String cost, String value, String environmentalEffect) {
        this.name = name;
        this.functionality = functionality;
        this.performance = performance;
        this.usability = usability;
        this.cost = cost;
        this.value = value;
        this.environmentalEffect = environmentalEffect;
    }
	// Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getUsability() {
        return usability;
    }

    public void setUsability(String usability) {
        this.usability = usability;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEnvironmentalEffect() {
        return environmentalEffect;
    }

    public void setEnvironmentalEffect(String environmentalEffect) {
        this.environmentalEffect = environmentalEffect;
    }
}

