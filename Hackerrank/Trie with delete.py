

https://gist.github.com/huseynlilkin/d512e7e57dce32cc7317754c3d9d9bce

# index of given char
def index(inputCh):
    return ord(inputCh) - ord('a')


# empty Node
class Node(object):
    children = None

    def __init__(self):
        self.children = [None] * 26
        self.ch = ' '
        self.word = ""
        self.isLeaf = False
        self.parent = None


class Trie(object):
    root = None

    def __init__(self):
        self.root = Node()

    def insertString(self, in_string):

        current = self.root
        for c in in_string[:-1]:
            idx = index(c)
            try:
                if current.children[idx] is None:
                    current.children[idx] = Node()
                    current.children[idx].ch = c
                    current.children[idx].word = current.word + c
                    current.children[idx].parent = current
            except IndexError as ie:
                print("idx = {}\nchar = {}\nstring = {}".format(idx, c, in_string))

            current = current.children[idx]
        current.isLeaf = True

    def searchString(self, in_string):

        current = self.root

        for c in in_string:
            idx = index(c)

            # if character is in the trie
            if current.children[idx] is not None:
                current = current.children[idx]

            # character is not in the trie, workd is not exist
            else:
                return False

        # if word is in the trie, returns true
        return current.isLeaf

    def deleteString(self, in_string):

        current = self.root
        if self.searchString(in_string):
            for c in in_string:
                idx = index(c)
                current = current.children[idx]

            current.isLeaf = False

# Examples
new_trie = Trie()

# demos
# insertion
new_trie.insertString("apple\n")
new_trie.insertString('app\n')
new_trie.insertString("application\n")
new_trie.insertString("homework\n")

# search
print(new_trie.searchString("app"))         # expected output: true
print(new_trie.searchString("apply"))       # expected output: false

# delete
new_trie.deleteString('app')

# search after delete
print(">>>Search after delete<<<")
print(new_trie.searchString('app'))          # expected output: false
print(new_trie.searchString('application'))  # expected output: true

# fin = open('words2.txt')
# for word in fin:
#     # print(word)
#     new_trie.insertString(word)
#
# print(new_trie.searchString('augmented'))
# new_trie.deleteString('augmented')
# print(new_trie.searchString('augmented'))
# print(new_trie.searchString('augmentedly'))





https://gist.github.com/reterVision/8551554


def make_trie(*args):
    """
    Make a trie by given words.
    """
    trie = {}

    for word in args:
        if type(word) != str:
            raise TypeError("Trie only works on str!")
        temp_trie = trie
        for letter in word:
            temp_trie = temp_trie.setdefault(letter, {})
        temp_trie = temp_trie.setdefault('_end_', '_end_')

    return trie


def in_trie(trie, word):
    """
    Detect if word in trie.
    """
    if type(word) != str:
        raise TypeError("Trie only works on str!")

    temp_trie = trie
    for letter in word:
        if letter not in temp_trie:
            return False
        temp_trie = temp_trie[letter]
    return True


def remove_from_trie(trie, word, depth):
    """
    Remove certain word from trie.
    """
    if word and word[depth] not in trie:
        return False

    if len(word) == depth + 1:
        del trie[word[depth]]
        if not trie:  # Node becomes a leaf, indicate its parent to delete it.
            return True
        return False
    else:
        temp_trie = trie

        # Recursively climb up to delete.
        if remove_from_trie(temp_trie[word[depth]], word, depth + 1):
            if temp_trie:
                del temp_trie[word[depth]]
            return not temp_trie
    return False


if __name__ == '__main__':
    trie = make_trie('hello', 'abc', 'baz', 'bar', 'barz')
    print trie

    print in_trie(trie, 'hello')
    print in_trie(trie, 'bar')
    print in_trie(trie, 'bab')
    print in_trie(trie, 'zzz')

    remove_from_trie(trie, 'abc', 0)
    print trie
    remove_from_trie(trie, 'hello', 0)
    print trie
    remove_from_trie(trie, 'bar', 0)
    print trie

    print in_trie(trie, 1)



    https://stackoverflow.com/questions/15709261/how-to-implement-the-remove-function-of-a-trie-in-python
    def remove_word(trie, word):
        current_dict = trie
        for letter in word:
            current_dict = current_dict.get(letter, None)
            if current_dict is None:
                # the trie doesn't contain this word.
                break
        else:
            del current_dict[_end]