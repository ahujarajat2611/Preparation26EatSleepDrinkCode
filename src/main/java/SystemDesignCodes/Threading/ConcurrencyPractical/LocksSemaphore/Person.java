package SystemDesignCodes.Threading.ConcurrencyPractical.LocksSemaphore;

/**
 * Data holding object for a person
 * 
 * @author dinuka.arseculeratne
 * 
 */
public class Person {

	private Long id;

	private String name;

	private String address;

	public Person(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person copyPerson() {
		Person copyPerson = new Person(this.getId(), this.getName(),
				this.getAddress());
		return copyPerson;

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
}
