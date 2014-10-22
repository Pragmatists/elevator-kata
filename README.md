### Implement elevator class. Requirements:

1. Elevator starts at ground floor
2. Elevator can be in one of the states: "going up", "going down", "waiting", "requires maintenance"
3. After pressing the button, elevator closes doors, and once they are closed, it starts the engine
4. Once requested floor is reached, elevator stops the engine and opens the door
5. Elevator visits floors in order (if pressed buttons are 4,2,5, it will stop in order at 2,4,5)
6. Elevator does not change direction (if it's at 2 floor and going to 4, and at 3 we press 1 it still goes up to 4)
7. If engine breaks, elevator stops and goes into "requires maintenance" state.
8. Elevator in "requires maintenance" state does not react for pressing button
9. If elevator discovers sensor malfunction (e.g. visits floor 3 and then 5 without 4 in the middle) it goes into "requires maintenance" state.
