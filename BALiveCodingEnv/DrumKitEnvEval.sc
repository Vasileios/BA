DrumKitEnvEval{



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




fork{
2.wait;
			0.1.wait;
			KickEnvI();
			//0.1.wait;
			KickEnvII();
			//0.1.wait;
			SnareEnvI();
			//0.1.wait;
			//SnareII();
			//0.1.wait;
			HihatEnvI();
			//0.1.wait;
			HihatEnvII();
			//0.1.wait;
			BassEnvI();
			//0.1.wait;
			PadEnvI();
			//BAChaosCL();
			VoiceEnvI();
			VoiceEnvII();


	//~kick1 = Pbindef(\kick1, \amp, 0.6, \shape, 0.01, \dur, Pseq([Rest(1), 1], inf));


	//~kick2 = Pbindef(\kick2, \amp, 0.6, \shape, 0.01, \dur, Pseq([0.25, 1, 0.5, 1, 0.5, 0.25, 0.5],inf));




	//~snare1 = Pbindef(\snare, \amp, 0.3, \shape, 0.02, \freq, 233,\dur, Pseq([1, 1, 1, 1],inf));


	//~hihat1	= Pbindef(\hihat1, \amp, 1, \dur, 1);

	0.5.wait;

	MyEnvir.syncDrums  = Ppar([MyEnvir.kick1, MyEnvir.kick2, MyEnvir.snare1, MyEnvir.hihat1, MyEnvir.hihat2, MyEnvir.bass1, MyEnvir.pad1, MyEnvir.voice1, MyEnvir.voice2]);

	//~syncDrums  = Ppar([~kick1]);

	0.1.wait;
	MyEnvir.syncDrums;
//server.sync;
};
	}


}