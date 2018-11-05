function opts(options){
	options.base64 = options.base64;
	return options;
}

module.exports = {
	    converttoWSQ: function (options, successCallback, errorCallback) {
	         var base64 = options.base64;
	        cordova.exec(successCallback, errorCallback, "WSQService", "converttoWSQ", [base64]);
	    }
}; 