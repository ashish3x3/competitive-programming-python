# https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid

# reference
# http://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
# http://www.geeksforgeeks.org/find-number-of-islands/

import sys

class Graph:
 
    def __init__(self, row, col, g):
        self.ROW = row
        self.COL = col
        self.graph = g
        self.dirs = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        self.cur_count = 0
        self.max = -1
 
    def isSafe(self, i, j, visited):
        return (i >= 0 and i < self.ROW and
                j >= 0 and j < self.COL and
                not visited[i][j] and self.graph[i][j])
             
 
    def DFS(self, i, j, visited, count):

        # Mark this cell as visited
        visited[i][j] = True

        self.cur_count+=1
        self.max = max(self.max, self.cur_count)
 
        # Recur for all connected neighbours
        for dir in self.dirs:
            if self.isSafe(i + dir[0], j + dir[1], visited):
                self.DFS(i + dir[0], j + dir[1], visited,self.cur_count)
 
 
   
    def countIslands(self):
        visited = [[False for j in range(self.COL)]for i in range(self.ROW)]

        for i in range(self.ROW):
            for j in range(self.COL):
                if visited[i][j] == False and self.graph[i][j] ==1:
                    self.cur_count=0
                    self.DFS(i, j, visited, self.cur_count)

        return self.max


n = int(raw_input().strip())
m = int(raw_input().strip())
grid = []
for grid_i in xrange(n):
    grid_temp = map(int, raw_input().strip().split(' '))
    grid.append(grid_temp)
    row = len(grid)
    col = len(grid[0])

g= Graph(row, col, grid)

#print "Number of islands is :"
print g.countIslands()


'''

# version 2 : Java way (using call by reference mechanism by usng count = [1] to simulate real time mutation)

# https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid

# reference
# http://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
# http://www.geeksforgeeks.org/find-number-of-islands/

import sys

class Graph:
 
    def __init__(self, row, col, g):
        self.ROW = row
        self.COL = col
        self.graph = g
 
    def isSafe(self, i, j, visited):
        return (i >= 0 and i < self.ROW and
                j >= 0 and j < self.COL and
                not visited[i][j] and self.graph[i][j])
             
 
    def DFS(self, i, j, visited, count):
        rowNbr = [-1, -1, -1,  0, 0,  1, 1, 1];
        colNbr = [-1,  0,  1, -1, 1, -1, 0, 1];
        '''
        rowNbr = [-1, -1, -1,  0, 0,  1, 1, 1]
        anti-clockwise from 0,0 to N,0
            -1 -1 -1
             0  i  0
            +1 +1 +1

        colNbr = [-1,  0,  1, -1, 1, -1, 0, 1]
            -1 0 +1
            -1 j +1
            -1 0 +1
        '''
         
        # Mark this cell as visited
        visited[i][j] = True
 
        # Recur for all connected neighbours
        for k in range(8):
            if self.isSafe(i + rowNbr[k], j + colNbr[k], visited):
                count[0]+=1
                self.DFS(i + rowNbr[k], j + colNbr[k], visited,count)
 
 
   
    def countIslands(self):
        visited = [[False for j in range(self.COL)]for i in range(self.ROW)]
        #count = 0
        result = -sys.maxint
        for i in range(self.ROW):
            #print 'i ',i
            for j in range(self.COL):
                #print 'j ',j
                if visited[i][j] == False and self.graph[i][j] ==1:
                    count = [1]
                    self.DFS(i, j, visited, count)
                    result = max(result, count[0])
                    #print 'count[0], res ',count[0], result

        #print 'return res'
        return result


n = int(raw_input().strip())
m = int(raw_input().strip())
grid = []
for grid_i in xrange(n):
    grid_temp = map(int, raw_input().strip().split(' '))
    grid.append(grid_temp)
    row = len(grid)
    col = len(grid[0])

g= Graph(row, col, grid)

#print "Number of islands is :"
print g.countIslands()

'''
