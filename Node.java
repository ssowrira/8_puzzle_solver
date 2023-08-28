/**
 *
 * @author Srikarran Sowrirajan
 */
/*
 * Node class that will represent each game board tile combination
 * in the game tree. 
 */
/*
 * Node class that will represent each game board tile combination
 * in the game tree. 
 */
public class Node {
        private int[] board;
        
        private Node next;
        /*
         * This field will denote the number of possible moves that can be made for
         * the current board combination. If the empty tile is at a corner, the value
         * will be 2. If the empty tile is on an edge, the value will be 3. If the
         * empty tile is at the center, the value will be 4. 
         */
        private int emptyTile;
        private int[] childBoard1 = new int[9];
        private int[] childBoard2 = new int[9];
        private int[] childBoard3 = new int[9];
        private int[] childBoard4 = new int[9];

        public Node(int[] array) {
                this.board = array;
                for (int i = 0; i < array.length; i++) {
                	if (array[i] == 0) {
                		emptyTile = i;
                	}
                }
                this.next = null;
                evaluateChildBoards();
        }

        public void evaluateChildBoards() {
        	
        	for(int i = 0; i < board.length; i++) {
        		childBoard1[i] = board[i];
        		childBoard2[i] = board[i];
        		childBoard3[i] = board[i];
        		childBoard4[i] = board[i];
        	}
                // if in the corner
            if (emptyTile == 0 || emptyTile == 2 || emptyTile == 6 || emptyTile == 8)
            {
                childBoard3 = null;
                childBoard4 = null;
                int value1, value2;
             //need to create a for loop that will copy everything from the previous board into the new child board

                if (emptyTile == 0){
                	value1 = board[emptyTile+1];
                	value2 = board[emptyTile];
                	childBoard1[emptyTile] = value1;
                	childBoard1[emptyTile + 1] = value2;
                	value1 = board[emptyTile + 3];
                	value2 = board[emptyTile];
                	childBoard2[emptyTile] = value1;
                	childBoard2[emptyTile + 3] = value2;
                }

                if(emptyTile == 2){
                	value1 = board[emptyTile - 1];
                	childBoard1[emptyTile] = value1;
                	value2 = board[emptyTile];
                	childBoard1[emptyTile - 1] = value2;
                	value1 = board[emptyTile + 3];
                	childBoard2[emptyTile] = value1;
                	value2 = board[emptyTile];
                	childBoard2[emptyTile + 3] = value2;
                }
            
	            if(emptyTile == 6){
	            	value1 = board[emptyTile - 3];
	            	value2 = board[emptyTile];
	            	childBoard1[emptyTile] = value1;
	            	childBoard1[emptyTile -3] =value2;
	            	
	            	childBoard2[emptyTile] = board[emptyTile + 1];
	            	childBoard2[emptyTile + 1] = board[emptyTile];
	            }
	            
	            if(emptyTile == 8){
	            	
	            	childBoard1[emptyTile] = board[emptyTile - 1];
	            	childBoard1[emptyTile - 1] = board[emptyTile];
	            	
	            	childBoard2[emptyTile] = board[emptyTile - 3];
	            	childBoard2[emptyTile - 3] = board[emptyTile];
	            }
            }
            
            // if on the edges
            else if (emptyTile == 1 || emptyTile == 3 || emptyTile == 5 || emptyTile == 7)
            {
            	childBoard4 = null;
            	
            	if(emptyTile == 1) {
            		
                        childBoard1[emptyTile] = board[emptyTile - 1];
                        childBoard1[emptyTile - 1] = board[emptyTile];

                        childBoard2[emptyTile] = board[emptyTile + 1];
                        childBoard2[emptyTile + 1] = board[emptyTile];

                        childBoard3[emptyTile] = board[emptyTile + 3];
                        childBoard3[emptyTile + 3] = board[emptyTile];
            	}

            	if(emptyTile == 3){
            		
            		childBoard1[emptyTile] = board[emptyTile - 3];
            		childBoard1[emptyTile - 3] = board[emptyTile];
            		
            		childBoard2[emptyTile] = board[emptyTile + 3];
            		childBoard2[emptyTile + 3] = board[emptyTile];
            		
            		childBoard3[emptyTile] = board[emptyTile + 1];
            		childBoard3[emptyTile + 1] = board[emptyTile];
            	}

            	if(emptyTile == 5){
            		
            		childBoard1[emptyTile] = board[emptyTile - 3];
            		childBoard1[emptyTile - 3] = board[emptyTile];
            		
            		childBoard2[emptyTile] = board[emptyTile + 3];
            		childBoard2[emptyTile + 3] = board[emptyTile];

            		childBoard3[emptyTile] = board[emptyTile - 1];
            		childBoard3[emptyTile - 1] = board[emptyTile];
            	}
            	
            	if(emptyTile == 7){
                    
                    childBoard1[emptyTile] = board[emptyTile - 1]; 
                    childBoard1[emptyTile - 1] = board[emptyTile];
                    
                    childBoard2[emptyTile] = board[emptyTile + 1];
                    childBoard2[emptyTile + 1] = board[emptyTile];
                    
                    childBoard3[emptyTile] = board[emptyTile - 3];
                    childBoard3[emptyTile - 3] = board[emptyTile];
            	}
            }


            else
            {
            	
            	childBoard1[emptyTile] = board[emptyTile - 3];
            	childBoard1[emptyTile - 3] = board[emptyTile];
            	
            	childBoard2[emptyTile] = board[emptyTile - 1];
            	childBoard2[emptyTile - 1] = board[emptyTile];
            	
            	childBoard3[emptyTile] = board[emptyTile + 1];
            	childBoard3[emptyTile + 1] = board[emptyTile];
            	
            	childBoard4[emptyTile] = board[emptyTile + 3];
            	childBoard4[emptyTile + 3] = board[emptyTile];
            }
        }	

        public int[] getArray() {
        	return this.board;
        }
        public int[] getChildBoard1 (){
            return this.childBoard1;
        }
        public int[] getChildBoard2 (){
            return this.childBoard2;
        }
        public int[] getChildBoard3 (){
            return this.childBoard3;
        }
        public int[] getChildBoard4 (){
            return this.childBoard4;
        }
		/*
		 * The following method will be triggered from the LinkedList class
		 */
        public Node next() {
        	return this.next;
        }
	
		public void setNext(Node node) {
			this.next = node;
		}

}	

