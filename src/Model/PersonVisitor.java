package Model;

public interface PersonVisitor {
    public void visit(Leaders l);
    public void visit(Secretary s);
    public void visit(Dean d);
    public void visit(Member m);

}
