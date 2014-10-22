Implement elevator class. Requirements:

Elevator starts at ground floor
Elevator can be in one of the states: "going up", "going down", "waiting", "requires maintenance"
After pressing the button, elevator closes doors, and once they are closed, it starts the engine
Once requested floor is reached, elevator stops the engine and opens the door
Elevator visits floors in order (if pressed buttons are 4,2,5, it will stop in order at 2,4,5)
Elevator does not change direction (if it's at 2 floor and going to 4, and at 3 we press 1 it still goes up to 4)
If engine breaks, elevator stops and goes into "requires maintenance" state.
Elevator in "requires maintenance" state does not react for pressing button
If elevator discovers sensor malfunction (e.g. visits floor 3 and then 5 without 4 in the middle) it goes into "requires maintenance" state.
