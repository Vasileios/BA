SnareEnvI {

	classvar <>server;
	//classvar <>metronomos;
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

	MyEnvir.snare1 = Pbindef(\snare).fadeTime_(1);
		fork{

				MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			MyEnvir.metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;



// schedule an event at next whole beat

		MyEnvir.snare1 = Pbindef(\snare, \buf, MyEnvir.bufs[3]);
0.1.wait;

		MyEnvir.snare1 = Pbindef(\snare, \dur, Pseq([1, 0, 1, 0], inf), \amp, 0.00001, \freq, 400);//.play(metronomos, quant: 4);

		//~t = TempoClock(4/4);

			0.5.wait;

		MyEnvir.snare1 = Pbindef(\snare, \instrument, \bf, \out, MyEnvir.mbus4).play(MyEnvir.metronomos, quant: 4);

	};

		"Pbindef(\\snare) -> args: \\freq, \\dur, \\amp, \\pan".postcln;
		//name = n;
	}

}