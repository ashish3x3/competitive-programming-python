

# https://www.hackerrank.com/challenges/pairs/problem
# Head ends here
def pairs(a,k):
    
    answer = 0
    mp = {}
    for i in a:
        if i not in mp:
            mp[i] = True
    
    for i in a:
        if k+i in mp:
            answer+=1
    return answer
# Tail starts here
if __name__ == '__main__':
    a = map(int, raw_input().strip().split(" "))
    _a_size=a[0]
    _k=a[1]
    b = map(int, raw_input().strip().split(" "))
    print pairs(b,_k)
