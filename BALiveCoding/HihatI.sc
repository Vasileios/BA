//Vasilis Agiomyrgianakis BA classes SC 150811 cc
HihatI {

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


	~hihat1 =  Pbindef(\hihat1).fadeTime_(1);
		~f = fork{
			/*
~t = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~t.tempo = 1;

			~t.tempo.postln;
			"~t->t.tempo = 1".postln;


			//~hihat1 =Pbindef(\hihat1, \buf, ~bufs[4]);

			*/
			~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			~metronomos.schedAbs(~metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~metronomos.tempo = 1;

			~metronomos.tempo.postln;
			"~metronomos->t.tempo = 1".postln;
/*
metronomos = TempoClock(1);
			metronomos.schedAbs(metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			metronomos.tempo = 1;

			metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;
*/
			~hihat1  =Pbindef(\hihat1, \buf, ~bufs[4]);
			0.1.wait;

~hihat1 =Pbindef(\hihat1, \freq, 620, \dur, Pseq([0.25, 0.25, 0.25, 0.25], inf), \amp, Prand([0.54, 0.43, 0.65, 0.36], inf), \amp, 0.000001);//.play(metronomos, quant: 4);

		//~t = TempoClock(4/4);

			0.5.wait;

			~hihat1 = Pbindef(\hihat1, \instrument, \bf, \out, ~mbus5).play(~metronomos, quant: 4);

		};

		"Pbindef(\\hihat1) -> args: \\freq, \\dur, \\amp, \\pan ...Filter Ndef(\\d5)".postln;
	}

}