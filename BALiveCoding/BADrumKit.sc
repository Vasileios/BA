//Vasilis Agiomyrgianakis BA classes SC 150811 cc
BADrumKit{


 
 	classvar <>server;
	var name;
	
	

	// Constructor
	
	*new{
		arg n;
		var obj;
		
		
		server = Server.local;
		obj = super.new;
		
		obj.init(n);
		
		

		^obj;
	}

	init{ arg n;
		

BASynthBeat();  DrumKitEval();


	}

}