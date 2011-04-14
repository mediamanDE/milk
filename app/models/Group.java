package models;

import service.MessageService;

public class Group {

    private int id;
    private String name;
    private String description;
    
	/**
	 * @return String representation of the object
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Group [\n");
		sb.append("_id=").append(id).append(",\n");
		sb.append("name=").append(name).append(",\n");
		sb.append("description=").append(description).append("\n]");
		return sb.toString();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
