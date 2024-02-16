HihatEnvII {

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

 MyEnvir.hihat2 = Pbindef(\hihat2).fadeTime_(1);
		 fork{
			/*						~t = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~t.tempo = 1;

			~t.tempo.postln;
			"~t -> ~t.tempo = 1".postln;

			//~hihat2 =Pbindef(\hihat2, \buf, ~bufs[5]);
*/
			 MyEnvir.metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			 MyEnvir.metronomos.schedAbs(MyEnvir.metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			MyEnvir.metronomos.tempo = 1;

			MyEnvir.metronomos.tempo.postln;
			"~metronomos->t.tempo = 1".postln;
/*metronomos = TempoClock(1);
			metronomos.schedAbs(metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			metronomos.tempo = 1;

			metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;
*/
		MyEnvir.hihat2 = Pbindef(\hihat2, \buf, MyEnvir.bufs[5]);
			0.1.wait;
		MyEnvir.hihat2 = Pbindef(\hihat2, \freq, 620, \dur, Pseq([0.25, 0.25, 0.25, 0.25], inf), \amp, Prand([0.54, 0.43, 0.65, 0.36], inf), \amp, 0.000001);//.play(metronomos, quant: 4);

		//~t = TempoClock(4/4);

			0.5.wait;

		MyEnvir.hihat2 = Pbindef(\hihat2, \instrument, \bf, \out, MyEnvir.mbus6).play(MyEnvir.metronomos, quant: 4);

};

	"Pbindef(\\hihat2) -> args: \\freq, \\dur, \\amp, \\pan, \\cutoff...Filter Ndef(\\d6)".postln;

	}

}