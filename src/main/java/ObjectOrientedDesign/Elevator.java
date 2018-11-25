package ObjectOrientedDesign;

/**
 * Created by hadoop on 26/10/17.
 */
public class Elevator {
}
/*
Elevator
First there is an elevator class.
It has a direction (up, down, stand, maintenance),
a current floor and
a list of floor requests sorted in the direction.
It receives request from this elevator.
ElevatorState
doors
Passenger it has boarded, also we need to have addPassenger function, and load it can take
Bank or ElevatorController
Then there is a bank. It contains the elevators and receives the requests from the floors. These are scheduled to all active elevators (not in maintenance).
The scheduling will be like:
if available pick a standing elevator for this floor.
else pick an elevator moving to this floor.
else pick a standing elevator on an other floor.
else pick the elevator with the lowest load.

Each elevator has a set of states.
Maintenance: the elevator does not react to external signals (only to its own signals).
Stand: the elevator is fixed on a floor. If it receives a call. And the elevator is on that floor, the doors open. If it is on another floor, it moves in that direction.
Up: the elevator moves up. Each time it reaches a floor, it checks if it needs to stop. If so it stops and opens the doors. It waits for a certain amount of time and closes the door (unless someting is moving through them. Then it removes the floor from the request list and checks if there is another request. If so the elevator starts moving again. If not it enters the state stand.
Down: like up but in reverse direction.
 */