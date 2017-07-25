package pkg8queens;

import java.util.ArrayList;

public final class SolutionNode {

    SolutionNode parent;

    ArrayList<SolutionNode> childs;

    ArrayList<Tuple> setup;

    int n;

    public SolutionNode(Tuple value, SolutionNode parent, ArrayList<Tuple> setup, int n) {
        this.n = n;
        this.parent = parent;
        this.setup = setup;
        this.setup.add(value);
        this.check();
        this.createChilds();
    }
    
    public SolutionNode(int n) {
        this.n = n;
        this.parent = null;
        this.setup = new ArrayList<>();
        this.createChilds();
    }

    public void printSetup() {
        for (int i = 0; i < setup.size(); i++) {
            setup.get(i).print();
        }
    }

    public boolean isInSetup(Tuple tup) {
        for (int i = 0; i < this.setup.size(); i++) {
            if (this.setup.get(i).equals(tup)) {
                return true;
            }
        }
        return false;
    }

    public void createChilds() {
        this.childs = new ArrayList<>(); 
//        for (int i = this.setup.size() > 0 ? (this.setup.get(this.setup.size() - 1).first) : 0; i < n; i++) {
//            for ( int j = this.setup.size() > 0 ? (this.setup.get(this.setup.size() - 1).second) + 1 : 0; j < n; j++ ) {
//                if (!isInSetup(new Tuple(i, j))) {
//                    this.childs.add(new SolutionNode(new Tuple(i, j), this, new ArrayList(this.setup), n));
//                }
//            }
//        }
        
        for (int k = this.setup.size() > 0 ? (this.setup.get(this.setup.size() - 1).first*this.n+
                                            this.setup.get(this.setup.size() - 1).second)+1 : 0; k < this.n*this.n; k++) {
            if( setup.size() < this.n )
                this.childs.add(new SolutionNode(new Tuple(k/this.n, k%this.n), this, new ArrayList(this.setup), n));
        }
    }
    
    public boolean check(){
        boolean result = false;
        Board b = new Board(this.setup, this.n);
        if( result = b.isValidSetup() && setup.size() == this.n) {
            b.print();
        }
       
        return result;
    }
    
}
