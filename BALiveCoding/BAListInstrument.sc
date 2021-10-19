BAListInstrument{
 	classvar <>server;
	var name;

	// Constructor

	*new{
		arg n;
		var obj;


		server = Server.local;
		obj = super.new;

		obj.init(n);

		//obj.initPattern;

		^obj;
	}

	init{|n|
"==============================DrumKit================================".postln;

	"===============percussions===============".postln;

	"\\kick1".postln;
	"\\kick2".postln;
	"\\snare".postln;
	"\\snareS".postln;
	"\\hihat1".postln;
	"\\hihat2".postln;

	"===================other synths==============".postln;

	"\\bass".postln;

"=============================BASynthGens==============================".postln;

	"=====================Pads=======================".postln;

	"\\pad".postln;
	"\\padS".postln;
	"\\spacePad".postln;
	"\\sinePad".postln;

	"========================Noise======================".postln;


		"\\noiseL1".postln;

		"\\nasty".postln;

	"========================FM=======================".postln;

		"\\fm".postln;

	"======================Granular===================".postln;


		"\\grain".postln;

	"=======================Sampling==================".postln;


		"\\samplerAn".postln;

	"=======================other====================".postln;



		"\\harpy01".postln;

		"\\harpy02".postln;

}
}
