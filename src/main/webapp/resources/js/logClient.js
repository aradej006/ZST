angular.module('logClient', ['ngAnimate', 'ui.bootstrap']);
angular.module('logClient').controller('ctrl', function ($scope, $http, $interval) {
    $scope.sortType     = 'id'; // set the default sort type
    $scope.sortReverse  = false;  // set the default sort order
    $scope.searchLog = '';     // set the default search/filter term
    $scope.registerNames = [];
    $scope.registerName = {};
    $scope.atr = [];
    $scope.invalidRegisterMessage = '';
    $scope.attr = [];

    $scope.refreshAtr = function(registerName){
        $scope.atr = [];

        for(var i = 0; i< registerName.logAttributeNameDTOs.length;i++){
            $scope.atr.push(registerName.logAttributeNameDTOs[i]);
        }
    };

    $scope.refreshAttr = function(log){
        $scope.attr = [];
        for(var j = 0;j< log.logRegisterDTO.logAttributeNameDTOs.length;j++){
            $scope.attr.push(log.logRegisterDTO.logAttributeNameDTOs[j]);
        }
    };

    var logClient = {
        addLogType : function(logType){
            return $http.post("rest/logType", logType);
        },
        getLogTypes : function(){
            return $http.get("rest/logType");
        },
        sendLog : function(log){
            return $http.post("rest/log", log);
        },
        getAllLogs : function(){
            return $http.get("rest/log/all");
        },
        getLogs : function(registerName){
            return $http.get("rest/log/"+registerName+"/get");
        },

        getRegisterNames : function(){
            return $http.get("rest/logRegister");
        },
        addRegister : function(register){
            return $http.post("rest/logRegister", register);
        }
    };

    $scope.getLogClient = function(){
        return logClient;
    };

    $scope.send = function(log){
        log.logDate = new Date();
        var logMsg =angular.toJson(log);
        console.log(logMsg);
        logClient.sendLog(logMsg).success(function(response){
            //$scope.getLogRegistry();
        });
    };

    $scope.getLogTypes = function(){
        logClient.getLogTypes().success(function(result){
            $scope.logTypes = result;
        });
    };
    $scope.getLogTypes();

    $scope.getLogs = function(){
        logClient.getAllLogs().success(function(result){
            $scope.logs = response;
        });
    };

    $scope.addLogType = function(logTypeName){
        var newType = {
            logType:logTypeName
        };
        logClient.addLogType(newType).success(function(result){
            $scope.getLogTypes();
        });
    };

    $scope.getRegisterNames = function(){
        logClient.getRegisterNames()
            .success(function(response){
                $scope.registerNames = response;
                $scope.registerName = $scope.registerNames[0];
                $scope.refreshAtr($scope.registerName);
            });
    };
    $scope.getRegisterNames();

    $scope.getLogRegistry =  function(){
        $scope.refreshAtr($scope.registerName);
        logClient.getLogs($scope.registerName.registerName)
            .success(function (response) {
                $scope.logs = response;
            });
    };

    $scope.addNewRegister = function(newRegister){
        if( newRegister.registerName != undefined && newRegister.attributesQuantity != undefined){
            logClient.addRegister(newRegister)
                .success(function (response) {
                    $scope.getRegisterNames();
                });
        }
    };

    $scope.validNewRegister = function(newRegistry){
        if( newRegistry.registerName == undefined || newRegistry.registerName == '') $scope.invalidRegisterMessage = "Registry Name is required.";
        else if( newRegistry.attributesQuantity == undefined) $scope.invalidRegisterMessage = "Attributes Quantity must be between 1 to 10.";
        else $scope.invalidRegisterMessage = '';

    };

    $scope.generateLog = function(){
        var rand = Math.floor( Math.random()*100000 );

        var logMsg = {
            logDate : new Date(),
            logType: $scope.logTypes[rand%$scope.logTypes.length].logType,
            logRegister: $scope.registerNames[rand%$scope.registerNames.length].registerName,
            sourceId: rand
        };
        for(var i = 0; i<$scope.registerNames[rand%$scope.registerNames.length].attributesQuantity;i++){
            logMsg["atr"+(i+1)] = generateString(5);
        }
        $scope.generatedLog = logMsg;
            logClient.sendLog(logMsg).success(function(response){
        }).error(function(error){
                console.log(error);
            });
    };


    var stopGenerate;
    $scope.generateLogs = function(interval){

        if( angular.isDefined(stopGenerate) ) return;

        stopGenerate = $interval( $scope.generateLog, interval);

    };

    $scope.stopGenerating = function(){
        if( angular.isDefined(stopGenerate)){
            $interval.cancel(stopGenerate);
            stopGenerate = undefined;
        }
    };

    var generateString = function(length){
        var text = "";
        var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for( var i=0; i < length; i++ )
            text += possible.charAt(Math.floor(Math.random() * possible.length));

        return text;
    };

});