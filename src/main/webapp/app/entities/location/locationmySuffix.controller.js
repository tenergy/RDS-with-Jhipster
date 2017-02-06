(function() {
    'use strict';

    angular
        .module('cs499Assignment2App')
        .controller('LocationMySuffixController', LocationMySuffixController);

    LocationMySuffixController.$inject = ['$scope', '$state', 'Location'];

    function LocationMySuffixController ($scope, $state, Location) {
        var vm = this;

        vm.locations = [];

        loadAll();

        function loadAll() {
            Location.query(function(result) {
                vm.locations = result;
                vm.searchQuery = null;
            });
        }
    }
})();
