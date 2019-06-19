/**
 * Created by Aaron on 10/10/2018.
 */

import org.jetbrains.annotations.Nullable;

import java.util.*;

public class AStarAlgorithm {
    public static void main(String args[]) {
        final long startTime = System.nanoTime();

        Node[] states = new Node[4];
        Node goalNodeFound = new Node();
        goalNodeFound = null;
        Stack stack = new Stack();
        Node current = new Node();
        LinkedList<ArrayList<?>> visited = new LinkedList<ArrayList<?>>();
        int count = 0;

        //Creating start node
        Node start = new Node();
        ArrayList<Integer> startState = new ArrayList<>();

        startState.add(1);
        startState.add(2);
        startState.add(3);
        startState.add(8);
        startState.add(0);
        startState.add(5);
        startState.add(7);
        startState.add(4);
        startState.add(6);

        //create the start state and give the state where it is starting through an array list
        start.state = startState;
        //starting parent is null
        start.parent = null;
        //starting move is null (we do not know where we need to move, yet)
        start.move = null;
        //the priority will start at 0 because we always need to start with 0 or the empty tile
        start.priority = 0;
        //starting distance
        start.distance = -1;

        //Creating goal node
        Node goal = new Node();
        //add current goal state to the a.i.
        ArrayList<Integer> goalState = new ArrayList<>();
        goalState.add(1);
        goalState.add(2);
        goalState.add(3);
        goalState.add(8);
        goalState.add(0);
        goalState.add(4);
        goalState.add(7);
        goalState.add(6);
        goalState.add(5);


        //Creating goal node
        //making the state of the goal node to be the goal state
        goal.state = goalState;
        //parent will start null we do not know where the goal is initially
        goal.parent = null;
        //distance for node
        goal.distance = -1;
        //move to goal starts null
        goal.move = null;

        Comparator<Node> comparator = new CompareNodes();
        PriorityQueue<Node> pQ = new PriorityQueue<Node>(100, comparator);
        //add start node to the priority queue
        pQ.add(start);
        //will link the starting nodes to the state it currently is in
        visited.add(start.state);
        //while the priority queue has data
        while (!pQ.isEmpty()) {
            count++;
            //grab current node and add to current
            current = pQ.remove();
            //put the current node into the find states method
            states = findStates(current);

            for (int i = 0; i <= 3; i++) {
                if (states[i] != null) {
                    if (states[i].state.equals(goal.state)) {
                        goalNodeFound = states[i];
                        break;
                    } else {
                        if (!visited.contains(states[i].state)) {
                            visited.add(states[i].state);
                            states[i].priority = costFunction(states[i], goal);
                            pQ.add(states[i]);
                            System.out.println("State Space: ");
                            for (int k = 0; k < 3; k++) {
                                for (int f = k * 3; f < (k + 1) * 3; f++) {
                                    System.out.print("[" + current.state.get(f).toString() + "]");
                                }
                                System.out.println();
                            }
                            System.out.println();
                        }
                    }
                }
            }
            //when the node is Null we will break back to the priority queues next item
            if (goalNodeFound != null) {
                break;
            }
        }
        while (goalNodeFound.parent != null) {
            if (goalNodeFound.move != null) {
                //string used to help with output data
                String stackInfo = "";
                for (int k = 0; k < 3; k++) {
                    for (int f = k * 3; f < (k + 1) * 3; f++) {
                        stackInfo += "[" + goalNodeFound.state.get(f) + "]";
                    }
                    stackInfo += ("\n");
                }
                stackInfo += ("Move: " + goalNodeFound.move + "\n");
                stack.push(stackInfo);

            }
            goalNodeFound = goalNodeFound.parent;
        }
        System.out.println("--------------------------------------" );
        System.out.println("Starting Space: ");
        for (int k = 0; k < 3; k++) {
            for (int f = k * 3; f < (k + 1) * 3; f++) {
                System.out.print("[" + startState.get(f) + "]");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------" );
        while (!stack.isEmpty()) {
            //pop items in stack to print out
            System.out.println(stack.pop());
        }
        System.out.println("--------------------------------------" );
        System.out.println("Goal Space: ");
        for (int k = 0; k < 3; k++) {
            for (int f = k * 3; f < (k + 1) * 3; f++) {
                System.out.print("[" + goalState.get(f) + "]");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------" );
        System.out.println(count + " Nodes expanded.");
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration / 1000000000.0 + " s");
    }

    private static int costFunction(Node node, Node goal) {
        // TODO Auto-generated method stub
        int priority;
        int count = 0;
        //Heuristic Function Calculation
        for (int i = 0; i < 9; i++) {
            if (node.state.get(i) != goal.state.get(i)) {
                count++;
            }
        }

        priority = node.distance + count;
        return priority;
    }

    private static Node[] findStates(Node state) {
        // TODO Auto-generated method stub
        Node state1, state2, state3, state4;

        state1 = moveUP(state);
        state2 = moveDOWN(state);
        state3 = moveLEFT(state);
        state4 = moveRIGHT(state);

        Node[] states = {state1, state2, state3, state4};

        return states;
    }


    //move right method
    private static Node moveRIGHT(Node node) {
        // TODO Auto-generated method stub
        int space = node.state.indexOf(0);
        ArrayList<Integer> childState;
        int temp;
        Node childNode = new Node();

        if (space != 2 && space != 5 && space != 8) {
            childState = (ArrayList<Integer>) node.state.clone();
            temp = childState.get(space + 1);
            childState.set(space + 1, 0);
            childState.set(space, temp);
            childNode.state = childState;
            childNode.parent = node;
            childNode.distance = node.distance + 1;
            childNode.move = "RIGHT";
            return childNode;
        } else {
            return null;
        }
    }

    //move left method
    private static Node moveLEFT(Node node) {
        // TODO Auto-generated method stub
        int space = node.state.indexOf(0);
        ArrayList<Integer> childState;
        int temp;
        Node childNode = new Node();

        if (space != 0 && space != 3 && space != 6) {
            childState = (ArrayList<Integer>) node.state.clone();
            temp = childState.get(space - 1);
            childState.set(space - 1, 0);
            childState.set(space, temp);
            childNode.state = childState;
            childNode.parent = node;
            childNode.distance = node.distance + 1;
            childNode.move = "LEFT";
            return childNode;
        } else {
            return null;
        }
    }

    //move down method
    private static Node moveDOWN(Node node) {
        // TODO Auto-generated method stub
        int space = node.state.indexOf(0);
        ArrayList<Integer> childState;
        int temp;
        Node childNode = new Node();

        if (space <= 5) {
            childState = (ArrayList<Integer>) node.state.clone();
            temp = childState.get(space + 3);
            childState.set(space + 3, 0);
            childState.set(space, temp);
            childNode.state = childState;
            childNode.parent = node;
            childNode.distance = node.distance + 1;
            childNode.move = "DOWN";
            return childNode;
        } else {
            return null;
        }
    }

    //move up method
    private static Node moveUP(Node node) {
        // TODO Auto-generated method stub
        int space = node.state.indexOf(0);
        ArrayList<Integer> childState;
        int temp;
        Node childNode = new Node();

        if (space > 2) {
            childState = (ArrayList<Integer>) node.state.clone();
            temp = childState.get(space - 3);
            childState.set(space - 3, 0);
            childState.set(space, temp);
            childNode.state = childState;
            childNode.parent = node;
            childNode.distance = node.distance + 1;
            childNode.move = "UP";
            return childNode;
        } else {
            return null;
        }
    }

}
