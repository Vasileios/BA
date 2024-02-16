// =====================================================================
// SuperCollider Workspace
// =====================================================================


BASynthBeatII{



 	classvar <>server, <>bufs, <>bufs2, <>bufs3, <>bufs4;
	classvar <>metronomos;
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

//Pdef.all.clear;
Ndef.all.clear;
server.waitForBoot{
	// setup sample paths and \bf synth
//==============================percs===============================
//Buffer.alloc(s, 40000, 2);

//~dict = ["kick1", "kick2", "snare"];

MyEnvir.percpath =  Platform.userExtensionDir +/+ "BASynths/sounds/sounds_drums/drums/";
MyEnvir.bufs = (MyEnvir.percpath ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});
MyEnvir.bufs.postln;
	//~percpath = Platform.userExtensionDir +/+ "BASynths/sounds/sounds_drums/drums/";
	//~bufs = (percpath ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});

	//~bufs.postln;
//==============================basses===============================
	MyEnvir.basspath = Platform.userExtensionDir +/+ "BASynths/sounds/sounds_drums/basses/";
	MyEnvir.bufs2 = (MyEnvir.basspath ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});

			MyEnvir.bufs2.postln;
//==============================pads===============================
MyEnvir.padpath = Platform.userExtensionDir +/+ "BASynths/sounds/sounds_drums/pads/";
	MyEnvir.bufs3 = (MyEnvir.padpath ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});

			MyEnvir.bufs3.postln;
//==============================voices===============================
MyEnvir.voicepath = Platform.userExtensionDir +/+ "BASynths/sounds/sounds_drums/voices/";
	MyEnvir.bufs4 = (MyEnvir.voicepath ++ "*.wav").pathMatch.collect({ |i|  Buffer.read(server, i)});

			MyEnvir.bufs4.postln;


//~padpath = "../sounds/pads/";




	SynthDef(\bf, {|out=0, buf=1023, amp=0.1, pos = 0, freq=261.6255653006, cutoff = 16000, pan = 0, shape= 0.1, char|
		var sig, env, comp;

			env = EnvGen.kr(Env.perc(shape, 0.1), 1, doneAction: 2);
		sig = PlayBuf.ar(1, buf, BufRateScale.kr(buf) * freq/60.midicps, 1, pos, doneAction:2);

		sig  = LPF.ar(sig, cutoff, amp);
	comp =  Compander.ar(sig, sig,
        thresh: 0.2,
        slopeBelow: 1,
        slopeAbove: 0.5,
        clampTime:  0.01,
        relaxTime:  0.01
    );
		Out.ar(out, Pan2.ar(comp *env* amp, pan))
	}).add;



