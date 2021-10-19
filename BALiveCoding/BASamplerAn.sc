BASamplerAn{
 
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
		
	//SynthDef



	fork{

			// setup sample paths and \bf synth

		~samplespathSamp =  Platform.userExtensionDir +/+ "BA/sounds/";
	~bufferSampler = (~samplespathSamp ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});

	~bufferSampler[2].postln;
0.1.wait;
		
 

SynthDef(\phasorAn, {| bufnum, fact = 0.5, gate = 1, cutoff = 4440, rate = 1, freq = 200, trig = 1, start = 0.2, samplePos = 0, end = 1, pan = 0, vol = 0.5, amp = 0.1, lfamp = 0.5, envindur = 2, envoutdur = 2 |
	
	var env, trigger, phasor, rand;
	
	env = EnvGen.kr(Env([0, 1, 0],[envindur, envoutdur]), gate, doneAction: 2);
	trigger = Dust.kr(trig);

	phasor = Phasor.ar(

				trigger, // when the value of the trigger changes from non-positive to possitive, reset the output value and 
				//choose resetPos value 
				rate * BufRateScale.kr(LFNoise0.kr(bufnum)), // control the rate of playback
				start * BufFrames.kr(bufnum), // define start point of playback
				end * BufFrames.kr(bufnum), // define end point of playback
				samplePos						// define the position of reset when triggered by trig
			);
			phasor = LPF.ar(phasor, cutoff, lfamp);
	Out.ar(0, Pan2.ar(BufRd.ar(2, bufnum, 
			
		phasor)*env*amp, pan), 0, 1)*vol;
	}).add;

~samplerAn = Synth(\phasorAn, [\gate, 0, \bufnum, ~bufferSampler[2]]);


	};//fork ends here
		name = n;

		"Pbindef(\\samplerAn): args: 
|\\rate, \\start, \\end, 
\\samplePos, \\cutoff, \\amp|".postln
	}
	
	////// -  Patterns - //////

	initPattern{

		var cmdPeriodFunc, stop;
//Pdef
		Pdef(\samplerAn).fadeTime_(4);

		~metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
		//~t.schedAbs(~t.beats.ceil, { arg beat, sec; [beat, sec]; 1 });

		//	~t.tempo = 2;

		//	~t.tempo.postln;
		//"~t -> ~t.tempo = 2".postln;

Pdef(\samplerAn,


     Pbind(\instrument, \phasorAn,  
		  \bufnum, ~bufferSampler[2],
		 \gate, 1,
           \rate, 1,
		 \trig, 1,
		 \start, 0.01,
		 \end, 0.99,
		 \samplePos, 0.1,
		 \cutoff, 8000,
           \pan, 0,
           \amp, 0.0
	 )).play(~metronomos, quant: 4);

	// set start button to zero upon a cmd-period

{if(stop.value, {Pdef(\samplerAn).stop;}, {nil})};

		cmdPeriodFunc = { Pdef(\samplerAn).stop;
			~bufferSampler.free.postln;
		};
		 
CmdPeriod.add(cmdPeriodFunc);

	}


}


