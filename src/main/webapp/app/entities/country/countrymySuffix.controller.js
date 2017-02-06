(function() {
    'use strict';

    angular
        .module('cs499Assignment2App')
        .controller('CountryMySuffixController', CountryMySuffixController);

    CountryMySuffixController.$inject = ['$scope', '$state', 'Country'];

    function CountryMySuffixController ($scope, $state, Country) {
        var vm = this;

        vm.countries = [];

        loadAll();

        function loadAll() {
            Country.query(function(result) {
                vm.countries = result;
                vm.searchQuery = null;
            });
        }
    }
})();
