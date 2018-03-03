class Stack:
     def __init__(self):
         self.items = []

     def isEmpty(self):
         return self.items == []

     def push(self, item):
         self.items.append(item)

     def pop(self):
         return self.items.pop()

     def peek(self):
         return self.items[len(self.items)-1]

     def size(self):
         return len(self.items)

def is_matched(expression):
    if len(expression) == 1:
        return False
    OPEN = '({['
    CLOSED = ')}]'
    stack = Stack()
    for i in expression:
        #print 'i ',i
        if i in OPEN:
            stack.push(i)
        elif i in CLOSED:
            if stack.isEmpty():
                return False
            ind = CLOSED.index(i)
            #print 'stack.peek ',stack.peek()
            #print 'OPEN[ind] ',OPEN[ind]
            if stack.peek() == OPEN[ind]:
                it = stack.pop()
                #print 'pop ',it
                
                
            
    if stack.isEmpty():
        return True
    return False
    

t = int(raw_input().strip())
for a0 in xrange(t):
    expression = raw_input().strip()
    if is_matched(expression) == True:
        print "YES"
    else:
        print "NO"


'''
Algorithm

if expression is of length 1, then the braces cannot be balanced, return false
Declare open and closed braces constants
Create a new Stack
For each character in the expression, evaluate the following:
If the OPEN brace constant contains the current character, push the character into the stack
If the CLOSED brace constant contains the current character, do the following:
Check if stack is empty. If the brace coming is closed and the stack is empty, it means there was no opening, hence return false.
Get the index of the character in the CLOSED constant and check if the closing brace matches with what is on the top of the stack. if it does, pop off the stack and continue. if it doesn't, then we know there is an imbalance, return false.
Once out of the loop, we return the boolean if the stack is empty. If the stack is empty it means that opening and closing braces were pushed and popped symmetrically, and so the expression is balanced.
public static boolean isBalanced(String expression) {
  if(expression.length()==1) { // (1)
        return false;
    }

    String OPEN = "{[("; // (2)
    String CLOSED = "}])"; // (2)

    Stack<Character> stack = new Stack<>(); // (3)
    for(char c : expression.toCharArray()) { // (4)
        if(OPEN.indexOf(c) != -1) { // (4i)
            stack.push(c);
        }

        if(CLOSED.indexOf(c) != -1) { // (4ii)
            if(stack.isEmpty()) { // (4ii.i)
                return false;
            }

            int index = CLOSED.indexOf(c); // (4ii.ii)
            if(stack.peek() == OPEN.charAt(index)) {
                stack.pop();
            } else {
                return false;
            }
        }
    }

    return stack.isEmpty(); // (5)
 }
'''