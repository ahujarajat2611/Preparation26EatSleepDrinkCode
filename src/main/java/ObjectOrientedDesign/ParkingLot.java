package ObjectOrientedDesign;

/**
 * Created by hadoop on 26/10/17.
 */
public class ParkingLot {
}
/*
Here is a quick publish to get the gears turning...

ParkingLot is a class.

ParkingSpace is a class.

ParkingSpace has an Entrance.

Entrance has a location or more specifically, distance from Entrance.

ParkingLotSign is a class.

ParkingLot has a ParkingLotSign.

ParkingLot has a finite number of ParkingSpaces.

HandicappedParkingSpace is a subclass of ParkingSpace.

RegularParkingSpace is a subclass of ParkingSpace.

CompactParkingSpace is a subclass of ParkingSpace.

ParkingLot keeps array of ParkingSpaces, and a separate array of vacant ParkingSpaces in order of distance from its Entrance.

ParkingLotSign can be told to display "full", or "empty", or "blank/normal/partially occupied" by calling .Full(), .Empty() or .Normal()

Parker is a class.

Parker can Park().

Parker can Unpark().

Valet is a subclass of Parker that can call ParkingLot.FindVacantSpaceNearestEntrance(), which returns a ParkingSpace.

Parker has a ParkingSpace.

Parker can call ParkingSpace.Take() and ParkingSpace.Vacate().

Parker calls Entrance.Entering() and Entrance.Exiting() and ParkingSpace notifies ParkingLot when it is taken or vacated so that ParkingLot can determine if it is full or not. If it is newly full or newly empty or newly not full or empty, it should change the ParkingLotSign.Full() or ParkingLotSign.Empty() or ParkingLotSign.Normal().

HandicappedParker could be a subclass of Parker and CompactParker a subclass of Parker and RegularParker a subclass of Parker. (might be overkill, actually.)

In this solution, it is possible that Parker should be renamed to be Car.



 */
/*
public class ParkingLotAgain
{
    Vector<ParkingSpace> vacantParkingSpaces = null;
    Vector<ParkingSpace> fullParkingSpaces = null;

    int parkingSpaceCount = 0;

    boolean isFull;
    boolean isEmpty;

    ParkingSpace findNearestVacant(ParkingType type)
    {
        Iterator<ParkingSpace> itr = vacantParkingSpaces.iterator();

        while(itr.hasNext())
        {
            ParkingSpace parkingSpace = itr.next();

            if(parkingSpace.parkingType == type)
            {
                return parkingSpace;
            }
        }
        return null;
    }

    void parkVehicle(ParkingType type, Vehicle vehicle)
    {
        if(!isFull())
        {
            ParkingSpace parkingSpace = findNearestVacant(type);

            if(parkingSpace != null)
            {
                parkingSpace.vehicle = vehicle;
                parkingSpace.isVacant = false;

                vacantParkingSpaces.remove(parkingSpace);
                fullParkingSpaces.add(parkingSpace);

                if(fullParkingSpaces.size() == parkingSpaceCount)
                    isFull = true;

                isEmpty = false;
            }
        }
    }

    void releaseVehicle(Vehicle vehicle)
    {
        if(!isEmpty())
        {
            Iterator<ParkingSpace> itr = fullParkingSpaces.iterator();

            while(itr.hasNext())
            {
                ParkingSpace parkingSpace = itr.next();

                if(parkingSpace.vehicle.equals(vehicle))
                {
                    fullParkingSpaces.remove(parkingSpace);
                    vacantParkingSpaces.add(parkingSpace);

                    parkingSpace.isVacant = true;
                    parkingSpace.vehicle = null;

                    if(vacantParkingSpaces.size() == parkingSpaceCount)
                        isEmpty = true;

                    isFull = false;
                }
            }
        }
    }

    boolean isFull()
    {
        return isFull;
    }

    boolean isEmpty()
    {
        return isEmpty;
    }
}

public class ParkingSpace
{
    boolean isVacant;
    Vehicle vehicle;
    ParkingType parkingType;
    int distance;
}

public class Vehicle
{
    int num;
}

public enum ParkingType
{
    REGULAR,
    HANDICAPPED,
    COMPACT,
    MAX_PARKING_TYPE,
}




 */
/*
package com.interview.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

abstract class Vehicle {

}

class Motorcycle extends Vehicle {

}

class Car extends Vehicle {

}

class Bus extends Vehicle {

}

abstract class Slot {

	private boolean isOccupied;
	private int slotNumber;

	Slot(int slotNumber) {
		isOccupied = false;
		this.slotNumber = slotNumber;
	}

	boolean isOccupied() {
		return isOccupied;
	}

	int getSlotNumber() {
		return slotNumber;
	}

	void park() {
		isOccupied = true;
	}

	void unPark() {
		isOccupied = false;
	}

	@Override
	public boolean equals(Object o) {
		return (((Slot) o).slotNumber == this.slotNumber);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + this.slotNumber;
		return hash;
	}

}

class SmallSlot extends Slot {
	SmallSlot(int slotNumber) {
		super(slotNumber);
	}
}

class CompactSlot extends Slot {
	CompactSlot(int slotNumber) {
		super(slotNumber);
	}
}

class LargeSlot extends Slot {
	LargeSlot(int slotNumber) {
		super(slotNumber);
	}
}

public class ParkingLot {

	private static final int NUMBER_OF_SMALL_SLOTS = 10;
	private static final int NUMBER_OF_COMPACT_SLOTS = 10;
	private static final int NUMBER_OF_LARGE_SLOTS = 10;
	public Map<Long, Slot> occupiedSlots;
	private List<Slot> smallSlots;
	private List<Slot> compactSlots;
	private List<Slot> largeSlots;

	public ParkingLot() {
		smallSlots = new ArrayList<>(NUMBER_OF_SMALL_SLOTS);
		compactSlots = new ArrayList<>(NUMBER_OF_COMPACT_SLOTS);
		largeSlots = new ArrayList<>(NUMBER_OF_LARGE_SLOTS);
		createSlots();
		occupiedSlots = new HashMap<>();
	}

	private void createSlots() {

		for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
			smallSlots.add(new SmallSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
			compactSlots.add(new CompactSlot(i));
		}
		for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
			largeSlots.add(new LargeSlot(i));
		}

	}

	public long park(Vehicle vehicle) {

		Slot slot;
		long uniqueToken = -1;

		if (vehicle instanceof Motorcycle) {
			if ((slot = getFirstEmptySlot(smallSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else if (vehicle instanceof Car) {
			if ((slot = getFirstEmptySlot(compactSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			} else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		} else {
			if ((slot = getFirstEmptySlot(largeSlots)) != null) {
				uniqueToken = parkHelper(slot, vehicle);
			}
		}
		return uniqueToken;
	}

	public void unPark(long uniqueToken) {
		occupiedSlots.get(uniqueToken).unPark();
		occupiedSlots.remove(uniqueToken);
	}

	private Slot getFirstEmptySlot(List<Slot> slots) {
		Iterator<Slot> slotIterator = slots.iterator();
		boolean isSlotFound = false;
		Slot emptySlot = null;

		while (slotIterator.hasNext() && !isSlotFound) {
			emptySlot = slotIterator.next();
			if (!emptySlot.isOccupied()) {
				isSlotFound = true;
			}
		}
		return emptySlot;
	}

	private long parkHelper(Slot slot, Vehicle vehicle) {
		slot.park();
		long uniqueToken = vehicle.hashCode() * 43;
		occupiedSlots.put(uniqueToken, slot);
		return uniqueToken;
	}
}

 */