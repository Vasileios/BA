//Vasilis Agiomyrgianakis BA classes SC 150811 cc
BASynthPad{



 	classvar <>server;
	var name;



	// Constructor

	*new{
		arg n;
		var obj;


		server = Server.local;
		obj = super.new;

		obj.init(n);

		obj.initPattern;

		^obj;
	}

	init{ arg n;
Ndef.all.clear;
	//SynthDef
		/*\\freqs, [2000.3, 400.4, 845.66].pbrown +([100, 8000].prand),
\\rings, [0.03, 0.04, 0.0266].pbrown +([0.01, 0.4].prand),
\\amps, (#[0.3, 0.2, 0.5, 0.255].prand)
		*/
SynthDef(\klank01, {|out = 0, gate = 1, vol = 0.0001, freq = 440, decay = 0.02, char, cutoff = 2000, amp = 0.01, trig = 1, shape,
         freqs (#[100, 200, 300, 600]),
         amps (#[0.3, 0.2, 1, 0.05]),
         rings (#[1, 0.1, 0.5, 2]), pan = 0|
         var env, source, filter;
	env = EnvGen.kr(Env([0, 1, 0], [shape, shape]), gate, doneAction: 2);
	//env = EnvGen.kr(Env.adsr(1, 0.7, 0.5, shape), gate, doneAction: 2);
         source = DynKlank.ar(`[freqs*freq, amps, rings], Dust.ar(trig)*WhiteNoise.ar(amp)
                              +SinOsc.ar(SinOsc.ar(freq*2, 444, 999), 0, 0.3)*SinOsc.ar(SinOsc.ar(freq*2.43, 2000*1/35+12, 1.2.rand+[2000, 200.202]), 0, 0.3)*0.0003);
         source = Decay.ar(source, decay, mul: amp).softclip;

         //source = LPF.ar(source, cutoff, 0.4, amp).softclip;
         Out.ar(out, Pan2.ar(source*env, pan))*vol
         }).add;

		~mbusesPad1 = [	~mbusPad1 = Bus.audio(server, 2);];
		Ndef(\padFilter).put(0, { InFeedback.ar(~mbusPad1, 2) }).fadeTime_(0.2).play;
		name = n;


		"Pbindef(\\pad): args:
|\\freq, \\decay,
\\cutoff, \\amp,
\\freqs, \\amps, \\rings|".postln

	}


	////// -  Patterns - //////

	initPattern{

		var cmdPeriodFunc, stop;
//Pdef
		Pdef(\pad).fadeTime_(4);
fork{
			/*~t = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~t.tempo = 2;

			~t.tempo.postln;
	"~t -> ~t.tempo = 2".postln;
			*/

			~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
			~metronomos.schedAbs(~metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~metronomos.tempo = 1;

			~metronomos.tempo.postln;
			"metronomos->t.tempo = 1".postln;

	0.1.wait;
Pdef(\pad,


     Pbind(\instrument, \klank01,
           //\freq, Prand([4.9, 2.1, 5.4, 2.3], inf),
           \freq, Pwhite((2.0..6.2)),
		   \char, "char".postcs,
		 \dur, 4,
		 \shape, Pseq([4, 2.5, 4, 3.3], inf),
           \pan, 0,
           \amp, 0.0,
			\out, ~mbusPad1
	 )).play(~metronomos, quant: 4);
};
	// set start button to zero upon a cmd-period

	{if(stop.value, {Pdef(\pad).stop;}, {nil})};

		cmdPeriodFunc = { Pdef(\pad).stop; };
CmdPeriod.add(cmdPeriodFunc);


}

}
