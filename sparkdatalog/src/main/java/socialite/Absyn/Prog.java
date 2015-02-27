package socialite.Absyn; // Java Package generated by the BNF Converter.

public class Prog extends Program {
  public final ListDeclaration listdeclaration_;
  public final ListRule listrule_;

  public Prog(ListDeclaration p1, ListRule p2) { listdeclaration_ = p1; listrule_ = p2; }

  public <R,A> R accept(socialite.Absyn.Program.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof socialite.Absyn.Prog) {
      socialite.Absyn.Prog x = (socialite.Absyn.Prog)o;
      return this.listdeclaration_.equals(x.listdeclaration_) && this.listrule_.equals(x.listrule_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.listdeclaration_.hashCode())+this.listrule_.hashCode();
  }


}
