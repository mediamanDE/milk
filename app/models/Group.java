package models;

public class Group {

    private int id;
    private String name;
    private String description;

    public void debug() {

        System.out.println("[\n"
                + "id = " + id + ",\n"
                + "name = " + name + ",\n"
                + "description = " + description);
        System.out.println("]");
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
