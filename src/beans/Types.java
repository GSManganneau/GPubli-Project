package beans;

import java.util.ArrayList;
import java.util.List;

public class Types {
	@Override
	public String toString() {
		return "Types [typeId=" + typeId + ", typeName=" + typeName
				+ ", attributes=" + attributes.toString() + "]";
	}
	private int typeId;
	private String typeName;
	private int count;
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
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		// TODO Auto-generated method stub
		this.typeName=typeName;
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	
	
}