MyEnvir.mbus1 = Bus.audio(server, 2);
MyEnvir.mbus2 = Bus.audio(server, 2);
MyEnvir.mbus3 = Bus.audio(server, 2);
MyEnvir.mbus4 = Bus.audio(server, 2);
MyEnvir.mbus5 = Bus.audio(server, 2);
MyEnvir.mbus6 = Bus.audio(server, 2);
MyEnvir.mbus7 = Bus.audio(server, 2);
MyEnvir.mbus8 = Bus.audio(server, 2);
MyEnvir.mbus9 = Bus.audio(server, 2);
MyEnvir.mbus10 = Bus.audio(server, 2);
MyEnvir.mbus11 = Bus.audio(server, 2);
MyEnvir.mbus12 = Bus.audio(server, 2);
MyEnvir.mbus13 = Bus.audio(server, 2);
MyEnvir.mbus14 = Bus.audio(server, 2);
MyEnvir.mbus15 = Bus.audio(server, 2);
MyEnvir.mbus16 = Bus.audio(server, 2);
MyEnvir.mbus17 = Bus.audio(server, 2);


	//	];	//////////////////////////DRUMS/////////////////////////////////
	Ndef(\kick1).put(0, { InFeedback.ar(MyEnvir.mbus1, 2) }).fadeTime_(0.2).play;
	Ndef(\kick2).put(0, { InFeedback.ar(MyEnvir.mbus2, 2) }).fadeTime_(0.2).play;
	Ndef(\kick3).put(0, { InFeedback.ar(MyEnvir.mbus3, 2) }).fadeTime_(0.2).play;
	Ndef(\snare).put(0, { InFeedback.ar(MyEnvir.mbus4, 2) }).fadeTime_(0.2).play;
	Ndef(\hihat1).put(0, { InFeedback.ar(MyEnvir.mbus5, 2) }).fadeTime_(0.2).play;
	Ndef(\hihat2).put(0, { InFeedback.ar(MyEnvir.mbus6, 2) }).fadeTime_(0.2).play;
	//Ndef(\snareS).put(0, { InFeedback.ar(~mbus7, 2) }).fadeTime_(0.2).play;

	////////////////////////BASSES////////////////////////////////////

	Ndef(\bass1).put(0, { InFeedback.ar(MyEnvir.mbus9, 2) }).fadeTime_(0.2).play;

	/////////////////PADS///////////////////


	Ndef(\p1).put(0, { InFeedback.ar(MyEnvir.mbus8, 2) }).fadeTime_(0.2).play;
	//Ndef(\p2).put(0, { InFeedback.ar(~mbus9, 2) }).fadeTime_(0.2).play;
	Ndef(\pad1).put(0, { InFeedback.ar(MyEnvir.mbus10, 2) }).fadeTime_(0.2).play;
	Ndef(\p4).put(0, { InFeedback.ar(MyEnvir.mbus11, 2) }).fadeTime_(0.2).play;
	Ndef(\p5).put(0, { InFeedback.ar(MyEnvir.mbus12, 2) }).fadeTime_(0.2).play;
///////////////////////VOICES/////////////////////////
	Ndef(\voice1).put(0, { InFeedback.ar(MyEnvir.mbus13, 2) }).fadeTime_(0.2).play;
	Ndef(\voice2).put(0, { InFeedback.ar(MyEnvir.mbus14, 2) }).fadeTime_(0.2).play;
	Ndef(\p8).put(0, { InFeedback.ar(MyEnvir.mbus15, 2) }).fadeTime_(0.2).play;
	Ndef(\p9).put(0, { InFeedback.ar(MyEnvir.mbus15, 2) }).fadeTime_(0.2).play;
	Ndef(\p10).put(0, { InFeedback.ar(MyEnvir.mbus16, 2) }).fadeTime_(0.2).play;

	// tempo clocks

	//~metronomos = TempoClock(140/60).permanent_(true);





	"SynthDef \\bf (args: buf, freq, amp)".postcln;
	"loaded ~bufs 17 with percsamples, bass, fellfx - Check post window for Buffer  num".postcln;
	"tempo clocks ~tempoC".postcln;

"Use Patterns to manipulate samples	i.e Pbindef(\\kick1, \\buf, ~bufs[0]) ==> Pbindef(\\kick1, \\instrument, \\bf, \\out, ~mbus1).play(t, quant: 4)

Example:
Use Filters with Ndefs => Ndef \\d1-d9 for
Pbindef(\\kick1) => ~bufs[0] => ~mbus1, => Ndef(\\d1)
Pbindef(\\kick2) => ~bufs[1] => ~mbus2, => Ndef(\\d2)
Pbindef(\\kick3) => ~bufs[2] => ~mbus3, => Ndef(\\d3)
Pbindef(\\snare) => ~bufs[3] => ~mbus4, => Ndef(\\d4)

Pbindef(\\hihat1) => ~bufs[4] => ~mbus5, => Ndef(\\d5)
Pbindef(\\hihat2) => ~bufs[5] => ~mbus6, => Ndef(\\d6)
//Pbindef(\\snareS) => ~bufs[6] => ~mbus7, => Ndef(\\d7)
//Pbindef(\\crash) => ~bufs[7] => ~mbus8, => Ndef(\\d8)
Pbidnef(\\bass) => ~bufs[8] => ~mbus7 => Ndef(\\d9)
Ndef(\\d1-d9) are mixer nodes, listning to ~mbus1, 2, 3, 4, 5, 6, 7, 8, 9

