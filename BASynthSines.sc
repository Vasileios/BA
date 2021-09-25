//Vasilis Agiomyrgianakis BA classes SC 150811 cc
BASynthSines{

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




	init{|n|

		

		SynthDef(\sines, {|outbus = 0, buffoffset = 0, offsetval = 0, gate = 1, freq = 261.63, freq2 = 329.63, freq3 = 415.30, freqdust = 1, amp = 0.4, pan = 0, vol = 0.03, fadeinvl, fadeoutvl, fadeindr, fadeoutdr, char|
	
	var env, source;
	
	
	
	env = EnvGen.kr(Env([fadeinvl, 1, fadeoutvl], [fadeindr, fadeoutdr]), gate, doneAction: 2);
	
	source = 	SinOsc.ar([freq, freq2, freq3], 0, amp*env)+Saw.ar([freq, freq2, freq3], 0, amp*env)+FSinOsc.ar([freq*2, freq2*2, freq3*2], 0.5, amp*env)+SinOsc.ar(SinOsc.ar(freq*4, freq2*4, freq3*4), 0, amp*env);
	Out.ar(outbus, Pan2.ar(source*vol, pan))!2
}).add;
			name = n;


		"Pbindef(\\sinepad): args: 
|\\freq, \\freq1, \\freq3, \\freqdust, \\bwr, \\offsetval, \\buffoffset,, 
 \\amp, \\pan 
|".postln
}
	
	initPattern{

		
		
		var cmdPeriodFunc, stop;
//Pdef
		Pdef(\sinepad).fadeTime_(4);
fork{
		~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
	~metronomos.schedAbs(~metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

			~metronomos.tempo = 2;

			~metronomos.tempo.postln;
	"~t -> ~t.tempo = 2".postln;
	0.1.wait;
Pdef(\sinepad,


     Pbind(\instrument, \sines,  
           //\freq, Prand([4.9, 2.1, 5.4, 2.3], inf),
		 \freq, Prand((20..600), inf),
		 \freq1, Prand((100..300), inf),
		 \freq2, Prand((300..500), inf),
	 	 \freq3, Prand((700..2000), inf),
		 \bufoffset, 0,
		 \offsetval, 3,
		 \dur, 4,
		 \fadeinvl, 0,
		 \fadeoutvl, 0,
		 \fadeindr, 2,
		 \fadeoutdr, 2,
           \pan, 0,
           \amp, 0.0
	 )).play(~metronomos, quant: 4);
};
	// set start button to zero upon a cmd-period

	{if(stop.value, {Pdef(\sinepad).stop;}, {nil})};

		cmdPeriodFunc = { Pdef(\sinepad).stop; };
CmdPeriod.add(cmdPeriodFunc);

	}


	
}