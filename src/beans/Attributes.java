package beans;

public class Attributes {
	
	@Override
	public String toString() {
		return "Attributes [attributeId=" + attributeId + ", attributeName="
				+ attributeName + ", datas=" + datas + "]";
	}
	private int attributeId;
	private String attributeName;
	private String datas;
	
	
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	public String getDatas() {
		return datas;
	}
	public void setDatas(String datas) {
		this.datas = datas;
	}

}
