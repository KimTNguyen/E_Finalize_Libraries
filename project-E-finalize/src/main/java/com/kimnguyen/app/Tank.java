package com.kimnguyen.app;

/**
 * Tank class is created to investigate the cleanup of objects.
 * 
 * @author Kim Nguyen
 * @version %I%, %G%
 * @since 1.0
 *
 */
public class Tank {
	private boolean isFull; // status (empty or full) of the tank
	private static int objectCount = 0; // the number of tanks is created
	private int id; // unique id used to identify the tank

	/**
	 * A constructor is used to instantiate either a full or an empty tank. When
	 * an instance is created, the tank is assigned an unique id and the number
	 * of tanks is kept track.
	 * 
	 * @param isFull
	 *            indicates the tank is full or empty
	 */
	Tank(boolean isFull) {
		this.isFull = isFull;
		id = objectCount;
		++objectCount;
	}

	/**
	 * Gets the total of tanks created during the program
	 * 
	 * @return total number of tanks which is created
	 */
	public static int getObjectCount() {
		return objectCount;
	}

	/**
	 * Gets the id which is an unique number to identify the tank
	 * 
	 * @return the tank's id
	 */
	public int getTankId() {
		return id;
	}

	/**
	 * Verifies the termination condition by reporting the status and
	 * identifying the Tank
	 * 
	 * @throws Exception
	 */
	public void finalize() throws Exception {
		try {
			if (!isFull) {
				System.out.println("Tank " + id + " is: empty");
				System.out.println("Destroy Tank: " + id);
			} else {
				throw new Exception("Tank " + id + " is not empty!");
			}
		} catch (Exception e) {
			System.out.println("Cannot destroy Tank " + id);
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Tank fullTank = new Tank(true);
		Tank emptyTank = new Tank(false);

		System.out.println(fullTank.getTankId());
		System.out.println(emptyTank.getTankId());

		fullTank = emptyTank;

		System.out.println(fullTank.getTankId());
		System.out.println(emptyTank.getTankId());

		System.gc();
		System.out.println("Done");
	}
}
