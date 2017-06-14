class Board{
	private:
		int length;
		bool **table;
	public:
		Board( int );
		~Board();
		void print();
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