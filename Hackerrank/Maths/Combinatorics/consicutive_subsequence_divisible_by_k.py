# https://www.hackerrank.com/challenges/consecutive-subsequences

def nCk(n, k):
    res = 1
    for i in range(k):
        res = res * (n - i) // (i + 1)
    return res

def consicutiveSum2(arr,k):
    b = [0]*(k+1)
    b[0]+= 1
    s = 0
    for i in xrange(len(arr)):
        s = (s + arr[i]) % k
        b[s]+=1
    ans = 0
    for i in xrange(k):
        ans+= b[i]*(b[i]-1)/2
  
    return ans
    
    
    
    
    
def consicutiveSum(arr, k):
    sum = 0
    mp = {}
    for x in arr:
        sum = sum+x
        if sum%k in mp:
            mp[sum%k]+=1
        else:
            mp[sum%k]=1
    res = 0 
    print mp
    for k,v in mp.iteritems():
        res+= nCk(v,2)
        
    return res

T = int(raw_input())

for _ in xrange(T):
    n,k = map(int,raw_input().strip().split())
    arr = list(map(int,raw_input().strip().split(' ')))
    print consicutiveSum2(arr,k)
    

            