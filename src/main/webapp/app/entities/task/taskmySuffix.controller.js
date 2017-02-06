(function() {
    'use strict';

    angular
        .module('cs499Assignment2App')
        .controller('TaskMySuffixController', TaskMySuffixController);

    TaskMySuffixController.$inject = ['$scope', '$state', 'Task'];

    function TaskMySuffixController ($scope, $state, Task) {
        var vm = this;

        vm.tasks = [];

        loadAll();

        function loadAll() {
            Task.query(function(result) {
                vm.tasks = result;
                vm.searchQuery = null;
            });
        }
    }
})();
