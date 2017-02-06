(function() {
    'use strict';

    angular
        .module('cs499Assignment2App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('employeemySuffix', {
            parent: 'entity',
            url: '/employeemySuffix',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Employees'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/employee/employeesmySuffix.html',
                    controller: 'EmployeeMySuffixController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('employeemySuffix-detail', {
            parent: 'entity',
            url: '/employeemySuffix/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Employee'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/employee/employeemySuffix-detail.html',
                    controller: 'EmployeeMySuffixDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Employee', function($stateParams, Employee) {
                    return Employee.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'employeemySuffix',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('employeemySuffix-detail.edit', {
            parent: 'employeemySuffix-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee/employeemySuffix-dialog.html',
                    controller: 'EmployeeMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Employee', function(Employee) {
                            return Employee.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('employeemySuffix.new', {
            parent: 'employeemySuffix',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee/employeemySuffix-dialog.html',
                    controller: 'EmployeeMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                firstName: null,
                                lastName: null,
                                email: null,
                                phoneNumber: null,
                                hireDate: null,
                                salary: null,
                                commissionPct: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('employeemySuffix', null, { reload: 'employeemySuffix' });
                }, function() {
                    $state.go('employeemySuffix');
                });
            }]
        })
        .state('employeemySuffix.edit', {
            parent: 'employeemySuffix',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee/employeemySuffix-dialog.html',
                    controller: 'EmployeeMySuffixDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Employee', function(Employee) {
                            return Employee.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('employeemySuffix', null, { reload: 'employeemySuffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('employeemySuffix.delete', {
            parent: 'employeemySuffix',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/employee/employeemySuffix-delete-dialog.html',
                    controller: 'EmployeeMySuffixDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Employee', function(Employee) {
                            return Employee.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('employeemySuffix', null, { reload: 'employeemySuffix' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
