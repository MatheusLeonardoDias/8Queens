package pkg8queens;

import java.util.ArrayList;
import java.util.BitSet;

public final class SolutionNode {

    SolutionNode parent;

    ArrayList<SolutionNode> childs;
    
    ArrayList<Tuple> setup;
    
    BitSet columns;
    
    int n;

    public SolutionNode(Tuple value, SolutionNode parent, ArrayList<Tuple> setup, BitSet columns, int n) {
        this.n = n;
        this.parent = parent;
        this.setup = setup;
        this.columns = columns;
        this.setup.add(value);
//        System.out.println(this.columns);
        if( this.setup.size() == this.n )
            this.check();
        this.createChilds();
    }
    
    public SolutionNode(int n) {
        this.n = n;
        this.parent = null;
        this.setup = new ArrayList<>();
        this.columns = new BitSet(this.n);
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
        
//        for (int k = this.setup.size() > 0 ? (this.setup.get(this.setup.size() - 1).first*this.n+
//                                            this.setup.get(this.setup.size() - 1).second)+1 : 0; k < this.n*this.n; k++) {
//            if( setup.size() < this.n )
//                this.childs.add(new SolutionNode(new Tuple(k/this.n, k%this.n), this, new ArrayList(this.setup), n));
//        }
        
        for (int k = this.setup.size() > 0 ? ( ( this.setup.get(this.setup.size()-1).first%this.n )+1 )*this.n : 0; k < this.n*this.n; k++) {
            if( setup.size() < this.n && !columns.get(k%this.n) ){
                columns.set(k%this.n, true);
                this.childs.add(new SolutionNode(new Tuple(k/this.n, k%this.n), this, new ArrayList(this.setup),( BitSet ) this.columns.clone(), n));
            }
            columns.set(k%this.n, false);
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
