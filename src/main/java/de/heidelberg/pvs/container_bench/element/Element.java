package de.heidelberg.pvs.container_bench.element;

public class Element implements Comparable<Element>{
	
	private String stringID;
	
	private String stringField;
	
	private Integer integerField;
	
	private Long longField;
	
	private Double doubleField;

	/**
	 * Getters and Setters
	 */
	public Double getDoubleField() {
		return doubleField;
	}

	public void setDoubleField(Double doubleField) {
		this.doubleField = doubleField;
	}

	public String getStringField() {
		return stringID;
	}

	public void setStringField(String stringField) {
		this.stringID = stringField;
	}

	public String getStringField2() {
		return stringField;
	}

	public void setStringField2(String stringField2) {
		this.stringField = stringField2;
	}

	public Integer getIntegerField() {
		return integerField;
	}

	public void setIntegerField(Integer integerField) {
		this.integerField = integerField;
	}

	public Long getLongField() {
		return longField;
	}

	public void setLongField(Long longField) {
		this.longField = longField;
	}

	/**
	 * Constructor with fields
	 * 
	 */
	public Element(String stringField, String stringField2, Integer integerField, Long longField, Double doubleField) {
		super();
		this.stringID = stringField;
		this.stringField = stringField2;
		this.integerField = integerField;
		this.longField = longField;
		this.doubleField = doubleField;
	}

	/**
	 * Constructor default
	 */
	public Element() {
		super();
	}

	/**
	 * HasCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doubleField == null) ? 0 : doubleField.hashCode());
		result = prime * result + ((integerField == null) ? 0 : integerField.hashCode());
		result = prime * result + ((longField == null) ? 0 : longField.hashCode());
		result = prime * result + ((stringID == null) ? 0 : stringID.hashCode());
		result = prime * result + ((stringField == null) ? 0 : stringField.hashCode());
		return result;
	}

	/**
	 * Equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		if (doubleField == null) {
			if (other.doubleField != null)
				return false;
		} else if (!doubleField.equals(other.doubleField))
			return false;
		if (integerField == null) {
			if (other.integerField != null)
				return false;
		} else if (!integerField.equals(other.integerField))
			return false;
		if (longField == null) {
			if (other.longField != null)
				return false;
		} else if (!longField.equals(other.longField))
			return false;
		if (stringID == null) {
			if (other.stringID != null)
				return false;
		} else if (!stringID.equals(other.stringID))
			return false;
		if (stringField == null) {
			if (other.stringField != null)
				return false;
		} else if (!stringField.equals(other.stringField))
			return false;
		return true;
	}

	/**
	 * Default ToString just with fields
	 */
	@Override
	public String toString() {
		return "Element [stringID=" + stringID + ", stringField=" + stringField + ", integerField="
				+ integerField + ", longField=" + longField + ", doubleField=" + doubleField + "]";
	}

	@Override
	public int compareTo(Element o) {
		return this.stringID.compareTo(o.stringID);
	}
	

}
