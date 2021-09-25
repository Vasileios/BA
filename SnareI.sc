//Vasilis Agiomyrgianakis BA classes SC 150811 cc
SnareI {

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

~snare1	=  Pbindef(\snare).fadeTime_(1);
		~f = fork{
			/*						~t = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~t.tempo = 1;

			~t.tempo.postln;
			"~t -> ~t.tempo = 1".postln;


*/
				~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			~metronomos.schedAbs(~metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~metronomos.tempo = 1;

			~metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;



// schedule an event at next whole beat
/*
			metronomos = TempoClock(1);
			metronomos.schedAbs(metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			metronomos.tempo = 1;

			metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;

*/
			~snare1	= Pbindef(\snare, \buf, ~bufs[3]);
0.1.wait;

~snare1	=Pbindef(\snare, \dur, Pseq([1, 0, 1, 0], inf), \amp, 0.00001, \freq, 400);//.play(metronomos, quant: 4);

		//~t = TempoClock(4/4);

			0.5.wait;

				~snare1	= Pbindef(\snare, \instrument, \bf, \out, ~mbus4).play(~metronomos, quant: 4);

	};

		"Pbindef(\\snare) -> args: \\freq, \\dur, \\amp, \\pan".postcln;
		//name = n;
	}

}