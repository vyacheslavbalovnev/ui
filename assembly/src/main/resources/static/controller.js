angular.module('controller', [])
.controller('Controller', function($scope, $http) {
    $scope.list = [];
    $scope.color = {
        name: 'UNSELECTED'
      };
    $http.get('/greeting').
        then(function(response) {
            $scope.greeting = response.data;

        });
    $scope.select = function() {
//    alert("click");

     $http.get('/select?query=' + $scope.color.name).
            then(function(response) {
                $scope.list = response.data;

            });
    };

     $scope.isDisabled = function() {
       return $scope.color.name == 'UNSELECTED';
     };
});
