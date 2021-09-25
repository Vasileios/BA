//Vasilis Agiomyrgianakis BA classes SC 150811 cc
// =====================================================================
// SuperCollider Workspace
// =====================================================================
// =====================================================================
// SuperCollider Workspace
// =====================================================================




BAChaosCL{


 
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
	
		SynthDef(\noiseL1, {|out = 0, freq = 220, alpha  = 1, beta = 1.9, xi = 0, amp = 0.1, cutoff = 3000, pan = 0, vol = 0.5, fadein = 1, fadeout = 1|

			var env, source;

			env = EnvGen.kr(Env([0, 1, 0], [fadein, fadeout] ));
			source = SinOsc.ar(SinOsc.ar(freq*7, freq*6, freq/2), 0, amp)*Saw.ar(Saw.ar(freq*2, freq/0.5), amp)*WhiteNoise.ar(amp)+Saw.ar(freq/4, amp)*CuspL.ar(freq, alpha, beta, xi, amp)*0.2;
        // source = Decay.ar(source, decay, mul: amp).softclip;
         source = LPF.ar(source, cutoff,  amp).softclip;
         
         //source = LPF.ar(source, cutoff, 0.4, amp).softclip;
         Out.ar(out, Pan2.ar(source*env, pan))*vol
         }).add;
		
		name = n;


		"Pbindef(\\noiseL1): args: 
|(freq: 22050, alpha: 1, beta: 1.9, xi: 0, mul: 1, add: 0, cutoff)|".postln
		
	}
	
			
	////// -  Patterns - //////

	initPattern{

		var cmdPeriodFunc, stop;
//Pdef
Pdef(\noiseL1).fadeTime_(4);
Pdef(\noiseL1,


     Pbind(\instrument, \noiseL1,  
           //\freq, Prand([4.9, 2.1, 5.4, 2.3], inf),
           //\freq, Pwhite((12050..22050)),

           \dur, 4,
           \pan, 0,
           \amp, 0.0
           ));
	
	// set start button to zero upon a cmd-period

	{if(stop.value, {Pdef(\noiseL1).stop;}, {nil})};

		cmdPeriodFunc = { Pdef(\noiseL1).stop; };
CmdPeriod.add(cmdPeriodFunc);


}

}





