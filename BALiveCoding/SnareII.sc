//Vasilis Agiomyrgianakis BA classes SC 150811 cc
SnareII {

	classvar <>server;
	classvar <>metronomos;
	var name;

	//Constructor

	*new{
		arg n;
		var obj;

		server = Server.local;
		obj = super.new;

		obj.init(n);

		//obj.initPattern;

		^obj;
	}

	init{ arg n;

~snare2	=	 Pbindef(\snareS).fadeTime_(1);
		~f = fork{
			/*						~t = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~t.tempo = 1;

			~t.tempo.postln;
			"~t -> ~t.tempo = 1";
			*/
			//~snare2 = Pbindef(\snareS, \buf, ~bufs[3]);

							~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			~metronomos.schedAbs(~metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~metronomos.tempo = 1;

			~metronomos.tempo.postln;
			//"~metronomos->t.tempo = 1".postln;
			
0.1.wait;

~snare2	=Pbindef(\snareS, \instrument, \bf, \buf, ~bufs[3], \out, ~mbus7, \dur, Pseq([1, 0, 1, 0], inf), \amp, 0.00001, \freq, 400).play(~metronomos, quant:4);

		//~t = TempoClock(4/4);

			//0.5.wait;

			//~snare2	= Pbindef(\snareS, \instrument, \bf, \out, ~mbus7).play(metronomos, quant: 4);

	};
		
		"Pbindef(\\snareS) -> args: \\freq, \\dur, \\amp, \\pan".postcln;
		//name = n;
	}
	
}