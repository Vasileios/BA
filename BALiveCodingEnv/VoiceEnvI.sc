VoiceEnvI{

	classvar <>server;
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

		Pbindef(\voice1).fadeTime_(1);
		fork{

			MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			MyEnvir.metronomos.tempo.postln;

			Pbindef(\voice1, \buf, 	MyEnvir.bufs4[0]);
0.1.wait;

			Pbindef(\voice1, \freq, 620, \dur, Pseq([0.5, 0.5, 0.5, 0.5], inf), \amp, 0.000001/*Prand([0.4, 0.3, 0.5, 0.36], inf)*/);

		//~t = TempoClock(4/4);

0.5.wait;

			Pbindef(\voice1, \instrument, \bf, \out, MyEnvir.mbus13).play(MyEnvir.metronomos, quant: 4);

};

		"Pbindef(\\voice1) -> args: \\freq, \\dur, \\amp, \\pan".postln;
	}

}