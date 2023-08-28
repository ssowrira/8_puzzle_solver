import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * The Game Tree
 */
public class GameTree {
    
    private Node firstBoard;
    private LinkedList list = new LinkedList();
    private int[] solution = {1,2,3,4,5,6,7,8,0};
    
    
    
    /*
    * Initiates the first board by creating a Node instance using
    * a random array of 9 integers from 0 - 8
    */
    public GameTree() {
        int[] randomArray = {1,2,3,4,5,6,8,7,0};
        
        Random r = new Random();
        while (!(isSolvable(randomArray))) {
	        for (int i = randomArray.length - 1; i > 0; i--) {
	        	int index = r.nextInt(i+1);
	        	int a = randomArray[index];
	        	randomArray[index] = randomArray[i];
	        	randomArray[i] = a;
	        }
        }
        firstBoard = new Node(randomArray);
        list.addNode(firstBoard);

    }
    
    public LinkedList getList() {
        return list;
    }
    
    /*
     * The following method will be used to determine the order in which the
     * program will move down the tree. An optimum child will be chosen for the
     * current board and the child board will be added to the "list" linked list
     * which contains the order of moves. 
     */
    public void percolate() {
        
    	Node thisNode = list.getNode();
    	if (thisNode.getArray() != solution) {
    		Node nextNode = getNextMove(thisNode.getChildBoard1(),thisNode.getChildBoard2(),thisNode.getChildBoard3(),thisNode.getChildBoard4());
    	
    		list.addNode(nextNode);
    	}
    }
    
    /*
     * Determines if an array will have a solution in the 8-Puzzle solver 
     * game. We use the concept of inversions. For the 3x3 solver, we need 
     * an even number of inversions for it to be solvable.
     */
    public boolean isSolvable(int[] array) {
    	int[] inverseArray = new int[8];
    	int j = 0;
    	for(int i = 0; i<array.length;i++) {
    		if (array[i] != 0) {
    			inverseArray[j] = array[i];
    			j++;
    		}
    	}
    	int count = 0;
    	int[] usedValues = new int[8];
    	int k = 0; //number of used values so far
    	for (int i = 0; i<inverseArray.length;i++) {
    		int value = inverseArray[i];
    		usedValues[k] = value;
    		k++;
    		if (value > 1) {
    			for (j = 0;j<k;j++) {
    				if (usedValues[j] > value)
    					count++;
    			}
    		}
    	}
    	if ((count % 2) == 0)
    		return true;
    	return false;
    }
    
    public int[] getFirstBoard() {
        return firstBoard.getArray();
    }
    
    public int manhattan(int[] array) {
        
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += this.getDistance(array, array[i]);
        }
        return sum;
    }
    
    public int getDistance(int[] array, int tile) {
        int position = 9;
        for (int i = 0; i<array.length;i++) {
            if (array[i] == tile) {
                position = i;
            }
        }
        switch (tile) {
        
        case 1:
            if ((position == 0) || (position == 1) || (position == 2)) 
                return position - 0;
            
            else if ((position == 3) || (position == 4) || (position == 5)) 
                return position - 2;
            
            else
                return position - 4;
            
        case 2:
            if ((position == 0) || (position == 1) || (position == 2)) 
                return Math.abs(position - 1);
            
            else if ((position == 3) || (position == 5) || (position == 7)) 
                return 2;
            else if (position == 4)
                return 1;
            else
                return 3;
            
        case 3:
            if ((position == 0) || (position == 1) || (position == 2)) 
                return Math.abs(position - 2);
            
            else if ((position == 3) || (position == 7)) 
                return 3;
            else if ((position == 4) || (position == 6))
                return position - 2;
            else if (position == 5)
                return 1;            
            else
                return 2;
            
        case 4:
            if ((position == 0) || (position == 1) || (position == 2)) 
                return position + 1;
            
            else if ((position == 3) || (position == 4) || (position == 5)) 
                return position - 3;
            
            else
                return position - 5;
            
        case 5:
            if ((position == 0) || (position == 2) || (position == 6) || (position == 8)) 
                return 2;
            
            else if ((position == 1) || (position == 3) || (position == 5) || (position == 7)) 
                return 1;
            
            else
                return 0;
            
        case 6:
            if ((position == 0) || (position == 6)) 
                return 3;
            
            else if ((position == 1) || (position == 3) || (position == 7)) 
                return 2;
            
            else if ((position == 2) || (position == 4) || (position == 8))
                return 1;            
            else
                return 0;
            
        case 7:
            if ((position == 0) || (position == 1) || (position == 2)) 
                return position + 2;
            
            else if ((position == 3) || (position == 4) || (position == 5)) 
                return position - 2;
            
            else
                return position - 6;
            
        case 8:
            if ((position == 0) || (position == 2)) 
                return 3;
            
            else if ((position == 1) || (position == 3) || (position == 5)) 
                return 2;
            else if (position == 4)
                return 1;
            else
                return Math.abs(position - 7);
            
        default: break;
        
        
        
        }
        return 0;
    }
    
    public Node getNextMove(int[] node1, int[] node2, int[] node3, int[] node4) {
    	int [] result = node1;
        
		if ((node2 != null) && (manhattan(node2) < manhattan(result)))
		    result = node2;    
		if ((node3 != null) && (manhattan(node3) < manhattan(result)))
			result = node3;
		if ((node4 != null) && (manhattan(node4) < manhattan(result)))
			result = node4;
		return new Node(result);
        
    }
    
}