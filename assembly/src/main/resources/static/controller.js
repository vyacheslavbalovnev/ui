angular.module('controller', [])
.controller('Controller', function($scope, $http) {
    $scope.list = [];
    $scope.color = {
        name: 'blue'
      };
    $http.get('/greeting').
        then(function(response) {
            $scope.greeting = response.data;

        });
    $scope.select = function() {
     $http.get('/select?query=' + $scope.color.name).
            then(function(response) {
                $scope.list = response.data;

            });
    };
});
