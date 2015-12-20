'use strict';

app
.factory('Collaborateur', function ($resource, $filter) {
    return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/:id', {}, {
        'query': { method: 'GET', isArray: true},
        'get': {
            method: 'GET',

            transformResponse: function (data) {
                data = angular.fromJson(data);
                data.fichesobjectifs.forEach(function (entity) {
                    entity.dateFicheObjectifs = $filter('date')(entity.dateFicheObjectifs, 'yyyy-MM-dd');    

                });
                data.fichesevaluations.forEach(function (entity) {
                entity.dateEvaluation = $filter('date')(entity.dateEvaluation, 'yyyy-MM-dd');    
            });
                return data;
            }
        },
        'encadrant' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/encadrant/:id'
        },
        'manager' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/managerrh/:id'
        },

        'new' : { 
            method: 'POST', 
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/:idmanager'
        },

        'bap' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/bapstatut/:idencadrant/:statut'
        },
        'update': { method:'PUT' },

        'save': { method:'POST' }
    });
});
