#include <bits/stdc++.h>
#include "board.h"
#include "SolutionNode.h"
using namespace std;

int main( int argc, char* argv[] ){
	long length = 8;

	if( argc > 1 )
		length = atol( argv[1] );

	Board *b = new Board( length );

	b->print();
	delete b; 

	return 0;
}
