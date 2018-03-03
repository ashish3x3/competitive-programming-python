from collections import deque,Counter
from bisect import insort, bisect_left
from itertools import islice

def RunningMode(seq,N,M):
    """
    Purpose: Find the mode for the points in a sliding window as it 
             is moved from left (beginning of seq) to right (end of seq)
             by one point at a time.
     Inputs:
          seq -- list containing items for which a running mode (in a sliding window) is 
                 to be calculated
            N -- length of sequence                      
            M -- number of items in window (window size) -- must be an integer > 1
     Otputs:
        modes -- list of modes with size M - N + 1
       Note:
         1. The mode is the value that appears most often in a set of data.
         2. In the case of ties it the last of the ties that is taken as the mode (this
            is not by definition).
    """    
    # Load deque with first window of seq 
    d = deque(seq[0:M]) 

    modes = [Counter(d).most_common(1)[0][0]]  # contains mode of first window

    # Now slide the window by one point to the right for each new position (each pass through 
    # the loop). Stop when the item in the right end of the deque contains the last item in seq
    for item in islice(seq,M,N):
        old = d.popleft()                      # pop oldest from left
        d.append(item)                         # push newest in from right
        modes.append(Counter(d).most_common(1)[0][0])        
    return modes    

'''
from collections import Counter
data = Counter(your_list_in_here)
data.most_common()   # Returns all unique items and their counts
data.most_common(1)  # Returns the highest occurring item
'''