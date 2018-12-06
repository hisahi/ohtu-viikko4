
package statistics.matcher; 

public class QueryBuilder {
    private Matcher current;
    
    public QueryBuilder() {
        this.current = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        current = new And(current, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        current = new And(current, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        current = new And(current, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        current = new And(current, new Or(matchers));
        return this;
    }
    
    public Matcher build() {
        Matcher oldCurrent = this.current;
        this.current = new All();
        return oldCurrent;
    }
}