Ndef \\p1-p8 for
Pbindef(\\blnk), => ~bufs[9] => ~mbus10, => Ndef(\\p1)
Pbindef(\\boschwitz), => ~bufs[10] => ~mbus11, => Ndef(\\p2)
Pbindef(\\bwawp), => ~bufs[11] => ~mbus12, => Ndef(\\p3)
Pbindef(\\doing), => ~bufs[12] => ~mbus13, => Ndef(\\p4)
Pbindef(\\laser_buzz), => ~bufs[13] => ~mbus14, => Ndef(\\p5)
Pbindef(\\machine), => ~bufs[14] => ~mbus15, => Ndef(\\p6)
Pbindef(\\silent), => ~bufs[15] => ~mbus16, => Ndef(\\p7)
Pbindef(\\surfactant_15_xilo) => ~bufs[16] => ~mbus17, => Ndef(\\p8)
are mixer nodes, listning to ~mbus10, 11, 12, 13, 14, 15, 16, 17


To use a filter do=>
Ndef(\\d1).put(1, \\filter-> {|in| DFM1.ar(in, 8000, 0.01, 1.15)})
Ndef(\\d1).put(2, \\filter-> {|in| LeakDC.ar(in)})
To remove e filter: Ndef(\\d1).put(1, nil)


