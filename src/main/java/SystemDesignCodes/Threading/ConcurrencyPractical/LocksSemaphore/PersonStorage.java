package SystemDesignCodes.Threading.ConcurrencyPractical.LocksSemaphore;

import java.util.HashMap;
import java.util.Map;

/**
 * A mock storage to hold the person objects in a map
 * 
 * @author dinuka.arseculeratne
 * 
 */
public class PersonStorage {

	private Map<Integer, Person> personCache = new HashMap<Integer, Person>();

	private int counter = 0;

	/**
	 * This class is made singleton and hence the constructor is made private
	 */
	private PersonStorage() {

	}

	/**
	 * Bill Pugh's way of lazy initializing the singleton instance
	 * 
	 * @author dinuka.arseculeratne
	 * 
	 */
	private static final class SingletonHolder {
		public static final PersonStorage INSTANCE = new PersonStorage();
	}

	/**
	 * Use this method to get a reference to the singleton instance of
	 * {@link PersonStorage}
	 * 
	 * @return the singleton instance
	 */
	public static PersonStorage getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Inserts the person into the map. Note that we use defensive copying so
	 * that even if the client changes the object later on, those changes will
	 * not be reflected in the object within the map
	 * 
	 * @param person
	 *            the instance of {@link Person} to be inserted
	 * @return the key which signifies the location of the person object
	 * @throws InterruptedException
	 */
	public int putPerson(Person person) throws InterruptedException {

		Person copyPerson = person.copyPerson();
		personCache.put(++counter, copyPerson);

		return counter;
	}

	/**
	 * Here as well we use defensive copying so that the value of the object
	 * reference within the map is not passed in to the calling party.
	 * 
	 * @param id
	 *            the id representing the location of the object within the map
	 * @return the instance of the {@link Person} represented by the key passed
	 *         in
	 * @throws InterruptedException
	 */
	public Person retrievePerson(int id) throws InterruptedException {
		PersonLock.getInstance().getReadLock();
		if (!personCache.containsKey(id)) {
			throw new RuntimeException("Key is not found");
		}
		PersonLock.getInstance().releaseReadLock();
		return personCache.get(id).copyPerson();
	}

}
