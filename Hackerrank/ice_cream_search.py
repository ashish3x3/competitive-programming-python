# https://www.hackerrank.com/challenges/ctci-ice-cream-parlor


def binSearch(arr, lo, hi):
    if lo > hi:
        return
    while lo < hi:
        mid = (lo+hi)//2
        if arr[mid] > arr[mid+1] and arr[mid] > arr[mid-1]:
            return mid
        if arr[mid] > arr[mid-1]:
            binSearch(arr, mid+1, hi)
        elif arr[mid] < arr[mid+1]:
            binSearch(arr, lo, mid-1)
            

def icecream(flavors, M):
    # O(N) complexity
    flavor_map = {}
    for idx, flavor in enumerate(flavors):
        print 'flavor_map ',flavor_map
        residual = (M - flavor)
        print 'resedual ',residual
        
        if residual in flavor_map:
            print 'sorted ',sorted([flavor_map[residual], idx])
            return sorted([flavor_map[residual], idx])
        if not flavor in flavor_map:
            print 'not in map ',residual, flavor
            flavor_map[flavor] = idx

t = int(raw_input().strip())
for a0 in xrange(t):
    m = int(raw_input().strip())
    n = int(raw_input().strip())
    arr = map(int, raw_input().strip().split(' '))
    #print m, arr
    res = icecream(arr,m)
    print res[0]+1, res[1]+1
    
      


t = int(raw_input().strip())
for a0 in xrange(t):
    m = int(raw_input().strip())
    n = int(raw_input().strip())
    arr = map(int, raw_input().strip().split(' '))
    c1,c2 = getCost(arr,m)
    print c1, c2



'''
Your code did not pass this test case.
Input (stdin)
2
4
5
1 4 5 3 2
4
4
2 2 4 3
Your Output (stdout)
flavor_map  {}
resedual  3
not in map  3 1
flavor_map  {1: 0}
resedual  0
not in map  0 4
flavor_map  {1: 0, 4: 1}
resedual  -1
not in map  -1 5
flavor_map  {1: 0, 4: 1, 5: 2}
resedual  1
sorted  [0, 3]
1 4
flavor_map  {}
resedual  2
not in map  2 2
flavor_map  {2: 0}
resedual  2
sorted  [0, 1]
1 2
Expected Output
1 4
1 2

'''
    
'''
test_cases = int(raw_input().strip())
for _ in xrange(test_cases):
    money = int(raw_input().strip())
    _ = int(raw_input().strip())
    prices = map(int, raw_input().strip().split(' '))
    prices = sorted([(v, index+1) for index, v in enumerate(prices)])
    lower_i = 0
    upper_i = len(prices) - 1
    while True:
        current_cost = prices[lower_i][0] + prices[upper_i][0]
        if current_cost > money:
            upper_i -= 1
        elif current_cost < money:
            lower_i += 1
        else:
            print ' '.join(map(str, sorted([prices[lower_i][1], prices[upper_i][1]])))
            break
'''