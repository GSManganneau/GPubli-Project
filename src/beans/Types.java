package beans;

import java.util.ArrayList;
import java.util.List;

public class Types {
	private int typeId;
	private String name;
	private List<Attributes> attributes = new ArrayList<Attributes>();
	
	public List<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
