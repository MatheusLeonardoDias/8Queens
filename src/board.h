class Board{
	private:
		int length;
		bool **table;
	public:
		Board( int );
		~Board();
		void print();
		std::list<std::pair<int,int>> safePositionsBacktracking();
		bool isSafePosition( std::pair<int,int> a, std::pair<int,int> b );
};

Board::Board( int n ){
	table = new bool*[n];
	if( table == NULL ){
		std::cerr << "Cannot allocate table matrix." << std::endl;
		exit(1);
	}

	for (int i = 0; i < n; ++i){
		table[i] = new bool[n];
		// memset( table[i], sizeof( bool ) * length, false );
		for (int j = 0; j < n; ++j){
			table[i][j] = false;
		}
	}
	std:: cout << table[1][1] << std::endl;


	length = n;
}

Board::~Board( ){
	for (int i = 0; i < length; ++i){
		delete[] table[i];
	}
	delete[] table;
}

void Board::print(){

	for (int i = 0; i < length; ++i){

		for (int j = 0; j < length; ++j){
			std::cout << "|" << ( table[i][j] ? "X":"0" ) << "|"; 
		}
		std::cout << std::endl;

	}

}

std::list<std::pair<int,int>> Board::safePositionsBacktracking( int current ){

	if( current >= this.lenght )
		return true;

	for( int i = 0; i < this.lenght; i++ ){
		if( isSafePosition( std::make_pair( i, current ) ) ){

		}


	}

}

bool Board::isSafePosition( std::pair<int,int> a ){

	// Row
	for( int i = 0; i < this.lenght; i++ ){
		if( table[i][a.second] == true )
			return false;
	}

	// Upper Diagonal
	for( int i = 0; i < this.lenght; i++ ){
		if( table[i][a.second] == true )
			return false;
	}

	// Lower Diagonal
	for( int i = 0; i < this.lenght; i++ ){
		if( table[i][a.second] == true )
			return false;
	}
}




