var exec = require('cordova/exec');

var customBrowser = {
    open: function(url, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'CustomBrowser', 'open', [url]);
    }
};

module.exports = customBrowser;
