//Vasilis Agiomyrgianakis BA classes SC 150811 cc
BASynthGens{

classvar <>server;
	//	classvar <>metronomos;
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


	BAChaosCL();
	BAFmSynth();
	BANastyPad();
	BASpacePadA();
	BASamplerLiveAn();
	BASynthGrainAn();
	BASynthPad();
	BASynthSines();


		"BAChaosCL,BAFmSynth,BANastyPad,BASpacePadA,BASynthGrainAn,BASamplerLiveAn, BASynthPad,BASynthSines".postln;
	}
}