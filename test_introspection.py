
class MyRubylikeThing(object):

    def __getattr__(self, name):
        def _missing(*args, **kwargs):
            print "A missing method was called."
            print "The object was %r, the method was %r. " % (self, name)
            print "It was called with %r and %r as arguments" % (args, kwargs)

        return _missing

class Call(object):
    pass


class MyMock(object):

    def __getattr__(self, name):
        def x(*args, **kwargs):
            print "Hi there! These are my args:", args

        def y(*args, **kwargs):
            print "I don't have the method '%s' but I've created one for you :) Please try again" % name

        setattr(self, name, x)
        return y

r = MyRubylikeThing()
r.hello("there", "world", also="bye")

print
print

m = MyMock()
print
m.do_something()
print
m.do_something("Thanks!")
print
