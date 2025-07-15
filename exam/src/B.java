
class B extends A
{ A bidule;
    int i = 2;
    B(){
        super();
        this.bidule = this; }
    B(A a){ super(3); this.bidule = a; }
}