Contains:
Metro(s),
KickI(s),
KickII(s),
HihatI(s),
HihatII(s),
BassI(s),
SnareI(s),
SnareII(s)
".postcln;

	nil.value;
};


		name = n;
	}


	////// -  Patterns - //////

	initPattern{

		var cmdPeriodFunc, stop;
//Pdef

Pdef.all.asCompileString;


/*
~kick1 = Pbindef(\kick1).fadeTime_(1);
if(
~kick1 = true, { fork{
 Pbindef(\kick1, \buf, ~bufs[0]);
0.1.wait;
//~kick1 = Pbindef(\kick1, \buf, ~bufs[0]);
~t = TempoClock(4/4);

0.5.wait;

 Pbindef(\kick1, \instrument, \bf, \out, ~mbus1).play(~t, quant: 4);
};}.postln;,{nil}

);
*/
/*
KickI(server);
KickII(server);
SnareI(server);
SnareII(server);
HihatII(server);
HihatII(server);
*/
//~allDrums = [
MyEnvir.kick1 = Pbindef(\kick1).fadeTime_(1);
MyEnvir.kick2  = Pbindef(\kick2).fadeTime_(1);
MyEnvir.kick3 = Pbindef(\kick3).fadeTime_(1);
MyEnvir.snare2 = Pbindef(\snareS).fadeTime_(1);

MyEnvir.snare1 = Pbindef(\snare).fadeTime_(1);
MyEnvir.hihat1 = Pbindef(\hihat1).fadeTime_(1);
MyEnvir.hihat2 = Pbindef(\hihat2).fadeTime_(1);
MyEnvir.crash1 = Pbindef(\crash).fadeTime_(1);
MyEnvir.bass1 = Pbindef(\bass).fadeTime_(1);
//];
//~drums = Ppar(~allDrums);
/////////////PADS//////////////

MyEnvir.pad1 = Pbindef(\blnk).fadeTime_(1);
Pbindef(\boschwitz).fadeTime_(1);
Pbindef(\bwawp).fadeTime_(1);
Pbindef(\doing).fadeTime_(1);
Pbindef(\laser_buzz).fadeTime_(1);

/////////////VOICES//////////////
MyEnvir.voice1 = Pbindef(\voice1).fadeTime_(1);
MyEnvir.voice2 = Pbindef(\voice1).fadeTime_(1);

//Pbindef(\machine).fadeTime_(1);
//Pbindef(\silent).fadeTime_(1);
//Pbindef(\surfactant_15_xilo).fadeTime_(1);
//	server.sync;
/*
if (~kick1.value, { fork{ 0.1.wait; ~t = TempoClock(4/4); 0.1.wait;
 Pbindef(\kick1, \buf, ~bufs[0]); 0.5.wait;
 Pbindef(\kick1, \instrument, \bf, \out, ~mbus1).play(~t, quant: 4);
 }; }, {nil}
);
*/
//seting up kick1

//~kick1buf = Pbindef(\kick1, \buf, ~bufs[0]);
//~kick1bus = Pbindef(\kick1, \instrument, \bf, \out, ~mbus1);



// set up patterns

// Fixed pattern blocks
// patterns
		//~eighth = Pseq([0.5, 0.5, 0.5, 0.5], 1);
		//~dactyl = Pseq([1, 0.5, 0.5], 1);
		//~anapest = Pseq([0.5, 0.5, 1], 1);
		//~trochee = Pseq([1, 0.5], 1);
		//~iamb = Pseq([0.5, 1], 1);

////////////////////
// livecoding example



//hi-hat




	// set start button to zero upon a cmd-period

		{if(stop.value, {Pdef(\hihat1).stop;}, {nil})};
		{if(stop.value, {Pdef(\kick1).stop;}, {nil})};
	    {if(stop.value, {Pdef(\kick2).stop;}, {nil})};
		{if(stop.value, {Pdef(\kick3).stop;}, {nil})};
		{if(stop.value, {Pdef(\snareS).stop;}, {nil})};

        {if(stop.value, {Pdef(\snare).stop;}, {nil})};
	    {if(stop.value, {Pdef(\hihat2).stop;}, {nil})};
	    {if(stop.value, {Pdef(\bass).stop;}, {nil})};
	    {if(stop.value, {Pdef(\crash).stop;}, {nil})};


		cmdPeriodFunc = { Pdef(\hihat1).stop.free; };
		cmdPeriodFunc = { Pdef(\kick1).stop.free; };
		cmdPeriodFunc = { Pdef(\kick3).stop.free; };
		cmdPeriodFunc = { Pdef(\snareS).stop.free; };

		cmdPeriodFunc = { Pdef(\snare).stop.free; };
		cmdPeriodFunc = { Pdef(\bass).stop.free; };
		cmdPeriodFunc = { Pdef(\hihat2).stop.free; };
		cmdPeriodFunc = { Pdef(\kick2).stop.free; };
		cmdPeriodFunc = { Pdef(\crash).stop.free; };

			//cmdPeriodFunc = {~bufs.free; };

///////////////////////////////PADS////////////////////////////

	    {if(stop.value, {Pdef(\blnk).stop;}, {nil})};
		{if(stop.value, {Pdef(\boschwitz).stop;}, {nil})};

		{if(stop.value, {Pdef(\bwawp).stop;}, {nil})};

		{if(stop.value, {Pdef(\doing).stop;}, {nil})};
		{if(stop.value, {Pdef(\laser).stop;}, {nil})};
/////////////////////////////////VOICES//////////////////////////

		{if(stop.value, {Pdef(\voice1).stop;}, {nil})};
	//	{if(stop.value, {Pdef(\machine).stop;}, {nil})};
	//	{if(stop.value, {Pdef(\silent).stop;}, {nil})};
	//	{if(stop.value, {Pdef(\surfactant_15_xilo).stop;}, {nil})};





		//cmdPeriodFunc = { Pdef(\synth01).stop; };
		//cmdPeriodFunc = { Pdef(\gtr01).stop; };

		cmdPeriodFunc = { Pdef(\blnk).stop.free; };
		cmdPeriodFunc = { Pdef(\boschwitz).stop.free; };

		cmdPeriodFunc = { Pdef(\bwawp).stop.free; };
		cmdPeriodFunc = { Pdef(\doing).stop.free; };

		cmdPeriodFunc = { Pdef(\laser).stop.free; };
		///////////////////////VOICES/////////////////////
		cmdPeriodFunc = { Pdef(\voice1).stop.free; };
		//cmdPeriodFunc = { Pdef(\machine).stop.free; };

		//cmdPeriodFunc = { Pdef(\silent).stop.free; };
		//cmdPeriodFunc = { Pdef(\surfactant_15_xilo).stop.free; };


			cmdPeriodFunc = {/*~bufs.free.postln; 	~mbusesPerc.free.postln;*/ /*Synth(\bf).free.postln;*/ };

CmdPeriod.add(cmdPeriodFunc);


}

}
