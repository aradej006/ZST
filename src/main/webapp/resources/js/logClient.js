angular.module('logClient', ['ngAnimate', 'ui.bootstrap']);
angular.module('logClient').controller('ctrl', function ($scope, $http) {
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
        for(var i = 0; i< registerName.attributesQuantity;i++){
            $scope.atr.push("atr"+(i+1));
        }
    };

    $scope.refreshAttr = function(log){
        $scope.attr = [];
        for(var j = 0;j< log.attributesQuantity;j++){
            $scope.attr.push("atr"+(j+1));
        }
    };

    $scope.sendLog = function(log){
        return $http.post("/ZST/rest/log", log);
    };

    $scope.getLogTypes = function(){
        return $http.get("/ZST/rest/logType");
    };

    //$scope.




    $scope.send = function(log){
        var logMsg = {
            logDate : new Date(),
            logType: log.logType.logType,
            logRegister: log.registerName.registerName,
            sourceId: log.sourceId
        };
        for(var i = 0; i<log.registerName.attributesQuantity;i++){
            logMsg["atr"+(i+1)] = log["atr"+(i+1)];
        }

        $scope.sendLog(logMsg).success(function(response){
            $scope.getLogRegistry();
        });
    };

    $scope.getLogTypes().success(function(response){
        $scope.logType = response;
    });

    $scope.getLogs = function(){
        $http.get("/ZST/rest/log/all")
            .success(function(response){
                $scope.logs = response;
            }).error(function(error){
                console.log( error);
                return undefined;
            });
    };

    $scope.addLogType = function(logTypeName){
        var newType = {
            logType:logTypeName
        };
        $http.post("/ZST/rest/logType", newType)
            .success(function(response){
                $scope.getLogTypes();
            }).error(function(error){
                console.log( error);
            });
    };
    $scope.addLogType('SYSTEM');

    $scope.getRegisterNames = function(){
        $http.get("/ZST/rest/logRegister")
            .success(function(response){
                $scope.registerNames = response;
                $scope.registerName = $scope.registerNames[0];
                $scope.refreshAtr($scope.registerName);
            }).error(function(error){
                console.log( error);
            });
    };
    $scope.getRegisterNames();

    $scope.getLogRegistry =  function(){
        $scope.refreshAtr($scope.registerName);
        $http.get("/ZST/rest/log/"+$scope.registerName.registerName+"/get")
            .success(function (response) {
                $scope.logs = response;
            }).error(function (response) {
                console.log( response );
            });
    };

    $scope.addNewRegister = function(newRegister){
        if( newRegister.registerName != undefined && newRegister.attributesQuantity != undefined){
            $http.post("/ZST/rest/logRegister", newRegister)
                .success(function (response) {
                    $scope.getRegisterNames();
                }).error(function (response) {
                    console.log(response);
                });
        }
    }

    $scope.validNewRegister = function(newRegistry){
        if( newRegistry.registerName == undefined || newRegistry.registerName == '') $scope.invalidRegisterMessage = "Registry Name is required.";
        else if( newRegistry.attributesQuantity == undefined) $scope.invalidRegisterMessage = "Attributes Quantity must be between 1 to 10.";
        else $scope.invalidRegisterMessage = '';

    }

});