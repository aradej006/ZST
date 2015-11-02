angular.module('logViewer', ['ngAnimate', 'ui.bootstrap']);
angular.module('logViewer').controller('ctrl',function ($scope, $http, $timeout) {
    $scope.sortType = 'id'; // set the default sort type
    $scope.sortReverse = false;  // set the default sort order
    $scope.searchLog = '';     // set the default search/filter term
    $scope.registerNames = [];
    $scope.registerName = {};
    $scope.addNewRegisterMsg = {value:'', color:'red'};
    $scope.addLogTypeMsg = {value:'', color:'red'};

    var timeout = 1000;


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

    //log
    $scope.send = function (log) {
        log.logDate = new Date();
        var logMsg = angular.toJson(log);
        logClient.sendLog(logMsg).success(function (response) {
            $scope.getLogRegistry();
        });
    };
    $scope.getLogs = function () {
        logClient.getAllLogs().success(function (result) {
            $scope.logs = response;
        });
    };
    $scope.deleteLog = function(log){
        logClient.deleteLog(log);
        $scope.logs.splice($scope.logs.indexOf(log),1);
    };
    $scope.getLogRegistry = function () {
        logClient.getLogs($scope.registerName.name)
            .success(function (response) {
                $scope.logs = response;
            });
    };

    //logType
    $scope.addLogType = function (newType) {
        logClient.addLogType(newType).success(function (result) {
            $scope.getLogTypes();
            $scope.addLogTypeMsg.value = 'Added';
            $scope.addLogTypeMsg.color = 'green';
            $timeout(function(){$scope.addLogTypeMsg.value = ''}, timeout);
        }).error(function(error){
            $scope.addLogTypeMsg.value = 'Error while adding new log type';
            $scope.addLogTypeMsg.color = 'red';
            console.log( error );
        });
        $scope.newType = {};
    };
    $scope.getLogTypes = function () {
        logClient.getLogTypes().success(function (result) {
            $scope.logTypes = result;
        });
    };
    $scope.getLogTypes();

    //registerName
    $scope.addNewRegister = function (newRegister) {
        if (newRegister.name != undefined) {
            logClient.addRegister(newRegister)
                .success(function (response) {
                    $scope.getRegisterNames();
                    $scope.addNewRegisterMsg.value = 'Added';
                    $scope.addNewRegisterMsg.value = 'green';
                    $timeout(function(){$scope.addNewRegisterMsg.value = ''}, timeout);
                }).error(function(error){
                    $scope.addNewRegisterMsg.value = 'Error while adding new register';
                    $scope.addNewRegisterMsg.color = 'red';
                    console.log( error );
                });
        }
        $scope.newRegister = {};
        $scope.invalidRegisterMessage = undefined;
        $scope.attributesQuantity = 1;
    };
    $scope.getRegisterNames = function () {
        logClient.getRegisterNames()
            .success(function (response) {
                $scope.registerNames = response;
                $scope.registerName = $scope.registerNames[0];
            });
    };
    $scope.getRegisterNames();

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

    //generateLogs
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
        $scope.countLogs++;
    };
    $scope.countLogs = 0;
    $scope.generateLogs = function (numberOfLogs) {
        for( var i=0; i<numberOfLogs;i++)
            $scope.generateLog();
    };
    var generateString = function (length) {
        var text = "";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (var i = 0; i < length; i++)
            text += possible.charAt(Math.floor(Math.random() * possible.length));

        return text;
    };
});