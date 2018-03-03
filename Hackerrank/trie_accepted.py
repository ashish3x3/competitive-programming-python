# https://www.hackerrank.com/challenges/ctci-contacts

'''
4
add hack
add hackerrank
find hac
find hak
'''

import collections,json

def Trie():
    return collections.defaultdict(Trie)


def add(node, s):
    if 'count' not in node:
        print 's ',s
        print 'count not in node', node
        node['count'] = 0
    node['count'] += 1
    # print(json.dumps(node[s[0]], indent=1)) 
    # print 's ',s
    # print 'len(s) ',len(s)

    if s:
        print 'node[s[0]] ',node[s[0]]
        add(node[s[0]], s[1:])
    
def find(node, s):
    if s and node:
        return find(node[s[0]], s[1:])
    else:
        return node.get('count', 0)

    
contacts = Trie()
print contacts
n = int(raw_input().strip())
for a0 in xrange(n):
    op, contact = raw_input().strip().split(' ')
    if op == 'add':
        add(contacts, contact)
        print(json.dumps(contacts, indent=1)) 
    else:
        print find(contacts, contact)


'''
# https://www.accelebrate.com/blog/using-defaultdict-python/

import sys

class Trie(object):

    def __init__(self):
        self.items = {}

    def insert(self, value):
        current_dict = self.items
        for letter in value:
            if letter not in current_dict:
                current_dict[letter] = {}
            if 'count' not in current_dict:
                current_dict['count'] = 1
            else:
                current_dict['count'] += 1
            current_dict = current_dict[letter]

        current_dict['end'] = 'end'
        current_dict['count'] = 1

    def partial_search(self, value):
        current_dict = self.items
        for letter in value:
            if letter in current_dict:
                current_dict = current_dict[letter]
            else:
                return 0

        return current_dict['count']


f = sys.stdin
trie = Trie()
n = int(f.readline().strip())
for i in xrange(n):
    op, contact = f.readline().strip().split(' ')

    if op == 'add':
        trie.insert(contact)
    else:
        print trie.partial_search(contact)



        
tries = [0, {}]

def add(name):
    root = tries
    for c in name:
        if c not in root[1]:
            root[1][c] = [0, {}]
        root[1][c][0] += 1
        root = root[1][c]
        
def find(name):
    root = tries
    
    for e in name:
        if e not in root[1]:
            return 0
        root = root[1][e]
    return root[0]
        
n = int(raw_input().strip())
for a0 in range(n):
    op, contact = raw_input().strip().split(' ')
    if op == 'add':
        add(contact)
    if op == 'find':
        print find(contact)



from collections import defaultdict as ddic

def _trie(): 
    return ddic(_trie)

trie = _trie()

COUNT, END = True, False

def insert(query):
    cur = trie
    for letter in query:
        cur[COUNT] = cur.get(COUNT, 0) + 1
        cur = cur[letter]
    cur[COUNT] = cur.get(COUNT, 0) + 1
    cur[END] = END

def search(prefix):
    cur = trie
    for letter in prefix:
        if letter not in cur:
            return 0
        cur = cur[letter]
    return cur[COUNT]

rr = raw_inpu
N = int(rr())
for _ in xrange(N):
    cmd, query = rr().split()
    if cmd == "add":
        insert(query)
    else:
        print search(query)












for state, cities in cities_by_state.iteritems():

 s = 'mississippi'
>>> d = defaultdict(int)
>>> for k in s:
...     d[k] += 1
...
>>> d.items()
[('i', 4), ('p', 2), ('s', 4), ('m', 1)]   

'''