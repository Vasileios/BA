//Vasilis Agiomyrgianakis BA classes SC 150811 cc
BASelect{

		classvar <>metronomos;
	//classvar <>name;



	//select Pbindef instrument by name and set argumetns of the synth

	//*instrument{|name, freq, dur, amp, shape, pan, cutoff, carfreq, modfreq, ind, decay, trig, pos, rate, vol, envbuf, sndbuf|

		//tempo.tempo = 1;
*instrument{
	//	var name;
	//	var fm, nasty, pad, grain, samplerLiveAn, noiseL1, sinepad, spacepad;
		//fm = \fm;
	///	nasty = \nasty;
	//	pad = \pad;
	//	grain = \grain;
	//	samplerLiveAn = \samplerLiveAn;
	//	noiseL1 = \noiseL1;
	//	sinepad = \sinepad;
	//	spacepad = \spacepad;
//*instrument{|... name|
		//	metronomos = TempoClock(1); // create a TempoClock

// schedule an event at next whole beat
//	metronomos.schedAbs(metronomos.beats.ceil, { arg beat, sec; [beat, sec]; 1 });
//name = IdentityDictionary[ (\fm -> Pdef('fm')), (\nasty -> Pdef('nasty')), (\pad -> Pdef('pad')), (\grain -> Pdef('grain')), (\samplerLiveAn -> Pdef('samplerLiveAn')), (\noiseL1 -> Pdef('noiseL1')), (\sinepad -> Pdef('sinepad')), (\spacepad -> Pdef('spacepad')) ];
//name = IdentityDictionary[ (fm -> Pdef('fm')), (nasty -> Pdef('nasty')), (pad -> Pdef('pad')), (grain -> Pdef('grain')), (samplerLiveAn -> Pdef('samplerLiveAn')), (noiseL1 -> Pdef('noiseL1')), (sinepad -> Pdef('sinepad')), (spacepad -> Pdef('spacepad')) ];

		//	metronomos.tempo = 1;

		//	metronomos.tempo.postln;
		//	"metronomos->t.tempo = 1".postln;

		//^name.postln;

 //arg name ... pairs;

	//	^super.newCopyArgs(name.asSymbol, pairs)

		//^Pbindef(name, \freq, freq, \shape, shape, \dur, dur, \amp, amp, \pan, pan, \cutoff, cutoff, \carfreq, carfreq, \modfreq, modfreq, \ind, ind, \decay, decay, \trig, trig, \pos, pos, \rate, rate, \vol, vol, \envbuf, envbuf, \sndbuf, sndbuf).play(~metronomos, quant:4);//.fadeTime_(1);
		//^Pbindef(name, freq, shape, dur, amp, pan, cutoff);
//^Pbindef(name, freq, shape, dur, amp, pan, cutoff, carfreq, modfreq, ind, decay, trig, pos, rate, vol, envbuf, sndbuf).play(~metronomos, quant:4);//.fadeTime_(1);
//^Pdef(name, freq, shape, dur, amp, pan, cutoff, carfreq, modfreq, ind, decay, trig, pos, rate, vol, envbuf, sndbuf).play(~metronomos, quant:4);//.fadeTime_(1);

	//^Pbindef(name).play(~metronomos, quant:4);//.fadeTime_(1);

	///	^Pbindef(name).asCompileString;///.play(~metronomos, quant:4);
		//name;
^IdentityDictionary[
	":"->Pbindef;
];
		//^Pbindef.asDefName;
	}


	*filter{|name, filternum = 1, filter, in =1, f1, f2, f3, amp|

//Ndef(name).mold(1, \audio, \elastic);
		//^Ndef(name)<<>.in Ndef(name, {filter});
		^Ndef(name);
		//.put(filternum, filter);
//name.postln;

	}


	/*
	////////////////////////////////////////////////////////////////////////////////////////

		*instrument{  arg key ... pairs;
		var pat, src;
		pat = super.new(key);
		src = pat.source;
		if(pairs.isEmpty.not) {
			if(src.class === PbindProxy) {
				src.set(*pairs);
				pat.wakeUp;
			} {
				if(src.isKindOf(Pbind))
				{
					src.patternpairs.pairsDo { |key, pat|
						if(pairs.includes(key).not) {
							pairs = pairs.add(key);
							pairs = pairs.add(pat);
						}
					}
				};

				src = PbindProxy.new(*pairs).quant_(pat.quant);
				pat.source = src
			};
		};

		^pat

	}

	storeArgs { ^[key]++pattern.storeArgs }
	repositoryArgs { ^this.storeArgs }
	quant_ { arg val; super.quant = val; source.quant = val }

	*hasGlobalDictionary { ^true }

*/
}