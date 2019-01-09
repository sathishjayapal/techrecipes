1. Unlike constructors static methods can have name for them
2. unlike constructors static methods do not have to create objects everytime. They can be used to return immutable objects
3. Static constructors can return any subtype of object. Could be used well when used with derived classes.
4. Static methods can return objects that can vary based on function of input parameters.
5. Popular static methods for creating objects are
    * Date d- Date.from(<variable>)
    * Set<Rank>= EnumSet.of(FIRST, SECOND, THIRD)
    * int i= Integer.valueOf("9")
    
