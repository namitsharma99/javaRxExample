package demoFromZaneAcademy.take1;

public class AVariable {

	private String varName;
	private Double varValue;

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public Double getVarValue() {
		return varValue;
	}

	public void setVarValue(Double varValue) {
		this.varValue = varValue;
	}

	public AVariable(String varName, Double varValue) {
		this.varName = varName;
		this.varValue = varValue;
	}

}
