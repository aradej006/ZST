angular.module('logClient', ['ngAnimate', 'ui.bootstrap']);
angular.module('logClient').controller('ctrl', function ($scope, $http, $interval) {
    $scope.sortType = 'id'; // set the default sort type
    $scope.sortReverse = false;  // set the default sort order
    $scope.searchLog = '';     // set the default search/filter term
    $scope.registerNames = [];
    $scope.registerName = {};

    var logClient = {
        addLogType: function (logType) {
            return $http.post("rest/logType", logType);
        },
        getLogTypes: function () {
            return $http.get("rest/logType");
        },
        sendLog: function (log) {
            return $http.post("rest/log", log);
        },
        getAllLogs: function () {
            return $http.get("rest/log/all");
        },
        getLogs: function (registerName) {
            return $http.get("rest/log/" + registerName + "/get");
        },

        getRegisterNames: function () {
            return $http.get("rest/logRegister");
        },
        addRegister: function (register) {
            return $http.post("rest/logRegister", register);
        },
        deleteLog:function(log){
            return $http.post("rest/log/delete", log);
        }
    };

    $scope.getLogClient = function () {
        return logClient;
    };

    $scope.send = function (log) {
        log.logDate = new Date();
        var logMsg = angular.toJson(log);
        logClient.sendLog(logMsg).success(function (response) {
            $scope.getLogRegistry();
        });
    };

    $scope.getLogTypes = function () {
        logClient.getLogTypes().success(function (result) {
            $scope.logTypes = result;
        });
    };
    $scope.getLogTypes();

    $scope.deleteLog = function(log){
        logClient.deleteLog(log);
        $scope.logs.splice($scope.logs.indexOf(log),1);
    };

    $scope.getLogs = function () {
        logClient.getAllLogs().success(function (result) {
            $scope.logs = response;
        });
    };

    $scope.addLogType = function (newType) {
        logClient.addLogType(newType).success(function (result) {
            $scope.getLogTypes();
        });
        $scope.newType = {};
    };

    $scope.getRegisterNames = function () {
        logClient.getRegisterNames()
            .success(function (response) {
                $scope.registerNames = response;
                $scope.registerName = $scope.registerNames[0];
            });
    };
    $scope.getRegisterNames();

    $scope.getLogRegistry = function () {
        logClient.getLogs($scope.registerName.name)
            .success(function (response) {
                $scope.logs = response;
            });
    };


    $scope.addNewRegister = function (newRegister) {
        if (newRegister.name != undefined) {
            logClient.addRegister(newRegister)
                .success(function (response) {
                    $scope.getRegisterNames();
                });
        }
        $scope.newRegister = {};
        $scope.invalidRegisterMessage = undefined;
        $scope.attributesQuantity = 1;
    };

    $scope.validNewRegister = function (newRegistry, attributesQuantity) {
        $scope.invalidRegisterMessage = '';
        if (newRegistry.name == undefined || newRegistry.name == '') $scope.invalidRegisterMessage = "Registry Name is required.";
        else if (attributesQuantity == undefined) $scope.invalidRegisterMessage = "Attributes Quantity must be between 1 to 15.";
        angular.forEach(newRegistry.logAttributeNameDTOs, function(attribute){
            if(attribute.name == undefined || attribute.name == '') $scope.invalidRegisterMessage = "All attributes must be inserted."
        });
    };

    $scope.refreshNewRegisterInputs = function(newRegistry, attributesQuantity){
        newRegistry.logAttributeNameDTOs = [];
        if (attributesQuantity != undefined && attributesQuantity > 0) {
            attributesQuantity = Math.floor(attributesQuantity);
            if (attributesQuantity > 0) {
                for (var i = 0; i < attributesQuantity; i++) {
                    newRegistry.logAttributeNameDTOs[i] = {name: undefined};
                }
            }
        }
    };

    $scope.generateLog = function () {
        var rand = Math.floor(Math.random() * 100000);
        var logMsg = {
            logDate: new Date(),
            logTypeDTO:$scope.logTypes[rand % $scope.logTypes.length],
            sourceId: rand,
            logRegisterDTO:$scope.registerNames[rand % $scope.registerNames.length]
        };
        logMsg.logAttributeDTOs = [];
        for (var i = 0; i < logMsg.logRegisterDTO.logAttributeNameDTOs.length; i++) {
            logMsg.logAttributeDTOs[i] = { value: generateString(5)};
        }
        $scope.generatedLog = logMsg;
        logClient.sendLog(logMsg).success(function (response) {
        });
    };





    var stopGenerate;
    $scope.generateLogs = function (interval) {

        if (angular.isDefined(stopGenerate)) return;

        stopGenerate = $interval($scope.generateLog, interval);

    };

    $scope.stopGenerating = function () {
        if (angular.isDefined(stopGenerate)) {
            $interval.cancel(stopGenerate);
            stopGenerate = undefined;
        }
    };

    var generateString = function (length) {
        var text = "";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (var i = 0; i < length; i++)
            text += possible.charAt(Math.floor(Math.random() * possible.length));

        return text;
    };

});