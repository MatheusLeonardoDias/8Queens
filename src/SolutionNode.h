#include <bits/stdc++.h> 

class SolutionNode{
	private:
		int* parent;
		std::vector<SolutionNode> *child;
		std::vector< std::pair<int,int> > setup;
	public:
		SolutionNode( std::pair<int,int>, int, std::vector<std::pair<int,int>> );
		void ChildsFactory(int);
};

SolutionNode::SolutionNode( std::pair<int,int> value, int N, std::vector<std::pair<int,int>> setup ){
 	this->setup = setup;
 	setup.push_back( value );
 	ChildsFactory( N );
 	// child = new child[N];
}

void SolutionNode::ChildsFactory( int N ){
	child = new std::vector<SolutionNode> (N);
	for (int i = 0; i < N; ++i){
		for (int j = 0; j < N; ++j ){
			for (int k = 0; k < setup.size(); ++k){
				if( setup[k].first != i && setup[k].second != j )
					child[i] = SolutionNode( std::make_pair( i, j ), N-1, setup );
			}
		}
	}

}

