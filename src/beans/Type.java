package beans;

public class Type {
	private int type_id;
	private String name;
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Type [type_id=" + type_id + ", name=" + name + "]";
	}

}
