package entity;

public class Fabric {

	private int fabricId;
	private String fabricType;
	private String fiberContent;
	private float yardage;
	private String color;
	
	
	public Fabric(int fabricId, String fabricType, String fiberContent, 
			float yardage, String color) {
		this.setFabricId(fabricId);
		this.setFabricType(fabricType);
		this.setFiberContent(fiberContent);
		this.setYardage(yardage);
		this.setColor(color);
	}


	public int getFabricId() {
		return fabricId;
	}


	public void setFabricId(int fabricId) {
		this.fabricId = fabricId;
	}


	public String getFabricType() {
		return fabricType;
	}


	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}


	public String getFiberContent() {
		return fiberContent;
	}


	public void setFiberContent(String fiberContent) {
		this.fiberContent = fiberContent;
	}


	public float getYardage() {
		return yardage;
	}


	public void setYardage(float yardage) {
		this.yardage = yardage;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

}
