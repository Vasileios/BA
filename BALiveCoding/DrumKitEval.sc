//Vasilis Agiomyrgianakis BA classes SC 150811 cc
DrumKitEval{



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




fork{0.1.wait;KickI();0.1.wait;KickII();0.1.wait;SnareI();0.1.wait;SnareII();0.1.wait;HihatI();0.1.wait;HihatII();

	//~kick1 = Pbindef(\kick1, \amp, 0.6, \shape, 0.01, \dur, Pseq([Rest(1), 1], inf));


	//~kick2 = Pbindef(\kick2, \amp, 0.6, \shape, 0.01, \dur, Pseq([0.25, 1, 0.5, 1, 0.5, 0.25, 0.5],inf));




	//~snare1 = Pbindef(\snare, \amp, 0.3, \shape, 0.02, \freq, 233,\dur, Pseq([1, 1, 1, 1],inf));


	//~hihat1	= Pbindef(\hihat1, \amp, 1, \dur, 1);

	0.5.wait;

	~syncDrums  = Ppar([~kick1,~kick2,~snare1,~snare2, ~hihat1, ~hihat2]);
	0.1.wait;
	~syncDrums;

};
	}


}