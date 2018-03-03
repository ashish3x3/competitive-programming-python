from collections import defaultdict
import pprint,json
pp = pprint.PrettyPrinter(indent=4)


class Trie:
    """
    Implement a trie with insert, search, and startsWith methods.
    """
    def __init__(self):
        self.root = defaultdict()

    def printRoot(self):
        # print type(self.root)
        # print pprint.pprint(dict(self.root), indent=1)
        print(json.dumps(self.root, indent=1))
        # print sum(len(v) for v in self.root.itervalues())
        # print len(self.root)


    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        # print 'word ', word
        current = self.root
        # print 'current ',pprint.pprint(current)
        for letter in word:
            # print 'letter ', letter
            current = current.setdefault(letter, {})
            # print 'current ',pprint.pprint(current)
        current.setdefault("_end")

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    def search(self, word):
        current = self.root
        for letter in word:
            print 'leter ',letter
            if letter not in current:
                print 'leter ',letter
                return False
            current = current[letter]
            print 'new current'
            print(json.dumps(current, indent=1))
        if "_end" in current:
            return True
        return False

    # @param {string} prefix
    # @return {boolean}
    # Returns if there is any word in the trie
    # that starts with the given prefix.
    def startsWith(self, prefix):
        if len(prefix)==0:
            return True
        current = self.root
        for letter in prefix:
            if letter not in current:
                print 0
                return False
            current = current[letter]
            # print 'new current'
            # print(json.dumps(current, indent=1))
        # print sum(len(v) for v in current.itervalues())
        print len(current)
        return True



if __name__ == "__main__":


    # Now test the class

    test = Trie()
    # test.insert('helloworld')
    # test.insert('ilikeapple')
    # test.insert('helloz')

    # test.insert('hack')
    # test.insert('hackerrank')
    # test.startsWith('hac')
    # test.startsWith('hak')
    n = int(raw_input().strip())
    for a0 in xrange(n):
        op, contact = raw_input().strip().split(' ')
        if op == 'add':
            test.insert(contact)
        elif op == 'find':
            test.startsWith(contact)





    # print test.printRoot()


    # print test.search('helloz') # true
    # print test.search('hello')  #false
    # print test.startsWith('hello')
    # print test.search('ilikeapple')


'''
                                    *******************************************

print test.search('helloz')

leter  h
new current
{
 "e": {
  "l": {
   "l": {
    "o": {
     "z": {
      "_end": null
     },
     "w": {
      "o": {
       "r": {
        "l": {
         "d": {
          "_end": null
         }
        }
       }
      }
     }
    }
   }
  }
 }
}
leter  e
new current
{
 "l": {
  "l": {
   "o": {
    "z": {
     "_end": null
    },
    "w": {
     "o": {
      "r": {
       "l": {
        "d": {
         "_end": null
        }
       }
      }
     }
    }
   }
  }
 }
}
leter  l
new current
{
 "l": {
  "o": {
   "z": {
    "_end": null
   },
   "w": {
    "o": {
     "r": {
      "l": {
       "d": {
        "_end": null
       }
      }
     }
    }
   }
  }
 }
}
leter  l
new current
{
 "o": {
  "z": {
   "_end": null
  },
  "w": {
   "o": {
    "r": {
     "l": {
      "d": {
       "_end": null
      }
     }
    }
   }
  }
 }
}
leter  o
new current
{
 "z": {
  "_end": null
 },
 "w": {
  "o": {
   "r": {
    "l": {
     "d": {
      "_end": null
     }
    }
   }
  }
 }
}
leter  z
new current
{
 "_end": null
}
True
                                    *******************************************


print test.search('hello')  #false


leter  h
new current
{
 "e": {
  "l": {
   "l": {
    "o": {
     "z": {
      "_end": null
     },
     "w": {
      "o": {
       "r": {
        "l": {
         "d": {
          "_end": null
         }
        }
       }
      }
     }
    }
   }
  }
 }
}
leter  e
new current
{
 "l": {
  "l": {
   "o": {
    "z": {
     "_end": null
    },
    "w": {
     "o": {
      "r": {
       "l": {
        "d": {
         "_end": null
        }
       }
      }
     }
    }
   }
  }
 }
}
leter  l
new current
{
 "l": {
  "o": {
   "z": {
    "_end": null
   },
   "w": {
    "o": {
     "r": {
      "l": {
       "d": {
        "_end": null
       }
      }
     }
    }
   }
  }
 }
}
leter  l
new current
{
 "o": {
  "z": {
   "_end": null
  },
  "w": {
   "o": {
    "r": {
     "l": {
      "d": {
       "_end": null
      }
     }
    }
   }
  }
 }
}
leter  o
new current
{
 "z": {
  "_end": null
 },
 "w": {
  "o": {
   "r": {
    "l": {
     "d": {
      "_end": null
     }
    }
   }
  }
 }
}
False
                                    *******************************************
                


'''